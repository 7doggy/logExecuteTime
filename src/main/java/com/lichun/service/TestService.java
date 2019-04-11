package com.lichun.service;

import com.lichun.annotation.LogExecuteTime;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @LogExecuteTime
    public void testLog() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
