package com.demo.async;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Future;

@SpringBootApplication
@EnableAsync
public class SpringAsyncApplication implements CommandLineRunner {


    private final AsyncService asyncService;

    public SpringAsyncApplication(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @Bean
    public TaskExecutor initializeExecutor() {
        return new ThreadPoolTaskExecutor();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAsyncApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("running in spring boot app");
        Future<String> result = asyncService.getAsyncResult();
        System.out.println(result.get());
        System.out.println("Execution complete");
    }
}
