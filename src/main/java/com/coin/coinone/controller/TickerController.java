package com.coin.coinone.controller;

import com.coin.coinone.job.TickerJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TickerController {
    private SchedulerFactory schedulerFactory;
    private Scheduler scheduler;
    @GetMapping("/")
    public void startScheduler(String name) throws SchedulerException {

    }
}
