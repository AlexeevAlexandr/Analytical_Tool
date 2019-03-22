package com.example.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

abstract class Line extends Templates {
    private String questionType;
    private String category = "";
    private String subCategory = "";

    private String service;
    private String variation = "";
    String typeOfAnswer;
    Date dateFrom;
    int time;

    void setService(String service) {
        String[] items = service.split("\\.");
        this.service = items[0];

        if (items.length == 2) {
            variation = items[1];
        }
    }

    void setQuestion(String question) {
        String[] items = question.split("\\.");

        //set type
        questionType = items[0];

        //set category
        if (items.length > 1 ) {
            category = items[1];
        }

        //set subcategory
        if (items.length == 3) {
            subCategory = items[2];
        }
    }

    Date parseDate(String date) {
        try {
            return new SimpleDateFormat("dd.MM.yyyy").parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    void setDataFrom(String dataFrom) {
        this.dateFrom = parseDate(dataFrom);
    }

    public String getService() {
        return service;
    }

    public String getVariation() {
        return variation;
    }

    public String getQuestionType() {
        return questionType;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    Date getDateFrom() {
        return dateFrom;
    }

    public int getTime() {
        return time;
    }
}