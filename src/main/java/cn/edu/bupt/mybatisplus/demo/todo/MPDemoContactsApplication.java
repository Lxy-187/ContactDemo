package cn.edu.bupt.mybatisplus.demo.todo;

import lombok.Getter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

@MapperScan("cn.edu.bupt.mybatisplus.demo.todo.mapper")
@SpringBootApplication
@Getter
public class MPDemoContactsApplication {
    @Value("${resource-path}")
    private String resourcePath;
    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(resourcePath);
        return factory.createMultipartConfig();
    }
    public static void main(String[] args) {

        SpringApplication.run(MPDemoContactsApplication.class, args);
    }

}
