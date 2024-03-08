package com.group.libraryapp.dto.team.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TeamResponse {

    private String name; // 팀 이름

    private String manager; // 팀 매니저 이름

    private int memberCount; // 팀원 수

}
