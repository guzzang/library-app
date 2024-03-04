package com.group.libraryapp.dto.homework.day4.mapper;

public class FruitStatusTotalAmount {

    private boolean isSold;
    private long totalPrice;

    public FruitStatusTotalAmount(boolean isSold, long totalPrice) {
        this.isSold = isSold;
        this.totalPrice = totalPrice;
    }

    public boolean isSold() {
        return isSold;
    }

    public long getTotalPrice() {
        return totalPrice;
    }
}
