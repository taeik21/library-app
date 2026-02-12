package com.group.libraryapp.dto;

import lombok.Data;

@Data
public class MemberCreateRequest {
    private String name;

    private Integer age;

    public MemberCreateRequest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
