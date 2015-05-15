package com.jd.cof.workflowvisible.nodes.bNode;

import com.jd.cof.workflowvisible.DispatchResult;
import com.jd.cof.workflowvisible.DispatchStrategy;
import com.jd.cof.workflowvisible.ProcessEnum;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class BDispatch implements DispatchStrategy {
    private final boolean cond3;

    public BDispatch(boolean cond3) {
        this.cond3 = cond3;
    }

    public DispatchResult decide() {
        DispatchResult result = new DispatchResult();

        ProcessEnum next = null;
        if (cond3) {
            next = ProcessEnum.C;
        } else {
            next = ProcessEnum.End;
        }

        result.setNextActivity(next);
        return result;
    }

    public boolean isCond3() {
        return cond3;
    }
}
