package com.example.model;

import org.jetbrains.annotations.NotNull;
import java.util.Date;

public class LineD extends Line{

    private Date dateTo = null;

    public LineD(@NotNull String line) {
        super();

        if (!line.matches(lineDTemplate)) {
            throw new IllegalArgumentException("Incorrect line format!");
        }

        String[] parameters = line.split(" ");

        super.setService(parameters[1]);
        super.setQuestion(parameters[2]);
        typeOfAnswer = parameters[3];

        String[] dates = parameters[4].split("-");
        super.setDataFrom(dates[0]);

        if (dates.length > 1) {
            dateTo = parseDate(dates[1]);
        }
    }

    public boolean isDateIn(LineC c) {
        return ((dateTo == null) && (c.getDateFrom().equals(dateFrom))) || !c.getDateFrom().before(dateFrom) && !c.getDateFrom().after(dateTo);
    }
}