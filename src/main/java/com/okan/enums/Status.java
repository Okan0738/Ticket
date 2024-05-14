package com.okan.enums;

public enum Status {
    OPEN ("Open"),IN_PROGRESS("In Progress"),COMPLETED("Complated");

    private String value;

    public String getValue() {
        return value;
    }
    Status(String value) {
        this.value = value;
    }
}
