package com.jd.cof.workflowvisible.engine;

import com.jd.cof.workflowvisible.*;
import com.jd.cof.workflowvisible.model.Order;
import org.apache.log4j.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class ProcessRunner implements Runnable {
    protected Logger log = Logger.getLogger(getClass());

    // 完成信号器
    private CountDownLatch doneSingal;
    // 线程延时
    protected int threadDelay;
    private BlockingQueue<Order> queue;


    //Biz logic
    private QueueProcessor processor;
    private ProcessNextPutter putter;

    public void run() {
        try {
            beforeWork();
            doWork();
            Thread.sleep(threadDelay);
        } catch (Throwable e) {
            log.error("Runner  exception", e);
        } finally {
            doneSingal.countDown();
        }
    }

    protected void beforeWork() {}
    protected  void  doWork() throws Throwable {
        log.info(String.format("Processor[%s] start process", processor.getName()));
        Order orderParam = null;

        while((orderParam = queue.take())  != null) {
            DispatchStrategy strategy = processor.process(orderParam);
            DispatchResult dispatchResult = strategy.decide();
            ProcessEnum nextStep = dispatchResult.getNextActivity();

            log.info(String.format("Order[%s] by Processor[%s] Done", orderParam.getOrderId(), processor.getName()));

            //据decide里的next定位到Queue， 并放进去。
            if (nextStep != null) {
                putter.put(nextStep, orderParam);
            }
        }
    }

    public QueueProcessor getProcessor() {
        return processor;
    }

    public void setProcessor(QueueProcessor processor) {
        this.processor = processor;
    }

    public ProcessNextPutter getPutter() {
        return putter;
    }

    public void setPutter(ProcessNextPutter putter) {
        this.putter = putter;
    }

    public int getThreadDelay() {
        return threadDelay;
    }

    public void setThreadDelay(int threadDelay) {
        this.threadDelay = threadDelay;
    }

    public BlockingQueue<Order> getQueue() {
        return queue;
    }

    public void setQueue(BlockingQueue<Order> queue) {
        this.queue = queue;
    }
}
