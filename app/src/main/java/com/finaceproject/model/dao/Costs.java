package com.finaceproject.model.dao;

public class Costs {
    private String id;
    private String date;
    private String comment;
    private CostsCategory category;

    public Costs() {
    }

    public Costs(String id, String date, String comment, CostsCategory category) {
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

    public CostsCategory getCategory() {
        return category;
    }

    public void setCategory(CostsCategory category) {
        this.category = category;
    }
}
