package com.example.file.permission.controller;

import com.example.file.permission.common.ApiConst;
import com.example.file.permission.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 文件下载token验证
 * 参考文档：https://blog.csdn.net/itmm_wang/article/details/107705613
 * 参考文档：https://www.cnblogs.com/czlun/articles/7010604.html
 *
 * @author minus
 * @since 2022-11-13 14:04:16
 */
@RestController
@RequestMapping(ApiConst.API_URL + "/authenticate")
public class AuthenticateController {

    @Autowired
    private AuthenticateService authenticateService;

    @GetMapping("/{id}")
    public void downloadFile(
            @PathVariable String id,
            @RequestParam String token,
            HttpServletResponse response
    ) {
        authenticateService.downloadFile(id, token, response);
    }

}
