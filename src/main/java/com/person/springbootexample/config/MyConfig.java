package com.person.springbootexample.config;

import com.person.springbootexample.entity.Prod;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "my")
@Component
@Data
//@Validated
public class MyConfig {

    private  Prod prod;
    private  List<String> servers;

}
