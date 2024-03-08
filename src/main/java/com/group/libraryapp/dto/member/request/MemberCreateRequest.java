package com.group.libraryapp.dto.member.request;

import jakarta.persistence.Column;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class MemberCreateRequest {

    private String memberName;

    private String teamName;

    private String role;

    private LocalDate birthday;

    private LocalDate workStartDate;




}
