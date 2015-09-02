package com.jd.cof.provider;

import com.jd.cof.workflowvisible.engine.dispatchStrategy.deciderBasisProvider.AbstractDeciderBasisProvider;



/**
 * Created by wangxichun on 2015/9/2.
 */
public class DemoDecideBasisProvider extends AbstractDeciderBasisProvider {

    public DemoDecideBasisProvider() {
        putDeciderInfo("jyn", 2);
        putDeciderInfo("state", 5);
    }
}
