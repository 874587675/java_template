package com.dfg.java_template.business.controller.common;


import com.dfg.java_template.common.web.R;
import com.dfg.java_template.framework.aliyunplugin.oss.OssUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RequestMapping("/api/v1/upload/common")
@RestController
@Api(tags = "上传文件模块")
public class UploadController {

    @Resource
    private OssUtil ossUtil;

    @ApiOperation(value = "上传图片文件", produces = "multipart/form-data", consumes = "multipart/form-data")
    @PostMapping("/upload/uploadImage")
    public R<String> uploadImage(@RequestParam MultipartFile file) {
        String url = ossUtil.uploadFileByType(file, "image").getUrl();
        return R.ok(url);
    }

    @ApiOperation(value = "上传音频文件", produces = "multipart/form-data", consumes = "multipart/form-data")
    @PostMapping("/upload/uploadAudio")
    public R<String> uploadAudio(@RequestParam MultipartFile file) {
        String url = ossUtil.uploadFileByType(file, "audio").getUrl();
        return R.ok(url);
    }

    @ApiOperation(value = "上传视频文件", produces = "multipart/form-data", consumes = "multipart/form-data")
    @PostMapping("/upload/uploadVideo")
    public R<String> uploadVideo(@RequestParam MultipartFile file) {
        String url = ossUtil.uploadFileByType(file, "video").getUrl();
        return R.ok(url);
    }

}
