package com.finaceproject.model.dto;

public class CardBigDto {
    private String date;
    private String sum;
    private String currency;
    private String comment;

    public CardBigDto(String date, String sum, String currency, String comment) {
        this.date = date;
        this.sum = sum;
        this.currency = currency;
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
