package com.jd.cof.workflowvisible.nodes.endNode;

import com.jd.cof.workflowvisible.DispatchStrategy;
import com.jd.cof.workflowvisible.QueueProcessor;
import com.jd.cof.workflowvisible.model.Order;
import com.jd.cof.workflowvisible.nodes.AbstractProcessor;
import org.apache.log4j.Logger;

import java.util.Random;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class EndProcess extends AbstractProcessor implements QueueProcessor {
    private final Logger logger = Logger.getLogger(getClass());

    public DispatchStrategy doProcess(Order param) throws Throwable {
        param.setFinished(true);
        logger.info("END, orderId: " + param.getOrderId());
        return new EndDispatch();
    }
}
