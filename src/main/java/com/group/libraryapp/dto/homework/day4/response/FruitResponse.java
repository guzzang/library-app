package com.group.libraryapp.dto.homework.day4.response;

import java.time.LocalDate;

public class FruitResponse {

    private String name;
    private long price;
    private LocalDate warehousingDate;

    public FruitResponse(String name, long price, LocalDate warehousingDate) {
        this.name = name;
        this.price = price;
        this.warehousingDate = warehousingDate;
    }

    // 필드변수를 매개변수로 사용한 생성자가 하나라도 존재하면 생성자 형식대로 데이터가 입력되어지는듯 하다.
    // 기본생성자만 있다면 x

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

}
