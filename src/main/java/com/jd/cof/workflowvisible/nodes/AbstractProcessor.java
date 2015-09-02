package com.jd.cof.workflowvisible.nodes;

import com.jd.cof.workflowvisible.AfterProcessListener;
import com.jd.cof.workflowvisible.DispatchStrategy;
import com.jd.cof.workflowvisible.QueueProcessor;
import com.jd.cof.workflowvisible.engine.DispatchStrategyFactory;
import com.jd.cof.workflowvisible.model.Order;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by wangxichun on 2015/5/7.
 */
public abstract class AbstractProcessor implements QueueProcessor {
    protected final Logger loggger = Logger.getLogger(this.getClass());

    protected Set<AfterProcessListener> afterProcessListenerSet = new HashSet<AfterProcessListener>();

    public DispatchStrategy process(Order order) throws Throwable {
        doProcess(order);
        afterProcess(order);
        return dispatchStrategyFactory.makeDispatch();
    }

    public abstract void doProcess(Order order) throws Throwable;


    public String getName() {
        return this.getClass().getSimpleName();
    }

    public void addAfterListener(AfterProcessListener afterProcessListener) {
        afterProcessListenerSet.add(afterProcessListener);
    }

    protected void afterProcess(Order order) {
        for (AfterProcessListener listener: afterProcessListenerSet) {
            listener.afterProcess(order);
        }
    }


    protected DispatchStrategyFactory dispatchStrategyFactory;

    public DispatchStrategyFactory getDispatchStrategyFactory() {
        return dispatchStrategyFactory;
    }

    public void setDispatchStrategyFactory(DispatchStrategyFactory dispatchStrategyFactory) {
        this.dispatchStrategyFactory = dispatchStrategyFactory;
    }
}
