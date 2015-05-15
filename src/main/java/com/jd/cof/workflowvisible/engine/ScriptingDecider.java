package com.jd.cof.workflowvisible.engine;

import com.jd.cof.workflowvisible.DispatchResult;

import java.util.Map;

/**
 * Created by wangxichun on 2015/5/12.
 */
public interface ScriptingDecider {
    DispatchResult makeDispatchResult(Map<String, Object> context);
}
