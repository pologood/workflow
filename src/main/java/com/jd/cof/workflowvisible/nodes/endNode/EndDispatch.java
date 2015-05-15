package com.jd.cof.workflowvisible.nodes.endNode;

import com.jd.cof.workflowvisible.DispatchResult;
import com.jd.cof.workflowvisible.DispatchStrategy;
import com.jd.cof.workflowvisible.ProcessEnum;

import javax.swing.*;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class EndDispatch implements DispatchStrategy {

    public EndDispatch() {
    }

    public DispatchResult decide() {
        DispatchResult result = new DispatchResult();
        result.setNextActivity(null);
        return result;
    }
}
