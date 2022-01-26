package com.itsz.java.design.pattern.exercise;

public enum Mark {

    FRAGILE("**MARK FRAGILE**"),
    DO_NOT_LEAVE("**MARK DO NOT LEAVE IF ADDRESS NOT AT HOME**"),
    RETURN_RECEIPT_REQUESTED("**MARK RETURN RECEIPT REQUESTED**");

    private String description;

    Mark(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
