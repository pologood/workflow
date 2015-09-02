package com.jd.cof.workflowvisible.engine.dispatchStrategy;

import com.alibaba.fastjson.JSON;
import com.jd.cof.workflowvisible.DispatchResult;
import com.jd.cof.workflowvisible.ProcessEnum;
import com.jd.cof.workflowvisible.engine.dispatchStrategy.deciderBasisProvider.DecideBasisProvider;
import ognl.Ognl;
import ognl.OgnlException;

import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Created by wangxichun on 2015/9/2.
 */
public class ExpressionDispatchStrategyFactory extends AbstractDispatchStrategyFactory{

    @NotNull
    DecideBasisProvider decideBasisProvider;
    @NotNull
    String processNameExpr; //TODO 可以启动时检查表达式能否解析成功。
    @NotNull
    String finishValueExpr;


    @Override
    public DispatchResult makeDispatchResult() {
        Map context = decideBasisProvider.makeDecideBasis();

        String processName = (String) evalOgnl(processNameExpr, context);
        Integer finishValue = (Integer) evalOgnl(finishValueExpr, context);

        return  new DispatchResult(ProcessEnum.getInstanceByName(processName), finishValue);
    }

    public void setProcessNameExpr(String processNameExpr) {
        this.processNameExpr = processNameExpr;
    }

    public void setFinishValueExpr(String finishValueExpr) {
        this.finishValueExpr = finishValueExpr;
    }

    public void setDecideBasisProvider(DecideBasisProvider decideBasisProvider) {
        this.decideBasisProvider = decideBasisProvider;
    }


    private Object evalOgnl(String expression,Map defaultContext) {
        try {
            return Ognl.getValue((String) expression, (Map) defaultContext, (Object) null);
        } catch (OgnlException e) {
            throw new IllegalArgumentException(String.format("expression[%s], contextInfo[%s], exceptionMsg[%s]", expression, JSON.toJSON(defaultContext),e.getMessage()), e);
        }

    }
}
