package com.dfg.java_template.framework.rest.util;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class RestTemplateUtil {

    @Resource
    private RestTemplate restTemplate;

    /**
     * GET请求 - 返回字符串
     *
     * @param url 请求地址
     * @return 响应结果字符串
     */
    public String get(String url) {
        return restTemplate.getForObject(url, String.class);
    }

    /**
     * GET请求 - 带参数
     *
     * @param url    请求地址
     * @param params 参数Map
     * @return 响应结果字符串
     */
    public String get(String url, Map<String, Object> params) {
        return restTemplate.getForObject(url, String.class, params);
    }

    /**
     * GET请求 - 带请求头和参数
     *
     * @param url     请求地址
     * @param headers 请求头Map
     * @param params  参数Map
     * @return 响应结果字符串
     */
    public String get(String url, Map<String, String> headers, Map<String, Object> params) {
        // 设置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        headers.forEach(httpHeaders::add);

        // 创建请求实体
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        // 发送请求
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.GET, requestEntity, String.class, params);

        return response.getBody();
    }

    /**
     * POST请求 - 发送表单数据
     *
     * @param url      请求地址
     * @param formData 表单数据Map
     * @return 响应结果字符串
     */
    public String postForm(String url, Map<String, Object> formData) {
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        formData.forEach((key, value) -> multiValueMap.add(key, value.toString()));

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(multiValueMap, headers);

        return restTemplate.postForObject(url, requestEntity, String.class);
    }

    /**
     * POST请求 - 发送JSON数据
     *
     * @param url  请求地址
     * @param json JSON字符串
     * @return 响应结果字符串
     */
    public String postJson(String url, String json) {
        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 创建请求实体
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        // 发送请求
        return restTemplate.postForObject(url, requestEntity, String.class);
    }

    /**
     * POST请求 - 带自定义请求头
     *
     * @param url     请求地址
     * @param headers 请求头Map
     * @param body    请求体
     * @return 响应结果字符串
     */
    public String post(String url, Map<String, String> headers, Object body) {
        // 设置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        headers.forEach(httpHeaders::add);

        // 创建请求实体
        HttpEntity<Object> requestEntity = new HttpEntity<>(body, httpHeaders);

        // 发送请求
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, requestEntity, String.class);

        return response.getBody();
    }

    /**
     * PUT请求 - 支持自定义请求头
     *
     * @param url     请求地址
     * @param headers 请求头Map (可选)
     * @param body    请求体
     * @return 是否成功
     */
    public boolean put(String url, Map<String, String> headers, Object body) {
        // 设置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headers != null) {
            headers.forEach(httpHeaders::add);
        } else {
            // 默认Content-Type
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        }

        // 创建请求实体
        HttpEntity<Object> requestEntity = new HttpEntity<>(body, httpHeaders);

        // 发送PUT请求
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.PUT, requestEntity, String.class);

        return response.getStatusCode().is2xxSuccessful();
    }

    // 重载方法，简化无请求头的调用
    public boolean put(String url, Object body) {
        return put(url, null, body);
    }

    /**
     * DELETE请求
     *
     * @param url 请求地址
     * @return 是否成功
     */
    public boolean delete(String url, Map<String, String> headers) {
        // 设置请求头
        HttpHeaders httpHeaders = new HttpHeaders();
        if (headers != null) {
            headers.forEach(httpHeaders::add);
        }

        // 创建请求实体
        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        // 发送DELETE请求并获取响应
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.DELETE, requestEntity, String.class);
        
        return response.getStatusCode().is2xxSuccessful();
    }

    public boolean delete(String url) {
        restTemplate.delete(url);
        return true; // 简单返回成功，实际可根据需要修改
    }
}