package com.person.springbootexample.config;

import com.person.springbootexample.entity.Prod;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "my")
@Data
public class MyConfig01 {

    private List<Prod> objects;
}
