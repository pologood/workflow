package com.jd.cof.workflowvisible.nodes.aNode;

import com.jd.cof.workflowvisible.QueueProcessor;
import com.jd.cof.workflowvisible.model.Order;
import com.jd.cof.workflowvisible.nodes.AbstractProcessor;


/**
 * Created by wangxichun on 2015/5/7.
 */
public class AProcess extends AbstractProcessor implements QueueProcessor {

    public void doProcess(Order param) throws Throwable {
        loggger.info(this.getClass().getSimpleName() + " running");
    }
}
