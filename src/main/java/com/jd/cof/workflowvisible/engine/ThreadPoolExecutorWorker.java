package com.jd.cof.workflowvisible.engine;

import org.apache.log4j.Logger;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class ThreadPoolExecutorWorker {
    private final Logger logger = Logger.getLogger(getClass());

    ThreadPoolExecutor executor;
    ProcessRunner processRunner;

    int threadNum;

    public void start() {
        executor = new ThreadPoolExecutor(threadNum, threadNum, 0, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(threadNum));

        for (int i=0;i<threadNum;i++) {
            executor.execute(processRunner);
        }

    }

    public int getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(int threadNum) {
        this.threadNum = threadNum;
    }

    public ProcessRunner getProcessRunner() {
        return processRunner;
    }

    public void setProcessRunner(ProcessRunner processRunner) {
        this.processRunner = processRunner;
    }
}
