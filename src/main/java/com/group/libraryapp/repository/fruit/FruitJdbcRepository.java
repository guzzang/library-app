package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.homework.day4.mapper.FruitStatusTotalAmount;
import com.group.libraryapp.dto.homework.day4.request.FruitCreateRequest;

import java.util.List;

public interface FruitJdbcRepository {

    void saveFruit(FruitCreateRequest request);

    List<FruitStatusTotalAmount> getSalesAmount(String name);

    // saveFruit(JdbcTemplate jdbcTemplate, FruitCreateRequest request)
    // parameter로 dto를 바로 넘겨줘도 괜찮지만 dto의 field를 다 사용하는게 아니라 dto의 field 몇개만 사용하는 것이면 개별적으로 넘겨줘도 된다.

    void updateFruit(long id);

}
