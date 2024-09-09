package com.vn.ShopService.dtos;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestDataDto {
    String id;
    String code;
    String name;
    String note;

    public TestDataDto(String id, String code, String name, String note) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.note = note;
    }
}
