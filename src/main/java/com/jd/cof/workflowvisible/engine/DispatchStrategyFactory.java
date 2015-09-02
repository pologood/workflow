package com.jd.cof.workflowvisible.engine;

import com.jd.cof.workflowvisible.DispatchStrategy;

import java.util.Map;

/**
 * Created by wangxichun on 2015/5/14.
 */
public interface DispatchStrategyFactory {
    DispatchStrategy makeDispatch();
}
