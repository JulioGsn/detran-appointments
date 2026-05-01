package com.example.detran.model.enums;

public enum LicenseCategory {
    CATEGORYA("CATEGORYA"),
    CATEGORYB("CATEGORYB"),
    CATEGORYAB("CATEGORYAB");

    private String description; 

    LicenseCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
