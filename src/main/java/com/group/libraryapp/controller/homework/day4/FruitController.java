package com.group.libraryapp.controller.homework.day4;

import com.group.libraryapp.dto.homework.day4.request.FruitCreateRequest;
import com.group.libraryapp.dto.homework.day4.request.FruitOptionPriceRequest;
import com.group.libraryapp.dto.homework.day4.request.FruitUpdateRequest;
import com.group.libraryapp.dto.homework.day4.response.FruitCountResponse;
import com.group.libraryapp.dto.homework.day4.response.FruitResponse;
import com.group.libraryapp.dto.homework.day4.response.FruitSalesAmountResponse;
import com.group.libraryapp.service.fruit.FruitServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FruitController {


    private final FruitServiceV2 fruitService;

    public FruitController(FruitServiceV2 fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping("/api/v1/fruit")
    public void saveFruit(@RequestBody FruitCreateRequest request){
        fruitService.saveFruit(request);
        }

    @PutMapping("/api/v1/fruit")
    public void updateFruit(@RequestBody FruitUpdateRequest request){
        fruitService.updateFruit(request);
        }

    @GetMapping("/api/v1/fruit")
    public FruitSalesAmountResponse getSalesAmount(@RequestParam String name){
        return fruitService.getSalesAmount(name);
    }

    @GetMapping("/api/v1/fruit/count")
    public FruitCountResponse countHowManyFruits(@RequestParam String name){
        return fruitService.countHowManyFruits(name);
    }

    @GetMapping("/api/v1/fruit/list")
    public List<FruitResponse> getListOfFruit(FruitOptionPriceRequest request){
        return fruitService.getListOfConditionedFruit(request);
    }




}
