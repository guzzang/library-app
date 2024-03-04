package com.group.libraryapp.dto.homework.day4.request;

import java.time.LocalDate;

public class FruitCreateRequest {

    private String name;

    private LocalDate warehousingDate;

    private long price;

    private boolean isSold;


    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public long getPrice() {
        return price;
    }

    public boolean isSold() {
        return isSold;
    }

}
