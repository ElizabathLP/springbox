package com.ambition.springbox.action;

import com.ambition.springbox.aspect.WebLog;
import com.ambition.springbox.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ActionDemo {
    private final static Logger logger = LoggerFactory.getLogger(ActionDemo.class);

    /**
     * POST 方式接口测试
     */
    @PostMapping("/user/login")
    @WebLog(description = "请求了用户登录接口")
    public User login(@RequestBody User user) {
        logger.info("user login ...");
        return user;
    }

    /**
     * GET 方式接口测试
     * @param userId
     * @return
     */
    @GetMapping("/user/{id}")
    @WebLog(description = "请求了查找用户信息接口")
    public String findUserInfo(@PathVariable("id") String userId){
        logger.info("find user info ...");
        return "success";
    }

    @PostMapping("/file/upload")
    @WebLog(description = "单文件上传接口")
    public String testFileUpload(@RequestParam("file")MultipartFile file){
        logger.info("file upload ...");
        return "success";
    }

    @PostMapping("/multiFile/upload")
    @WebLog(description = "请求了用户登录接口")
    public String testMultiFileUpload(@RequestParam("file") MultipartFile[] file){
        logger.info("moltiFile upload ...");
        return "success";
    }
}
