package com.group.libraryapp.domain.team;

import com.group.libraryapp.domain.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "team_name")
    private String teamName; // 필수 속성
    private String manager; // null 허용
    @Column(name = "member_count")
    private int memberCount;

    @OneToMany(mappedBy = "team")
    private List<Member> members;

    public Team(String teamName) {

        if(teamName == null || teamName.isBlank()){
            throw new IllegalArgumentException("팀 이름을 입력해주세요");
        }

        this.teamName = teamName;
        this.manager = null;
        this.memberCount = 0;
    }

    public void setManager(String manager) {

        checkConditionAndEnrollNewManager();
        this.manager = manager;

    }

    private void checkConditionAndEnrollNewManager() {

        if(this.manager == null) return;

        Member newManager = this.members.stream()
                .filter(member -> member.getRole().equals("MANAGER"))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        newManager.changeRole("MEMBER");

    }
    public void addMemberCount() {
        this.memberCount++;
    }

}


