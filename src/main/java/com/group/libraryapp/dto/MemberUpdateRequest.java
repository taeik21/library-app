package com.group.libraryapp.dto;

import lombok.Data;

@Data
public class MemberUpdateRequest {
    private Long id;

    private String name;

    public MemberUpdateRequest(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
