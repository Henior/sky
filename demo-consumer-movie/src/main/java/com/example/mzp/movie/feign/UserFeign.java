package com.example.mzp.movie.feign;

import com.example.mzp.movie.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("provider-user")
public interface UserFeign {

    @RequestMapping(value = "user/{id}" ,method = RequestMethod.GET)
        //1.不支持GetMapping
        //2.PathVariable 必须设置value
        //3.method = RequestMethod.GET时，参数列表只能（@RequestParaam var1,var2,var3...），不能是Object;
    User getUser(@PathVariable("id") Long id);
}
