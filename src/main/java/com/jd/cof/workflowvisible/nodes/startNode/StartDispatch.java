package com.jd.cof.workflowvisible.nodes.startNode;

import com.jd.cof.workflowvisible.DispatchResult;
import com.jd.cof.workflowvisible.DispatchStrategy;
import com.jd.cof.workflowvisible.ProcessEnum;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class StartDispatch implements DispatchStrategy {
    private final boolean cond1;

    public StartDispatch(boolean cond1) {
        this.cond1 = cond1;
    }

    public DispatchResult decide() {
        DispatchResult result = new DispatchResult();

        ProcessEnum next = null;
        if (cond1) {
            next = ProcessEnum.A;
        } else {
            next = ProcessEnum.B;
        }

        result.setNextActivity(next);
        return result;
    }

    public boolean isCond1() {
        return cond1;
    }
}
