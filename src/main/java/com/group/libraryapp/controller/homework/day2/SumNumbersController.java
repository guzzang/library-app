package com.group.libraryapp.controller.homework.day2;

import com.group.libraryapp.dto.homework.day2.request.NumberListRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SumNumbersController {

    @PostMapping("/api/v1/sum")
    public int sumNumbers(@RequestBody NumberListRequest request){

        List<Integer> numbers = request.getNumbers();

        int sum = 0;
        for(int i = 0; i < numbers.size(); i++){
            sum += numbers.get(i);
        }

        return sum;

    }

}
