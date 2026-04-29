package com.example.detran.model.enums;

public enum Category {
    CATEGORYA("CATEGORYA"),
    CATEGORYB("CATEGORYB"),
    CATEGORYAB("CATEGORYAB");

    private String description; 

    Category(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
