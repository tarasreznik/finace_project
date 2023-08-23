package com.finaceproject.model.dto;

import com.finaceproject.model.dao.IncomeCategory;

public class IncomeDto {
    private String id;
    private String date;
    private String comment;
    private IncomeCategory category;

    public IncomeDto() {
    }

    public IncomeDto(String id, String date, String comment, IncomeCategory category) {
        this.id = id;
        this.date = date;
        this.comment = comment;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public IncomeCategory getCategory() {
        return category;
    }

    public void setCategory(IncomeCategory category) {
        this.category = category;
    }
}
