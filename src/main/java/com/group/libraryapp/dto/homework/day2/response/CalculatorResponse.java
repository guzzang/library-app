package com.group.libraryapp.dto.homework.day2.response;

import com.group.libraryapp.dto.homework.day2.request.CalculatorRequest;

public class CalculatorResponse {

    private int sum;
    private int minus;
    private int multiply;

    public CalculatorResponse(CalculatorRequest request) {
        this.sum = request.getNumber1() + request.getNumber2();
        this.minus = request.getNumber1() - request.getNumber2();
        this.multiply = request.getNumber1() * request.getNumber2();
    }

    public int getSum() {
        return sum;
    }

    public int getMinus() {
        return minus;
    }

    public int getMultiply() {
        return multiply;
    }
}
