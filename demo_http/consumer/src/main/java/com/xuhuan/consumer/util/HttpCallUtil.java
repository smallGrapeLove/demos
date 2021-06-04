package com.xuhuan.consumer.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author huan.xu
 * @ClassName HttpCallUtil
 * @date 2021/6/4 8:28
 * @Description 发起 http 请求工具类
 */
@Slf4j
public class HttpCallUtil {
    /**
     * 私有构造方法
     */
    private HttpCallUtil() {

    }

    /**
     * 发起 get 请求
     *
     * @param restTemplate RestTemplate 对象
     * @param url          请求 url
     * @param paramMap     请求参数
     * @return
     */
    public static String sendGet(RestTemplate restTemplate, String url, Map paramMap) {
        log.info("--------发起get请求--------");
        log.info("请求地址[{}]", url);
        log.info("请求参数[{}]", paramMap);
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class, paramMap);
        HttpStatus statusCode = responseEntity.getStatusCode();
        log.info("请求状态[{}]", statusCode);
        String body = responseEntity.getBody();
        log.info("请求结果[{}]", body);
        return body;
    }

    /**
     * 发起 post 请求
     *
     * @param restTemplate RestTemplate 对象
     * @param url          请求 url
     * @param requestObj     请求参数
     * @return
     */
    public static String sendPost(RestTemplate restTemplate, String url, Object requestObj) {
        log.info("--------发起post请求--------");
        log.info("请求地址[{}]", url);
        log.info("请求参数[{}]", requestObj);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, requestObj, String.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        log.info("请求状态[{}]", statusCode);
        String body = responseEntity.getBody();
        log.info("请求结果[{}]", body);
        return body;
    }
}
