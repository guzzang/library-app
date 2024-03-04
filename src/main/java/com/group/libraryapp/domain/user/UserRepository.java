package com.group.libraryapp.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByName(String name);

    // 함수 이름만 작성하면 알아서 sql 문이 조립되어진다.
    // findByName -< select * from user where name = ?
    // By 뒤에 붙는 이름으로 where 문의 파라미터가 결정

    // By 앞에 올 수 있는 단어
    // find : 1건의 데이터를 반환 , 반환 타입은 객체거나 Optional<타입>
    // findAll : N개의 데이터 반환 , 반환 타입은 List<타입>
    // exists : 쿼리 결과가 존재하는지 확인 반환 타입은 boolean
    // count : sql의 결과 개수를 센다. 반환 타입은 long

    // By 뒤에 오는 단어들은 And 나 Or로 조합할 수 있다.
    // List<User> findAllByAgeBetween(int startAge, int endAge) -> select * from user where age between ? and ?

}
