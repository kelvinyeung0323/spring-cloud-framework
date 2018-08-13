package com.taurus.cloud.consumer.feign.service.fallback;

import com.taurus.cloud.consumer.feign.service.UserServiceWithFallBackFactory;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * Created by Kelvin Yeung on 2018/8/13.
 */
@Component
public class UserServiceFallBackFactory implements FallbackFactory<UserServiceWithFallBackFactory> {
    @Override
    public UserServiceWithFallBackFactory create(Throwable throwable) {
        return new UserServiceWithFallBackFactory() {
            @Override
            public String getUser(String userName) {
                return "UserServiceWithFallBackFactory fallback!";
            }
        };
    }
}
