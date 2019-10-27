package com.person.springbootexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description  SpringBootExampleApplication:
 *                  创建一个独立的应用程序,将所有内容都打包到一个单独的、可执行的JAR文件中，该文件由一个良好的旧Java main()方法驱动。在此过程中，使用Spring支持将Tomcat servlet容器嵌入为HTTP运行时，而不是部署到外部的instance;
 *
 *               @SpringBootApplication:该注解包含以下注解的功能
 *
 *                       @Configuration：将该类标记为应用程序上下文的bean定义源
 *                       @EnableAutoConfiguration：告诉Spring Boot根据类路径设置、其他bean和各种属性设置开始添加bean
 *                       @ComponentScan：告诉Spring在hello包中查找其他组件、配置和服务，让它查找控制器
 *
 *
 *
 */
@SpringBootApplication
public class SpringBootExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleApplication.class, args);

    }

}
