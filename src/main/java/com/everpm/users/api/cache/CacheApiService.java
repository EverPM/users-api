package com.everpm.users.api.cache;

import org.springframework.stereotype.Service;

@Service
public class CacheApiService {

    @CustomCache(isCacheEnabled = true, cacheManager = "chathuranga")
    public String getCache(UserParam userParam) {
        return "from method";
    }
}
