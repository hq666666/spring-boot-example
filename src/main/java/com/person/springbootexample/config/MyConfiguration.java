package com.person.springbootexample.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({MyConfig.class,MyConfig01.class})
public class MyConfiguration {

    /**
     * 自定义HttpMessageConverter(http信息的转换)
     */
    /*@Bean
    public HttpMessageConverters converters(){
        //HttpMessageConverter为策略接口有不同的具体实现体
        HttpMessageConverter<?> messageConverter = new StringHttpMessageConverter(Charset.defaultCharset());
        HttpMessageConverter<?> httpMessageConverter = new ObjectToStringHttpMessageConverter(new WebConversionService("yyyy-MM-dd HH:mm:ss"), Charset.defaultCharset());
        List<HttpMessageConverter<?>> list = new ArrayList<>();
        return new HttpMessageConverters(list);
    }*/

}
