package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.dto.homework.day4.mapper.FruitStatusTotalAmount;
import com.group.libraryapp.dto.homework.day4.request.FruitCreateRequest;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Primary
@Repository
public class FruitMySqlRepository implements FruitJdbcRepository {

    private JdbcTemplate jdbcTemplate;

    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveFruit(FruitCreateRequest request){
        String sql = "INSERT INTO fruit(name, warehousingdate, price) VALUES(?,?,?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    public List<FruitStatusTotalAmount> getSalesAmount(String name){
        String sql = "SELECT isSold, SUM(price) AS totalPrice FROM fruit WHERE name = ? GROUP BY isSold";
        return jdbcTemplate.query(sql, new RowMapper<FruitStatusTotalAmount>() {
            @Override
            public FruitStatusTotalAmount mapRow(ResultSet rs, int rowNum) throws SQLException {
                boolean isSold = rs.getBoolean("isSold");
                long totalPrice = rs.getLong("totalPrice");
                return new FruitStatusTotalAmount(isSold, totalPrice);
            }
        },name);
    }

    // saveFruit(JdbcTemplate jdbcTemplate, FruitCreateRequest request)
    // parameter로 dto를 바로 넘겨줘도 괜찮지만 dto의 field를 다 사용하는게 아니라 dto의 field 몇개만 사용하는 것이면 개별적으로 넘겨줘도 된다.

    public void updateFruit(long id){
        String sql = "UPDATE fruit SET isSold = True WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public static void main(String[] args) {
        System.out.println("Sql");
    }

}
