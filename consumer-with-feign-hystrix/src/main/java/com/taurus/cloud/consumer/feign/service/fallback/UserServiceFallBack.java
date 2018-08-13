package com.taurus.cloud.consumer.feign.service.fallback;

import com.taurus.cloud.consumer.feign.service.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

/**
 * Created by Kelvin Yeung on 2018/8/12.
 */
@Component
public class UserServiceFallBack implements UserService {

    @Override
    public String getUser(String userName) {
        return "has fallback";
    }
}
