package com.group.libraryapp.dto.member.request;

import com.group.libraryapp.domain.member.Role;
import jakarta.persistence.Column;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberCreateRequest {

    private String memberName;

    private String teamName;

    private Role role;

    private LocalDate birthday;

    private LocalDate workStartDate;




}
