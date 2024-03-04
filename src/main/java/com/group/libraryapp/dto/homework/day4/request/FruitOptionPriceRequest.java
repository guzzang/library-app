package com.group.libraryapp.dto.homework.day4.request;

public class FruitOptionPriceRequest {

    private String option;

    private long price;

    public FruitOptionPriceRequest(String option, long price) {
        this.option = option;
        this.price = price;
    }

    public String getOption() {
        return option;
    }

    public long getPrice() {
        return price;
    }


}
