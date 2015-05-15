package com.jd.cof.workflowvisible.engine;

import com.jd.cof.workflowvisible.DispatchResult;
import com.jd.cof.workflowvisible.DispatchStrategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxichun on 2015/5/12.
 */
public class ScriptingDispatchStrategy implements DispatchStrategy {
    private Map<String, Object> context = new HashMap();
    private ScriptingDecider decider;


    public DispatchResult decide() {
        return decider.makeDispatchResult(context);
    }

    public void addContext(String key, Object value) {
        context.put(key, value);
    }

    public Map<String, Object> getContext() {
        return context;
    }

    public void setContext(Map<String, Object> context) {
        this.context = context;
    }

    public ScriptingDecider getDecider() {
        return decider;
    }

    public void setDecider(ScriptingDecider decider) {
        this.decider = decider;
    }
}
