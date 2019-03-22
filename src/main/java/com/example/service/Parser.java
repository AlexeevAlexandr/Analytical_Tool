package com.example.service;

import com.example.model.LineC;
import com.example.model.LineD;
import com.example.model.Templates;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser extends Templates {

    private String inputString;

    void validData(String inputString) {
        this.inputString = inputString;

        if ( ! inputString.matches(validStingTemplate)) {
            throw new IllegalArgumentException("Line structure is incorrect");
        }

        int numberOfLines = getExpectedNumberOfLines(inputString);
        int actuallySize = getListLine_C(lineCTemplate).size() + getListLine_D().size();

        if (numberOfLines != actuallySize) {
            throw new IllegalArgumentException(String.format("Expected and actual number of lines do not match!!! Expected: %s, actually: %s", numberOfLines, actuallySize));
        }
    }

    private int getExpectedNumberOfLines(@NotNull String inputString) {
        int indexOfFirstSpace = inputString.indexOf(" ");
        return Integer.parseInt(inputString.substring(0,indexOfFirstSpace));
    }

    List<LineC> getListLine_C(String tmpl) {
        List<LineC> resultList = new ArrayList<>();

        Matcher matcher = Pattern.compile(tmpl).matcher(inputString);
        while (matcher.find()) {
            resultList.add(new LineC(inputString.substring(matcher.start(), matcher.end()).trim()));
        }
        return resultList;
    }

    List<LineD> getListLine_D() {
        List<LineD> resultList = new ArrayList<>();

        Matcher matcher = Pattern.compile(lineDTemplate).matcher(inputString);
        while (matcher.find()) {
            resultList.add(new LineD(inputString.substring(matcher.start(), matcher.end()).trim()));
        }
        return resultList;
    }

    String createTemplateForSearch(LineD line_D) {
        StringBuilder template = new StringBuilder("C ");

        if ((line_D.getService()).equals("*")) {
            template.append(serviceTemplate).append(" ");
        } else if ((line_D.getVariation()).equals("")) {
            template.append(String.format("((%s)|(%s.\\d*)?) ", line_D.getService(), line_D.getService()));
        } else {
            template.append(String.format("%s.%s ",line_D.getService(), line_D.getVariation()));
        }

        if ((line_D.getQuestionType()).equals("*")) {
            template.append(questionTemplate).append(" ");
        } else if ((line_D.getCategory()).equals("") && line_D.getSubCategory().equals("")) {
            template.append(String.format("(%s(\\.\\d*(\\.\\d*)?)?) ", line_D.getQuestionType()));
        } else if ((line_D.getSubCategory()).equals("")){
            template.append(String.format("(%s(\\.%s(\\.\\d*)?)?) ", line_D.getQuestionType(), line_D.getCategory()));
        } else {
            template.append(String.format("(%s(\\.%s(\\.%s)?)?) ", line_D.getQuestionType(), line_D.getCategory(), line_D.getSubCategory()));
        }

        return template.append("(P|N) ").append(dateTemplate).append(" \\d*").toString();
    }
}