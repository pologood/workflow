package com.jd.ognlDemo;

import ognl.Ognl;
import ognl.OgnlException;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangxichun on 2015/9/2.
 */
public class Taster {
    Map defaultContext = new HashMap();

    @Before
    public void setUp() {
        defaultContext.put("jyn", 2);
        defaultContext.put("state", 5);
    }

    @Test
    public void runSingle() throws OgnlException {
        String processNameExpression = "#jyn == 2 ? \"finish\":\"down\"";
        String finishValueExpression = "#state == 3 ? 4 : 6";

        System.out.println("processName: " + evalOgnl(processNameExpression));
        System.out.println("finishValue: " + evalOgnl(finishValueExpression));
    }

    private Object evalOgnl(String expression) throws OgnlException {
        return Ognl.getValue((String)expression, (Map)defaultContext, (Object)null);
    }
}
