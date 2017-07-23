package com.demo.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * Created by tarunsapra on 23/07/2017.
 */
@Service
public class AsyncService {

    @Async
    public Future<String> getAsyncResult() throws InterruptedException {
        //Make the thread sleep for 10 secs
        Thread.sleep(10000);
        return new AsyncResult<String>("Hello World");
    }
}
