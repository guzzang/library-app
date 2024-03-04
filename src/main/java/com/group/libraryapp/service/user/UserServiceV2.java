package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // @Transactional 아래 함수 시작시 trasaction을 시작
    // 함수의 동작이 예외없이 완료되면 commit
    // 문제가 발생되면 rollback
    // checked exception은 rollback이 되지 않음
    @Transactional
    public void saveUser(UserCreateRequest request){
        userRepository.save(new User(request.getName(), request.getAge()));

        // save : 주어지는 객체 저장
        // 위 코드는 User를 반환
    }

    @Transactional(readOnly = true) // 조회만 하는 로직에선 readOnly = true 를 추가해 성능상 이점을 얻을 수 있음
    public List<UserResponse> getUsers(){
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponse(user.getId(),user.getName(),user.getAge()))
                .collect(Collectors.toList());
    }

    // findAll : 주어진 객체가 매핑된 테이블의 모든 데이터를 가져옴
    // map(user -> new UserResponse(user.getId(),user.getName(),user.getAge())) -> map(UserResponse:new)로 변경 가능
    // public UserResponse(User user){
    //        this.id = user.getId();
    //        this.name = user.getName();
    //        this.age = user.getAge();
    //    } 생성자만 만들어주면

    @Transactional
    public void updateUser(UserUpdateRequest request){
        User user = userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

        user.updateName(request.getName());
        //userRepository.save(user);
        // Entity 정보의 변경이 일어나면 영속성 컨텍스트의 변경 감지 기능이 알아서 save 해주기때문에 명시적으로 save 해줄 필요가 없다.
    }

    // userRepository.findById(request.getId()) -> select * from user where id = ? return 은 Optional<User>
    // orElseThrow -> 탐색 결과 없다면 에러, 있다면

    @Transactional
    public void deleteUser(String name){
        // SELECT * FROM user WHERE name = ?
        // user가 있으면 User 객체 반환 없으면 null 반환
        User user = userRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);

        userRepository.delete(user);
    }

}
