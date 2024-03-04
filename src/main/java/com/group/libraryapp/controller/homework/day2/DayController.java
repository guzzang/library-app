package com.group.libraryapp.controller.homework.day2;

import com.group.libraryapp.dto.homework.day2.request.DateRequest;
import com.group.libraryapp.dto.homework.day2.response.DateResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.DayOfWeek;
import java.time.LocalDate;

@RestController
public class DayController {

    @GetMapping("/api/v1/day-of-the-week")
    public DateResponse getDayOfTheWeek(DateRequest dateRequest){
        LocalDate date = dateRequest.getDate();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return new DateResponse(dayOfWeek);
    }


}
