package com.example.springindiv2.jobs;

import com.example.springindiv2.entity.Order;
import com.example.springindiv2.repository.OrderRepo;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class MyScheduler {

    private final OrderRepo orderRepo;

    public MyScheduler(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

//    @Scheduled(cron = "0 * * * * *")
    @SchedulerLock(
            name = "MyScheduler_myTask",
            lockAtMostFor = "5m",
            lockAtLeastFor = "30s"
    )
    public void runEvery() throws Exception {
        System.out.println("shed start");
        System.out.println("Running: " + LocalDateTime.now());
        System.out.println("salam");
        System.out.println("shed end");
    }
}
