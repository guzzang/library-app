package com.group.libraryapp.controller.team;

import com.group.libraryapp.dto.team.request.TeamCreateRequest;
import com.group.libraryapp.dto.team.response.TeamResponse;
import com.group.libraryapp.service.team.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/team")
    public void saveTeam(@RequestBody TeamCreateRequest request){
        teamService.saveTeam(request);
    }

    @GetMapping("/team")
    public List<TeamResponse> getTeam(){
        return teamService.getTeams();
    }


}
