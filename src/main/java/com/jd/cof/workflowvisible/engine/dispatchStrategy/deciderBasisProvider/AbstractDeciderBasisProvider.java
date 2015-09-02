package com.jd.cof.workflowvisible.engine.dispatchStrategy.deciderBasisProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxichun on 2015/9/2.
 */
public abstract class AbstractDeciderBasisProvider implements DecideBasisProvider {
    protected Map<String, Object> content = new HashMap<String, Object>();


    @Override
    public Map<String, Object> makeDecideBasis() {
        return content;
    }

    public void putDeciderInfo(String key, Object value) {
        content.put(key, value);
    }
}
