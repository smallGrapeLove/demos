package com.xuhuan.provider.controller;

import com.xuhuan.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author huan.xu
 * @ClassName DemoController
 * @date 2021/6/3 16:14
 * @Description 提供post请求接口
 */
@RequestMapping("/demo-post")
@Controller
@Slf4j
public class DemoPostController {

    @PostMapping("/getMethod1")
    @ResponseBody
    public User getMethod1(@RequestBody User user) {
        log.info("[{}]类[{}]方法被调用。。。","DemoPostController","getMethod1");
        return user;
    }
}
