package com.group.libraryapp.service.team;

import com.group.libraryapp.domain.team.Team;
import com.group.libraryapp.domain.team.TeamRepository;
import com.group.libraryapp.dto.team.request.TeamCreateRequest;
import com.group.libraryapp.dto.team.response.TeamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public void saveTeam(TeamCreateRequest request){

        boolean isDuplicate = teamRepository.existsByTeamName(request.getTeamName());
        if(isDuplicate){
            throw new IllegalArgumentException(String.format("팀 %s는 이미 존재하는 팀입니다.", request.getTeamName()));
        }

        teamRepository.save(new Team(request.getTeamName()));
    }

    @Transactional(readOnly = true)
    public List<TeamResponse> getTeams() {

        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(team -> new TeamResponse(team.getTeamName(), team.getManager(), team.getMemberCount()))
                .collect(Collectors.toList());


    }
}
