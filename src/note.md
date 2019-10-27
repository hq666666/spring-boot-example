#Spring Boot 的早期 Version 升级需添加以下依赖配置：
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-properties-migrator</artifactId>
	<scope>runtime</scope>
</dependency>
#注意：添加到环境后期的属性(例如使用@PropertySource时)将不会被考虑在内

#----------------------------------------------

  