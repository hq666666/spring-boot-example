package com.person.springbootexample.controller;

import com.person.springbootexample.config.MyConfig;
import com.person.springbootexample.config.MyConfig01;
import com.person.springbootexample.entity.Greeting;
import com.person.springbootexample.entity.Prod;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @RestController 与@Controller区别：
 *
 *                  @RestController：
 *                      该注释将该类标记为一个控制器，其中每个方法都返回一个域对象，而不是一个视图。它是@Controller和@ResponseBody的缩写
 *
 *                  @Controller：
 *                          该注解将该类标记为一个控制器，其中每个方法都返回一个试图；
 *                  @RequestMapping:
 *                          01:该注解的value值是HTTP请求映射到该方法声明的注解；
 *                          02：该注解包含所有的HTTP请求可以通过method设置对应的HTTP请求方法
 *                  @RequestParam:
 *                         01:该注解绑定在对应方法中的参数列表中；
 *                         02:该注解为HTTP请求的查询参数；
 *                         03:该注解可以在其中设置对应的查询参数以及默认值；
 *
 *
 */
@Controller
@Slf4j
public class GreetingController {

    private static final String template = "Hello,%s";
    private final AtomicLong resultId = new AtomicLong(0l);
    private static final Logger log = LoggerFactory.getLogger(GreetingController.class);
    @Autowired
    private MyConfig myConfig;

    @Autowired
    private MyConfig01 myConfig01;

    @Value("${spring.application.name}")
    private String applicationName;

    /**
     * 第一次访问：
     * @param name
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/greeting")
    public Greeting getGreeting(@RequestParam(value = "name",defaultValue = "World")String name){
        return new Greeting(resultId.incrementAndGet(), String.format(template, name));
    }

    /**
     * @Dscription 测试：外部化配置项
     *                  获取对应外部配置项的信息
     *
     * @return
     */
    @RequestMapping(value = "/config",method = RequestMethod.GET)
    public List<String> getConfig() {
        /**
         * 通过@ConfigurationProperties获取外部配置属性源
         */
        Prod prod = myConfig.getProd();
        String url = prod.getUrl();
        String name = prod.getName();
        List<String> list = new ArrayList<>();
        list.add(url);
        list.add(name);
        list.addAll(myConfig.getServers());
        //---------通过@value获取外部配置属性源-------------------
        log.info(applicationName);
        list.add(applicationName);
        if(CollectionUtils.isNotEmpty(list)){
            return list;
        }

        return null;
    }

    /**
     * @Description 测试：外部化配置项
     *                  获取对应外部配置项的信息(集合<bean>类型)
     * @return
     */
    @RequestMapping(value = "/config01",method = RequestMethod.GET)
    public List<Prod> getMyConfig01(){
        List<Prod> objects = myConfig01.getObjects();
        if(CollectionUtils.isNotEmpty(objects)){
            return objects;
        }
        return  null;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
