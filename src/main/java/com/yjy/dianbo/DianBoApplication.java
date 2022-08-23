package com.yjy.dianbo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DianBoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DianBoApplication.class,args);
        log.info("项目启动成功");
    }
}
