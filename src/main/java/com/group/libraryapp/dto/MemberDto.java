package com.group.libraryapp.dto;

import com.group.libraryapp.domain.Member;
import lombok.Data;

@Data
public class MemberDto {
    private Long id;

    private String name;

    private Integer age;

    public MemberDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.age = member.getAge();
    }
}
