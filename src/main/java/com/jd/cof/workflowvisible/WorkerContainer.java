package com.jd.cof.workflowvisible;

import com.jd.cof.workflowvisible.engine.DispatchStrategyFactory;
import com.jd.cof.workflowvisible.engine.ProcessRunner;
import com.jd.cof.workflowvisible.engine.ThreadPoolExecutorWorker;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by wangxichun on 2015/9/5.
 */
public class WorkerContainer {
    private Logger logger = Logger.getLogger(this.getClass());
    private Set<ProcessInfo> processInfoSet;

    @Resource
    AutowireCapableBeanFactory beanFactory;


    public void setProcessInfoSet(Set<ProcessInfo> processInfoSet) {
        this.processInfoSet = processInfoSet;
    }


    public void init() {
        for (ProcessInfo pi : processInfoSet) {
            try {
                ThreadPoolExecutorWorker worker = new ThreadPoolExecutorWorker();
                inject(worker, pi);
                worker.start();
            } catch (Throwable t) {
                logger.error(String.format("exception when init Processor[%s], exception msg[%s]", pi.getName(), t.getMessage()));
            }

        }
    }

    private void inject(ThreadPoolExecutorWorker worker, ProcessInfo pi) throws IllegalAccessException, InstantiationException {
        DispatchStrategyFactory dispatchStrategyFactory = (DispatchStrategyFactory) pi.getDispatchStrategyFactoryClass().newInstance();
        beanFactory.autowireBean(dispatchStrategyFactory);

        QueueProcessor processor = (QueueProcessor) pi.getProcessClass().newInstance();
        beanFactory.autowireBean(processor);

        ProcessRunner runner = (ProcessRunner) pi.getProcessRunnerClass().newInstance();
        beanFactory.autowireBean(runner);

        processor.setDispatchStrategyFactory(dispatchStrategyFactory);
        runner.setProcessor(processor);

        worker.setProcessRunner(runner);

    }

}
