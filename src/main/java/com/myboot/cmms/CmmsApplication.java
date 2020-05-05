package com.myboot.cmms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan(basePackages = "com.myboot.cmms.mapper.**")//扫描mybatis的mapper接口，如果包文件夹有子文件夹，则一定要写成这种才能全部扫描到。
@ServletComponentScan//servelet组件扫描，因为配置有servlet过滤器
@SpringBootApplication
public class CmmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmmsApplication.class, args);
    }

}
