package com.group.libraryapp.controller.member;

import com.group.libraryapp.dto.member.request.MemberCreateRequest;
import com.group.libraryapp.dto.member.response.MemberResponse;
import com.group.libraryapp.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public void saveMember(@RequestBody MemberCreateRequest request){
        memberService.saveMember(request);
    }

    @GetMapping("/member")
    public List<MemberResponse> getMembers(){
        return memberService.getMembers();
    }

}
