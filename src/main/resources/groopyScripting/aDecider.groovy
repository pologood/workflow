package groopyScripting

import com.jd.cof.workflowvisible.DispatchResult
import com.jd.cof.workflowvisible.ProcessEnum;
import com.jd.cof.workflowvisible.engine.ScriptingDecider
import com.jd.cof.workflowvisible.nodes.aNode.AProcess;

class aDecider implements ScriptingDecider {
    DispatchResult makeDispatchResult(Map<String, Object> context) {
        return new DispatchResult(((Boolean) context.get(AProcess.cond2Key))? ProcessEnum.C: ProcessEnum.D , 0);
    }
}