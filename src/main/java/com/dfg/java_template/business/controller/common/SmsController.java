package com.dfg.java_template.business.controller.common;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/sms/common")
@RestController
@Api(tags = "短信服务模块")
public class SmsController {
    @RequestMapping("/send")
    public String send(@RequestParam(required = false) String arg, @RequestParam String phone) {
        return "发送成功";
    }
}
