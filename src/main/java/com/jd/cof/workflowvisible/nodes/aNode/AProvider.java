package com.jd.cof.workflowvisible.nodes.aNode;

import com.jd.cof.workflowvisible.engine.dispatchStrategy.deciderBasisProvider.AbstractDeciderBasisProvider;

import java.util.Random;

/**
 * Created by wangxichun on 2015/9/2.
 */
public class AProvider extends AbstractDeciderBasisProvider {

    public AProvider() {
        putDeciderInfo("cond2", new Random().nextBoolean());
    }

}
