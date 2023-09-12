package com.finaceproject.model.dto;

public class CardDto {
    private String title;
    private String sum;
    private String currency;

    public CardDto(String title, String sum, String currency) {
        this.title = title;
        this.sum = sum;
        this.currency = currency;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
