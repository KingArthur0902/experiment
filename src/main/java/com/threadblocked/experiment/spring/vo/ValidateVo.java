package com.threadblocked.experiment.spring.vo;

import javax.validation.constraints.NotNull;

/**
 * Created by ArthurTsang on 7/20/16.
 */
public class ValidateVo {

    @NotNull
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
