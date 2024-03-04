package com.group.libraryapp.dto.homework.day2.request;

import java.time.LocalDate;

public class DateRequest {

    private LocalDate date;

    public DateRequest(String date) {
        this.date = LocalDate.parse(date);
    }
    // LocalDate.parse(date) 이 코드를 적어주지 않으면 type이 맞지 않아 오류 발생
    // String을 LocalDate로 변환

    public LocalDate getDate() {
        return date;
    }

}
