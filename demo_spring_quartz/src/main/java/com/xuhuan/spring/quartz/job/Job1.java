package com.xuhuan.spring.quartz.job;


import com.xuhuan.spring.quartz.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;

public class Job1 {

    @Autowired
    private JobService jobService;

    public void sayHello(){
        System.out.println("job1 .......");
        jobService.sayHello();
    }
}
