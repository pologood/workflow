package com.jd.cof.workflowvisible;

/**
 * Created by wangxichun on 2015/5/7.
 */
public class DispatchResult {
    private ProcessEnum nextActivity;
    private int isFinish;


    /**
     * @return the nextActivity
     */
    public ProcessEnum getNextActivity() {
        return nextActivity;
    }


    /**
     * @param nextActivity the nextActivity to set
     */
    public void setNextActivity(ProcessEnum nextActivity) {
        this.nextActivity = nextActivity;
    }


    /**
     * @return the isFinish
     */
    public int getIsFinish() {
        return isFinish;
    }


    /**
     * @param isFinish the isFinish to set
     */
    public void setIsFinish(int isFinish) {
        this.isFinish = isFinish;
    }


    public String toString() {
        return "isFinish is:" + isFinish + ", nextActivity is:" + nextActivity;
    }
}
