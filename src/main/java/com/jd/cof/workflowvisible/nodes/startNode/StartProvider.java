package com.jd.cof.workflowvisible.nodes.startNode;

import com.jd.cof.workflowvisible.engine.dispatchStrategy.deciderBasisProvider.AbstractDeciderBasisProvider;

import java.util.Random;

/**
 * Created by wangxichun on 2015/9/2.
 */
public class StartProvider extends AbstractDeciderBasisProvider {

    public StartProvider() {
        putDeciderInfo("cond1", new Random().nextBoolean());
    }
}
