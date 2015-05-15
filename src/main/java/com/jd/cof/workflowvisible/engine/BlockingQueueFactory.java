package com.jd.cof.workflowvisible.engine;

import com.jd.cof.workflowvisible.ProcessEnum;
import com.jd.cof.workflowvisible.model.Order;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class BlockingQueueFactory {
    Map<String, BlockingQueue> map;

    public ConcurrentMap<ProcessEnum, BlockingQueue<Order>> createInstance() {
        ConcurrentMap<ProcessEnum, BlockingQueue<Order>> result = new ConcurrentHashMap<ProcessEnum, BlockingQueue<Order>>();
        for (Map.Entry<String,BlockingQueue> me: map.entrySet()) {
            result.put(ProcessEnum.getInstanceByName(me.getKey()), me.getValue());
        }
        return result;
    }

    public Map<String, BlockingQueue> getMap() {
        return map;
    }

    public void setMap(Map<String, BlockingQueue> map) {
        this.map = map;
    }
}
