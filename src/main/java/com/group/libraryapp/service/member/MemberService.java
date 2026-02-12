package com.group.libraryapp.service.member;

import com.group.libraryapp.domain.Member;
import com.group.libraryapp.dto.MemberCreateRequest;
import com.group.libraryapp.dto.MemberDto;
import com.group.libraryapp.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(MemberCreateRequest request) {
        Member member = new Member(request.getName(), request.getAge());

        validateDuplicateMemberName(member.getName());

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMemberName(String name) {
        if (memberRepository.existsByName(name))
            throw new IllegalStateException("중복된 회원 이름입니다");
    }

    public List<MemberDto> findMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream()
                .map(MemberDto::new)
                .toList();
    }

    @Transactional
    public void updateMember(Long id, String name) {
        Member member = memberRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);

        member.updateName(name);
    }

    @Transactional
    public void deleteMember(String name) {
        Member member = memberRepository.findByName(name)
                .orElseThrow(IllegalArgumentException::new);

        memberRepository.delete(member);
    }
}
