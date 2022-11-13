package com.example.file.permission.service;

import com.example.file.permission.common.exception.ForbiddenException;
import com.example.file.permission.common.exception.NotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;

/**
 * 文件下载token验证
 *
 * @author minus
 * @since 2022-11-13 14:04:16
 */
@Service
public class AuthenticateService {

    /**
     * 文件下载token验证
     *
     * @param id       文件资源id
     * @param token    用户token
     * @param response 响应
     */
    public void downloadFile(String id, String token, HttpServletResponse response) {
        // 验证token
        if (!token.equals("eyJhbGciOiJIUzI1NiJ9")) {
            throw new ForbiddenException("无访问权限");
        }
        // 拿到文件地址
        String filePath = switch (id) {
            case "111" -> "music/Attention.m4a";
            case "222" -> "music/Sorry.mp3";
            case "333" -> "img/default.png";
            default -> throw new NotFoundException("文件未找到");
        };
        // 解析文件名
        String[] filePathSplit = filePath.split("/");
        String fileName = new String(
                filePathSplit[filePathSplit.length - 1].getBytes(StandardCharsets.UTF_8),
                StandardCharsets.ISO_8859_1
        );

        // 已被授权访问
        // 文件下载
        response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
        // 文件以二进制流传输
//        response.setHeader("Content-Type", "application/octet-stream;charset=utf-8");
        // 返回真实文件路径交由 Nginx 处理，保证前端无法看到真实的文件路径。
        // 这里的 "/file_server" 为 Nginx 中配置的下载服务名
        response.setHeader("X-Accel-Redirect", "/file-server/" + filePath);
        // 限速，单位字节，默认不限
        // response.setHeader("X-Accel-Limit-Rate","1024");
        // 是否使用Nginx缓存，默认yes
        // response.setHeader("X-Accel-Buffering","yes");
        response.setHeader("X-Accel-Charset", "utf-8");

        // 禁止浏览器缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "No-cache");
        response.setHeader("Expires", "0");
    }

}
