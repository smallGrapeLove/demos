package com.xuhuan.consumer.controller;

import com.xuhuan.common.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String getMethod(String name) {
        log.info("请求参数[{}]",name);
        String url = providerUrl + "/demo-post/getMethod?name={name}";
        MultiValueMap map = new LinkedMultiValueMap();
        map.add("name", name);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, map, String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        String body = responseEntity.getBody();
        log.info("调用服务提供者接口[{}]，状态[{}]，结果[{}]", url, statusCode, body);
        return body;
    }

    @GetMapping("/getMethod1")
    @ResponseBody
    public String getMethod1() {
        String url = providerUrl + "/demo-post/getMethod1";
        User user=new User();
        user.setName("张三");
        user.setAge(18);

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, user, String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        String body = responseEntity.getBody();
        log.info("调用服务提供者接口[{}]，状态[{}]，结果[{}]", url, statusCode, body);
        return body;
    }
}
