package com.example.model;

import org.jetbrains.annotations.NotNull;

public class LineC extends Line {

    public LineC(@NotNull String line) {
        super();

        if ( ! line.matches(lineCTemplate)) {
            throw new IllegalArgumentException("Incorrect format of line !!!");
        }

        String[] parameters = line.split(" ");

        super.setService(parameters[1]);
        super.setQuestion(parameters[2]);
        super.setDataFrom(parameters[4]);
        typeOfAnswer = parameters[3];
        time = Integer.parseInt(parameters[5]);
    }
}