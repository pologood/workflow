package com.jd.cof.workflowvisible.nodes.bNode;

import com.jd.cof.workflowvisible.DispatchStrategy;
import com.jd.cof.workflowvisible.QueueProcessor;
import com.jd.cof.workflowvisible.model.Order;
import com.jd.cof.workflowvisible.nodes.AbstractProcessor;

import java.util.Random;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class BProcess extends AbstractProcessor implements QueueProcessor {
    Random randomMaker = new Random();
    boolean cond2;

    public DispatchStrategy doProcess(Order param) throws Throwable {
        cond2 = randomMaker.nextBoolean();
        return new BDispatch(cond2);
    }
}
