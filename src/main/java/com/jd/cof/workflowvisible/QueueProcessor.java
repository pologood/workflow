package com.jd.cof.workflowvisible;

import com.jd.cof.workflowvisible.engine.DispatchStrategyFactory;
import com.jd.cof.workflowvisible.model.Order;

/**
 * Created by wangxichun on 2015/5/7.
 */
public interface QueueProcessor {
    DispatchStrategy process(Order param) throws Throwable ;

    String getName();

    void addAfterListener(AfterProcessListener afterProcessListener);

    void setDispatchStrategyFactory(DispatchStrategyFactory factory);
}
