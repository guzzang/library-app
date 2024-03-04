package com.group.libraryapp.service.fruit;

import com.group.libraryapp.dto.homework.day4.mapper.FruitStatusTotalAmount;
import com.group.libraryapp.dto.homework.day4.request.FruitCreateRequest;
import com.group.libraryapp.dto.homework.day4.request.FruitUpdateRequest;
import com.group.libraryapp.dto.homework.day4.response.FruitSalesAmountResponse;
import com.group.libraryapp.repository.fruit.FruitJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {

    private final FruitJdbcRepository fruitRepository;

    public FruitService(FruitJdbcRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }
    public void saveFruit(FruitCreateRequest request){
        fruitRepository.saveFruit(request);
    }

    public FruitSalesAmountResponse getSalesAmount(String name){
        List<FruitStatusTotalAmount> query = fruitRepository.getSalesAmount(name);
        long salesAmount = 0;
        long notSalesAmount = 0;

        for (FruitStatusTotalAmount result : query) {
            if(result.isSold()){
                salesAmount = result.getTotalPrice();
            }
            else {
                notSalesAmount = result.getTotalPrice();
            }
        }

        FruitSalesAmountResponse fruitSalesAmountResponse = new FruitSalesAmountResponse(salesAmount, notSalesAmount);
        return fruitSalesAmountResponse;
    }

    public void updateFruit(FruitUpdateRequest request){
        fruitRepository.updateFruit(request.getId());
    }

}
