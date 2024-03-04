package com.group.libraryapp.controller.homework.day2;

import com.group.libraryapp.dto.homework.day2.request.CalculatorRequest;
import com.group.libraryapp.dto.homework.day2.response.CalculatorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {

    @GetMapping("/api/v1/calc")
    public CalculatorResponse calculateTwoNumbers(CalculatorRequest request){
        return new CalculatorResponse(request);
    }

}
