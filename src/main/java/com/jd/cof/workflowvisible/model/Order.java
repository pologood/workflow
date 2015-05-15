package com.jd.cof.workflowvisible.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

public class Order implements Serializable {
    private static final long serialVersionUID = 4000906450653055233L;

    private long orderId;
    private boolean finished;

    public Order(long orderId) {
        this.orderId = orderId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
