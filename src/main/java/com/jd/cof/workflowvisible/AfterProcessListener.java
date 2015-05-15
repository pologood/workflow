package com.jd.cof.workflowvisible;

import com.jd.cof.workflowvisible.model.Order;

/**
 * Created by wangxichun on 2015/5/8.
 */
public interface AfterProcessListener {
    public void afterProcess(Order order);
}
