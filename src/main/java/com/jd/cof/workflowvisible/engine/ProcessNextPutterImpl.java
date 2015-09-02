package com.jd.cof.workflowvisible.engine;

import com.jd.cof.workflowvisible.ProcessEnum;
import com.jd.cof.workflowvisible.model.Order;
import org.apache.log4j.Logger;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class ProcessNextPutterImpl implements ProcessNextPutter {
    private final Logger logger = Logger.getLogger(getClass());
    ConcurrentMap<ProcessEnum, BlockingQueue<Order>> stepBlockingQueue;

    public void put(ProcessEnum nextStep, Order orderParam) {
        if (ProcessEnum.Null == nextStep) {
            return;
        }
        try {
            stepBlockingQueue.get(nextStep)
                    .put(orderParam);
        } catch (Exception e) {
            logger.error(String.format("ProcessEnum[%s], 订单[%s]放到队列[%s]时报错",nextStep.getName(), orderParam.getOrderId(),nextStep), e);
        }
    }

    public ConcurrentMap<ProcessEnum, BlockingQueue<Order>> getStepBlockingQueue() {
        return stepBlockingQueue;
    }

    public void setStepBlockingQueue(ConcurrentMap<ProcessEnum, BlockingQueue<Order>> stepBlockingQueue) {
        this.stepBlockingQueue = stepBlockingQueue;
    }
}
