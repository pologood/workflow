package com.jd.cof.workflowvisible.nodes.cNode;

import com.jd.cof.workflowvisible.DispatchResult;
import com.jd.cof.workflowvisible.DispatchStrategy;
import com.jd.cof.workflowvisible.ProcessEnum;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class CDispatch implements DispatchStrategy {

    public CDispatch() {
    }

    public DispatchResult decide() {
        DispatchResult result = new DispatchResult();
        result.setNextActivity(ProcessEnum.End);
        return result;
    }
}
