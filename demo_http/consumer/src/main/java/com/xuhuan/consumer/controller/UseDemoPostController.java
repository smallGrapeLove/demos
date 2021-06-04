package com.xuhuan.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.xuhuan.common.entity.User;
import com.xuhuan.consumer.util.HttpCallUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huan.xu
 * @ClassName UseDemoController
 * @date 2021/6/3 16:24
 * @Description 调用服务提供者提供的 UseDemoPostController 里面的服务
 */
@RequestMapping("/demo-post-use")
@Controller
@Slf4j
public class UseDemoPostController {

    @Value("${provider.url}")
    private String providerUrl;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getMethod")
    @ResponseBody
    public String getMethod() {
        String url = providerUrl + "/demo-post/getMethod1";
        User user=new User();
        user.setName("张三");
        user.setAge(18);

        String body = HttpCallUtil.sendPost(restTemplate, url, user);

        return body;
    }

    @PostMapping("/getMethod1")
    @ResponseBody
    public String getMethod1(@RequestBody User user){
        String url = providerUrl + "/demo-post/getMethod1";
        String body = HttpCallUtil.sendPost(restTemplate, url, user);
        JSONObject jsonObject = JSONObject.parseObject(body);
        log.info("返回结果格式化为JSON格式[{}]",jsonObject);

        return body;
    }
}
