package com.jd.cof.workflowvisible.nodes;

import com.jd.cof.workflowvisible.QueueProcessor;
import com.jd.cof.workflowvisible.model.Order;

/**
 * Created by wangxichun on 2015/9/2.
 */
public class GeneralProcess extends AbstractProcessor implements QueueProcessor {
    public void doProcess(Order param) throws Throwable {
        loggger.info(this.getClass().getSimpleName() + " running");
    }
}
