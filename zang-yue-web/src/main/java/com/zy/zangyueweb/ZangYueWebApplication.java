package com.zy.zangyueweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lhf
 */
@SpringBootApplication(scanBasePackages = {"com.zy.**"})
@MapperScan("com.zy.system.zangyuesystem.mapper")
public class ZangYueWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZangYueWebApplication.class, args);
    }

}
