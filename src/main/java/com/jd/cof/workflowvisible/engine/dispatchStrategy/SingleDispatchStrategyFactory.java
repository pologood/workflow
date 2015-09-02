package com.jd.cof.workflowvisible.engine.dispatchStrategy;

import com.jd.cof.workflowvisible.DispatchResult;
import com.jd.cof.workflowvisible.ProcessEnum;

/**
 * Created by wangxichun on 2015/9/2.
 */
public class SingleDispatchStrategyFactory extends AbstractDispatchStrategyFactory{
    private static final int FINISH_VALUE = 1;

    DispatchResult dispatchResult;


    public SingleDispatchStrategyFactory(String nextProcessName, int finishValue) {
        if (finishValue == FINISH_VALUE ) {
            dispatchResult = new DispatchResult(ProcessEnum.Null, finishValue);
        } else {
            dispatchResult = new DispatchResult(ProcessEnum.getInstanceByName(nextProcessName), finishValue);
        }

    }

    @Override
    public DispatchResult makeDispatchResult() {
        return dispatchResult;
    }
}
