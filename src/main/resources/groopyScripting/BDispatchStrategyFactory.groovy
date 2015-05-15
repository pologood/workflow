package groopyScripting

import com.jd.cof.workflowvisible.DispatchResult
import com.jd.cof.workflowvisible.DispatchStrategy
import com.jd.cof.workflowvisible.ProcessEnum
import com.jd.cof.workflowvisible.engine.DispatchStrategyFactory
import com.jd.cof.workflowvisible.nodes.bNode.BProcess

class BDispatchStrategyFactory implements DispatchStrategyFactory {

    @Override
    DispatchStrategy makeDispatch(final Map<String, Object> context) {
        return new DispatchStrategy() {
            @Override
            DispatchResult decide() {
                return new DispatchResult(((Boolean) context.get(BProcess.BProcess_key))? ProcessEnum.C: ProcessEnum.End , 0);
            }
        };
    }
}