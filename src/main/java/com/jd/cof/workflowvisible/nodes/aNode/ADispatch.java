package com.jd.cof.workflowvisible.nodes.aNode;

import com.jd.cof.workflowvisible.DispatchResult;
import com.jd.cof.workflowvisible.DispatchStrategy;
import com.jd.cof.workflowvisible.ProcessEnum;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class ADispatch implements DispatchStrategy {
    private final boolean cond2;

    public ADispatch(boolean cond2) {
        this.cond2 = cond2;
    }

    public DispatchResult decide() {
        DispatchResult result = new DispatchResult();

        ProcessEnum next = null;
        if (cond2) {
            next = ProcessEnum.C;
        } else {
            next = ProcessEnum.D;
        }

        result.setNextActivity(next);
        return result;
    }

    public boolean isCond2() {
        return cond2;
    }
}
