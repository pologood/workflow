package com.jd.cof.workflowvisible.nodes.aNode;

import com.jd.cof.workflowvisible.DispatchStrategy;
import com.jd.cof.workflowvisible.QueueProcessor;
import com.jd.cof.workflowvisible.engine.ScriptingDispatchStrategy;
import com.jd.cof.workflowvisible.model.Order;
import com.jd.cof.workflowvisible.nodes.AbstractProcessor;

import java.util.Random;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class AProcess extends AbstractProcessor implements QueueProcessor {
    public static final String cond2Key = "cond2Key";
    Random randomMaker = new Random();
    boolean cond2;

    private ScriptingDispatchStrategy dispatchStrategy;

    public DispatchStrategy doProcess(Order param) throws Throwable {
        dispatchStrategy.addContext(cond2Key, randomMaker.nextBoolean());
        return dispatchStrategy; //这里是每个订单在每个环节都有一个Dispatch的体现
    }

    public ScriptingDispatchStrategy getDispatchStrategy() {
        return dispatchStrategy;
    }

    public void setDispatchStrategy(ScriptingDispatchStrategy dispatchStrategy) {
        this.dispatchStrategy = dispatchStrategy;
    }
}
