package com.xuhuan.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huan.xu
 * @ClassName DemoController
 * @date 2021/6/3 16:14
 * @Description 提供get请求接口
 */
@RequestMapping("/demo-get")
@Controller
@Slf4j
public class DemoGetController {

    @GetMapping("/getMethod")
    @ResponseBody
    public String getMethod(String name) {
        log.info("[{}]类[{}]方法被调用。。。","DemoGetController","getMethod");
        return "hello " + name;
    }
}
