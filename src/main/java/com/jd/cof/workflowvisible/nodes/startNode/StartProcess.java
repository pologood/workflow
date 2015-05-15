package com.jd.cof.workflowvisible.nodes.startNode;

import com.jd.cof.workflowvisible.DispatchStrategy;
import com.jd.cof.workflowvisible.QueueProcessor;
import com.jd.cof.workflowvisible.model.Order;
import com.jd.cof.workflowvisible.nodes.AbstractProcessor;
import org.apache.log4j.Logger;

import java.util.Random;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class StartProcess extends AbstractProcessor implements QueueProcessor {
    private static final Logger logger = Logger.getLogger(StartProcess.class);
    Random randomMaker = new Random();
    boolean cond1;

    public DispatchStrategy doProcess(Order param) throws Throwable {
        cond1 = randomMaker.nextBoolean();
        logger.info(String.format("StartProcess run, cond1[%s]", cond1));
        return new StartDispatch(cond1);
    }
}
