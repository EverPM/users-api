package com.everpm.users.api.cache;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserParam {

    private String name;
    private Boolean isCached;
}
