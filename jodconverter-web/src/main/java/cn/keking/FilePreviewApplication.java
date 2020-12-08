package cn.keking;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableScheduling// 开启定时任务
@EnableTransactionManagement// 开启事务管理
@MapperScan("cn.keking.mapper")
@ServletComponentScan
public class FilePreviewApplication {
	public static void main(String[] args) {
        SpringApplication.run(FilePreviewApplication.class, args);
	}
}
