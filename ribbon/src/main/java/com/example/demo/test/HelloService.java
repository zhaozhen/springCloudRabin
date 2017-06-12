package com.example.demo.test;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by root on 2017/6/12.
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    //    该断代码的意思是如果访问不可达，则要访问hiError方法
    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    public String hiError(String name) {
        return "hi," + name + ",sorry,error!+++++++++";
    }
}
