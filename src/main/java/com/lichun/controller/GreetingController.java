package com.lichun.controller;

import com.lichun.annotation.LogExecuteTime;
import com.lichun.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    @Autowired
    private TestService testService;

    @LogExecuteTime
    @RequestMapping("/greeting")
    public String greeting() throws InterruptedException {
        testService.testLog();
        return "Request Success!";
    }

}
