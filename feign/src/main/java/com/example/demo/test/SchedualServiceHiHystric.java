package com.example.demo.test;

import org.springframework.stereotype.Component;

/**
 * Created by root on 2017/6/12.
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}