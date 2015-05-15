package com.jd.cof.workflowvisible.nodes.bNode;

import com.jd.cof.workflowvisible.DispatchStrategy;
import com.jd.cof.workflowvisible.QueueProcessor;
import com.jd.cof.workflowvisible.model.Order;
import com.jd.cof.workflowvisible.nodes.AbstractProcessor;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class BProcessWithFactory extends AbstractProcessor implements QueueProcessor {
    public static final String BProcess_key = "BProcess_key";
    Random randomMaker = new Random();

    public DispatchStrategy doProcess(Order param) throws Throwable {

        Map<String, Object> map = new HashMap();
        map.put(BProcess_key, randomMaker.nextBoolean());


        return dispatchStrategyFactory.makeDispatch(map);
    }
}
