package com.jd.cof.workflowvisible.nodes.dNode;

import com.jd.cof.workflowvisible.DispatchResult;
import com.jd.cof.workflowvisible.DispatchStrategy;
import com.jd.cof.workflowvisible.ProcessEnum;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class DDispatch implements DispatchStrategy {

    public DispatchResult decide() {
        DispatchResult result = new DispatchResult();
        result.setNextActivity(ProcessEnum.End);
        return result;
    }
}
