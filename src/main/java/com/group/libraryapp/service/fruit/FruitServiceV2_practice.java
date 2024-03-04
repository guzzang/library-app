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
import java.util.Optional;

@Service
public class FruitServiceV2_practice {

    private final FruitRepository fruitRepository;

    public FruitServiceV2_practice(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }
    public void saveFruit(FruitCreateRequest request){
        fruitRepository.save(new Fruit(request.getName(), request.getWarehousingDate(), request.getPrice()));
    }


    public FruitSalesAmountResponse getSalesAmount(String name){
        List<Fruit> soldFruits = fruitRepository.findAllByNameAndIsSold(name, true);
        List<Fruit> notSoldFruits = fruitRepository.findAllByNameAndIsSold(name, false);

        long salesAmount = soldFruits.stream()
                .mapToLong(Fruit::getPrice)
                .sum();

        long notSalesAmount = notSoldFruits.stream()
                .mapToLong(Fruit::getPrice)
                .sum();

        return new FruitSalesAmountResponse(salesAmount, notSalesAmount);
    }

    public void updateFruit(FruitUpdateRequest request){

        Fruit fruit = fruitRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        fruit.SaleStatusToSold();
        fruitRepository.save(fruit);

    }

    public FruitCountResponse countHowManyFruits(String name) {
        long count = fruitRepository.countByName(name);
        return new FruitCountResponse(count);
    }

    public List<FruitResponse> getListOfConditionedFruit(FruitOptionPriceRequest request) {
        if (request.getOption().equals("GTE")){
            return fruitRepository.findAllByPriceGreaterThanEqual(request.getPrice());
        } else if (request.getOption().equals("LTE")) {
            return fruitRepository.findAllByPriceLessThanEqual(request.getPrice());
        }else {
            throw new IllegalArgumentException();
        }
    }

    }
