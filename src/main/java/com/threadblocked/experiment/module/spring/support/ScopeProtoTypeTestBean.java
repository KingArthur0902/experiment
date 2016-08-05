package com.threadblocked.experiment.module.spring.support;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by ArthurTsang on 7/24/16.
 */
@Scope("prototype")
@Component
public class ScopeProtoTypeTestBean {

    private Integer count = 0;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
