package com.threadblocked.experiment.spring.support;

import org.springframework.stereotype.Component;

/**
 * Created by ArthurTsang on 7/24/16.
 */
@Component
public class ScopeSingletonTestBean {

    private Integer count = 0;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
