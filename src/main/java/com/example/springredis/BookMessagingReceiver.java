package com.example.springredis;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookMessagingReceiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookMessagingReceiver.class);

    private AtomicInteger counter = new AtomicInteger();

    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        counter.incrementAndGet();
    }

    public int getCount() {
        return counter.get();
    }
}
