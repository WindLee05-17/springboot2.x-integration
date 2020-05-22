package com.wm.zgy.bootmybatismbplusshiroesquartz;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@MapperScan("com.wm.zgy.bootmybatismbplusshiroesquartz.mapper") // 扫描mapper文件夹
@EnableScheduling // 开启定时任务
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
        log.trace("logback的--trace日志--输出了");
        log.debug("logback的--debug日志--输出了");
        log.info("logback的--info日志--输出了");
        log.warn("logback的--warn日志--输出了");
        log.error("logback的--error日志--输出了");
    }

}