package com.group.libraryapp.service.fruit;

import com.group.libraryapp.domain.fruit.Fruit;
import com.group.libraryapp.domain.fruit.FruitRepository;
import com.group.libraryapp.dto.homework.day4.request.FruitCreateRequest;
import com.group.libraryapp.dto.homework.day4.request.FruitOptionPriceRequest;
import com.group.libraryapp.dto.homework.day4.request.FruitUpdateRequest;
import com.group.libraryapp.dto.homework.day4.response.FruitCountResponse;
import com.group.libraryapp.dto.homework.day4.response.FruitResponse;
import com.group.libraryapp.dto.homework.day4.response.FruitSalesAmountResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceV2 {

    private final FruitRepository fruitRepository;

    public FruitServiceV2(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }
    public void saveFruit(FruitCreateRequest request){
        fruitRepository.save(new Fruit(request.getName(), request.getWarehousingDate(),request.getPrice()));
    }

    public FruitSalesAmountResponse getSalesAmount(String name){
        List<Fruit> salesFruit = fruitRepository.findAllByNameAndIsSold(name, true);
        List<Fruit> NotSalesFruit = fruitRepository.findAllByNameAndIsSold(name, false);

        long salesAmount = salesFruit.stream()
                .mapToLong(Fruit::getPrice)
                .sum();

        long notSalesAmount = NotSalesFruit.stream()
                .mapToLong(Fruit::getPrice)
                .sum();



        return new FruitSalesAmountResponse(salesAmount, notSalesAmount);
    }

    public void updateFruit(FruitUpdateRequest request){

        Fruit fruit = fruitRepository.findById(request.getId()).orElseThrow(IllegalAccessError::new);

        fruit.SaleStatusToSold();
        fruitRepository.save(fruit);
    }

    public FruitCountResponse countHowManyFruits(String name) {

        long count = fruitRepository.countByName(name);
        return new FruitCountResponse(count);

    }

    public List<FruitResponse> getListOfConditionedFruit(FruitOptionPriceRequest request) {
        if(request.getOption().equals("GTE")){
            return fruitRepository.findAllByPriceGreaterThanEqual(request.getPrice());
        } else if (request.getOption().equals("LTE")) {
            return fruitRepository.findAllByPriceLessThanEqual(request.getPrice());
        } else {
            throw new IllegalArgumentException();
        }
    }
}
