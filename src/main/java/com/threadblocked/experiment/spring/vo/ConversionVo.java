package com.threadblocked.experiment.spring.vo;


import java.util.Date;

/**
 * Created by ArthurTsang on 7/17/16.
 */
public class ConversionVo {

    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private String a;
    private Integer b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }
}
