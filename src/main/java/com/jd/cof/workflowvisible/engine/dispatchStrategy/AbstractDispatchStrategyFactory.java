package com.jd.cof.workflowvisible.engine.dispatchStrategy;

import com.jd.cof.workflowvisible.DispatchResult;
import com.jd.cof.workflowvisible.DispatchStrategy;
import com.jd.cof.workflowvisible.engine.DispatchStrategyFactory;

/**
 * Created by wangxichun on 2015/9/2.
 */
public abstract class AbstractDispatchStrategyFactory implements DispatchStrategyFactory {
    @Override
    public DispatchStrategy makeDispatch() {
        return new DispatchStrategy() {
            @Override
            public DispatchResult decide() {
                return makeDispatchResult();
            }
        };
    }

    public abstract DispatchResult makeDispatchResult();
}
