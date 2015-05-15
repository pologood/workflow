package com.jd.cof.workflowvisible.engine;

import com.jd.cof.workflowvisible.ProcessEnum;
import com.jd.cof.workflowvisible.model.Order;

/**
 * Created by wangxichun on 2015/5/7.
 */
public interface ProcessNextPutter {
    void put(ProcessEnum nextStep, Order orderParam);
}
