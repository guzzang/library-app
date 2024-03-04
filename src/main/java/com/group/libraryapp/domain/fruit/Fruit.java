package com.group.libraryapp.domain.fruit;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(name = "warehousingdate", nullable = false)
    private LocalDate warehousingDate;

    @Column(nullable = false)
    private Long price;

    @Column(name = "is_sold", nullable = false)
    private boolean isSold;

    public Fruit(String name, LocalDate warehousingDate, Long price) {
        this.name = name;
        this.warehousingDate = warehousingDate;
        this.price = price;
        this.isSold = false;
    }

    protected Fruit(){

    }

    // jpa 사용을 위해선 기본생성자를 생성해줘야 함

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getWarehousingDate() {
        return warehousingDate;
    }

    public Long getPrice() {
        return price;
    }

    public boolean isSold() {
        return isSold;
    }


    public void SaleStatusToSold() {
        isSold = true;
    }
}
