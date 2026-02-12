package com.group.libraryapp.controller.member;

import com.group.libraryapp.domain.Member;
import com.group.libraryapp.dto.MemberCreateRequest;
import com.group.libraryapp.dto.MemberDto;
import com.group.libraryapp.dto.MemberUpdateRequest;
import com.group.libraryapp.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/user")
    public List<MemberDto> members() {
        return memberService.findMembers();
    }

    @PostMapping("/user")
    public void createMember(@RequestBody MemberCreateRequest request) {
        memberService.join(request);
    }

    @PutMapping("/user")
    public void updateMember(@RequestBody MemberUpdateRequest request) {
        memberService.updateMember(request.getId(), request.getName());
    }

    @DeleteMapping("/user")
    public void deleteMember(@RequestParam String name) {
        memberService.deleteMember(name);
    }
}
