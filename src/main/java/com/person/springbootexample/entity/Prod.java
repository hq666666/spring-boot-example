package com.person.springbootexample.entity;

import lombok.Data;

/**
 * 外部配置文件对应配置json体配置信息项；
 */
@Data
public class Prod {
    private String url;
    private String name;

}
