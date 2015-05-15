package com.jd.cof;

import com.jd.cof.workflowvisible.AfterProcessListener;
import com.jd.cof.workflowvisible.QueueProcessor;
import com.jd.cof.workflowvisible.model.Order;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wangxichun on 2015/5/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-config.xml" })
public class Main {
    private static final Logger log = Logger.getLogger(Main.class);
    @Autowired
    ArrayBlockingQueue startQueue;
    int orderNum = 1000;

    @Autowired
    QueueProcessor endProcessor;

    @Test
    public void putOrder() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(orderNum);

        endProcessor.addAfterListener(new AfterProcessListener() {
            public void afterProcess(Order order) {
                countDownLatch.countDown();
            }
        });

        for (int i=0;i<orderNum;i++) {
            startQueue.put(new Order(i));
            log.info("current size of order:" + i);
        }

        countDownLatch.await();
        log.info("all end>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    }

}
