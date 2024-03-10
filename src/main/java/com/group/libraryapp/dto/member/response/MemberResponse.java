package com.group.libraryapp.dto.member.response;

import com.group.libraryapp.domain.member.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class MemberResponse {

    private String name; // 직원 이름

    private String teamName;

    private Role role;

    private LocalDate birthday;

    private LocalDate workStartDate;


}
