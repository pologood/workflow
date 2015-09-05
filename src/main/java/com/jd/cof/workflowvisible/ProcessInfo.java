package com.jd.cof.workflowvisible;

/**
 * Created by wangxichun on 2015/9/5.
 */
public interface ProcessInfo {
    Class getProcessClass();
    Class getProcessRunnerClass();
    Class getDispatchStrategyFactoryClass();

    String getName();
}
