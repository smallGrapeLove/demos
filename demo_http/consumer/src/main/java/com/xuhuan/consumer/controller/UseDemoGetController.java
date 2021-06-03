package com.xuhuan.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author huan.xu
 * @ClassName UseDemoController
 * @date 2021/6/3 16:24
 * @Description 调用服务提供者提供的 DemoGetController 里面的服务
 */
@RequestMapping("/demo-get-use")
@Controller
@Slf4j
public class UseDemoGetController {

    @Value("${provider.url}")
    private String providerUrl;
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getMethod")
    @ResponseBody
    public String getMethod(String name) {
        log.info("请求参数[{}]",name);
        String url = providerUrl + "/demo-get/getMethod?name={name}";
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, map);
        HttpStatus statusCode = responseEntity.getStatusCode();
        String body = responseEntity.getBody();
        log.info("调用服务提供者接口[{}]，状态[{}]，结果[{}]", url, statusCode, body);
        return body;
    }
}
