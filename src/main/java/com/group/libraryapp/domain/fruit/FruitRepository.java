package com.group.libraryapp.domain.fruit;

import com.group.libraryapp.dto.homework.day4.mapper.FruitStatusTotalAmount;
import com.group.libraryapp.dto.homework.day4.response.FruitResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    List<Fruit> findAllByNameAndIsSold(String name, boolean isSold);

    long countByName(String name);

    List<FruitResponse> findAllByPriceGreaterThanEqual(Long price);
    List<FruitResponse> findAllByPriceLessThanEqual(Long price);


}
