package com.vn.ShopService.filters;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestDataFilter extends BaseFilter {
    String code;
    String name;
}
