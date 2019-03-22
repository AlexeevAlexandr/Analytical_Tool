package com.example.service;

import com.example.model.LineC;
import com.example.model.LineD;

import java.util.List;

public class AnalyticalTool {

    public String toAppreciate(String inputString) {
        Parser parser = new Parser();

        parser.validData(inputString);

        StringBuilder result = new StringBuilder();
        for(LineD lineD : parser.getListLine_D()){
            List<LineC> listC = parser.getListLine_C(parser.createTemplateForSearch(lineD));
            int sum = 0;
            int counter = 0;
            for(LineC lineC : listC) {
                if (lineD.isDateIn(lineC)) {
                    sum += lineC.getTime();
                    counter++;
                }
            }
            result.append((counter == 0) ?  "-" : String.valueOf(sum/counter)).append(" ");
        }
        return result.toString();
    }
}
