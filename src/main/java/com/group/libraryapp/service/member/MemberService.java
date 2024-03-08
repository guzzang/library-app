package com.group.libraryapp.service.member;

import com.group.libraryapp.domain.member.Member;
import com.group.libraryapp.domain.member.MemberRepository;
import com.group.libraryapp.domain.team.Team;
import com.group.libraryapp.domain.team.TeamRepository;
import com.group.libraryapp.dto.member.request.MemberCreateRequest;
import com.group.libraryapp.dto.member.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final TeamRepository teamRepository;

    @Transactional
    public void saveMember(MemberCreateRequest request){

        Team team = teamRepository.findByTeamName(request.getTeamName())
                .orElseThrow(IllegalArgumentException::new);

        memberRepository.save(
                new Member(request.getMemberName(),
                        request.getRole(),
                        request.getBirthday(),
                        request.getWorkStartDate(),
                        team));

        if(request.getRole().equals("MANAGER")){
            team.setManager(request.getMemberName());
        }

        team.addMemberCount();
    }


    @Transactional(readOnly = true)
    public List<MemberResponse> getMembers() {

        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(member -> new MemberResponse(member.getMemberName(), member.getTeam().getTeamName(), member.getRole(), member.getBirthday(), member.getWorkStartDate()))
                .collect(Collectors.toList());



    }
}
