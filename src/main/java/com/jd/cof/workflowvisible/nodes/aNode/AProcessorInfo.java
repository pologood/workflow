package com.jd.cof.workflowvisible.nodes.aNode;

import com.jd.cof.workflowvisible.ProcessInfo;

/**
 * Created by wangxichun on 2015/9/5.
 */
public class AProcessorInfo implements ProcessInfo {
    @Override
    public Class getProcessClass() {
        return AProcess.class;
    }

    @Override
    public Class getProcessRunnerClass() {
        return null;
    }

    @Override
    public Class getDispatchStrategyFactoryClass() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }
}
