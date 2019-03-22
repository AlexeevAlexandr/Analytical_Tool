package com.example.model;

public abstract class Templates {

    protected final String dateTemplate = "\\d{1,2}\\.\\d{1,2}\\.\\d{4}";
    protected final String serviceTemplate = "\\d*(\\.\\d*)?";
    protected final String questionTemplate = "\\d*(\\.\\d*(\\.\\d*)?)?";
    protected final String lineCTemplate = "C " + serviceTemplate + " " + questionTemplate + " ([PN]) " + dateTemplate + " \\d*";
    protected final String lineDTemplate = "D (" + serviceTemplate + "|\\*) (" + questionTemplate + "|\\*) ([PN]) " + dateTemplate + "(-" + dateTemplate + ")?";
    protected final String validStingTemplate = "^\\d*(( " + lineCTemplate +")|( " + lineDTemplate + "))*";
}