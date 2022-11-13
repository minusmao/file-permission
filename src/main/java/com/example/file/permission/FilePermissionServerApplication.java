package com.example.file.permission;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * 文件权限验证服务，配合nginx文件代理
 *
 * @author minus
 * @since 2022-11-13 14:04:16
 */
@SpringBootApplication
public class FilePermissionServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FilePermissionServerApplication.class, args);
    }

}
