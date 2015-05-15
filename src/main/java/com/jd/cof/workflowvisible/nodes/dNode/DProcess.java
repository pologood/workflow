package com.jd.cof.workflowvisible.nodes.dNode;

import com.jd.cof.workflowvisible.DispatchStrategy;
import com.jd.cof.workflowvisible.QueueProcessor;
import com.jd.cof.workflowvisible.model.Order;
import com.jd.cof.workflowvisible.nodes.AbstractProcessor;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class DProcess extends AbstractProcessor implements QueueProcessor {

    public DispatchStrategy doProcess(Order param) throws Throwable {
        return new DDispatch();
    }
}
