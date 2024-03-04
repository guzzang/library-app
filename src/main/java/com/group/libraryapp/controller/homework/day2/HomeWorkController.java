package com.group.libraryapp.controller.homework.day2;

import com.group.libraryapp.dto.homework.day2.request.CalculatorRequest;
import com.group.libraryapp.dto.homework.day2.request.DateRequest;
import com.group.libraryapp.dto.homework.day2.request.NumberListRequest;
import com.group.libraryapp.dto.homework.day2.response.CalculatorResponse;
import com.group.libraryapp.dto.homework.day2.response.DateResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Controller
public class HomeWorkController {

    @GetMapping("/calc")
    public CalculatorResponse CalculateTwoNumbers(CalculatorRequest request){
        return new CalculatorResponse(request);
    }

    @GetMapping("/day-of-the-week")
    public DateResponse geyDayofTheWeek(DateRequest request){
        LocalDate date = request.getDate();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return new DateResponse(dayOfWeek);
    }

    @PostMapping("/sum")
    public int SumListNumbers(@RequestBody NumberListRequest request){
        int sum = 0;

        List<Integer> numbers = request.getNumbers();
        for(int i = 0; i < numbers.size(); i++){
            sum += numbers.get(i);
        }

        return sum;
    }

}
