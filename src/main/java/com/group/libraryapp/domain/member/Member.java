package com.group.libraryapp.domain.member;

import com.group.libraryapp.domain.team.Team;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_name" , nullable = false)
    private String memberName;

    @Column(nullable = false)
    private String role;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private LocalDate workStartDate;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String memberName, String role, LocalDate birthday, LocalDate workStartDate, Team team) {
        this.memberName = memberName;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
        this.team = team;
    }

    public void changeRole(String role) {
        this.role = role;
    }
}
