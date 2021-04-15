package com.coin.coinone.scheduler;


import com.coin.coinone.job.TickerJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

public class TickerScheduler {
    private SchedulerFactory schedulerFactory;
    private Scheduler scheduler;

    public void start() throws SchedulerException{
        schedulerFactory = new StdSchedulerFactory();
        scheduler = schedulerFactory.getScheduler();
        scheduler.start();
//        JobDetail job = JobBuilder.newJob(TickerJob.class).withIdentity("job").build();

//        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule("* /1 * * * ?")).build();
//
//        scheduler.scheduleJob(job,trigger);

    }
}
