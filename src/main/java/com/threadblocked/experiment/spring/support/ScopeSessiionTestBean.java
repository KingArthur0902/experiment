package com.threadblocked.experiment.spring.support;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Created by ArthurTsang on 7/24/16.
 */
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class ScopeSessiionTestBean {
    private Integer count = 0;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
