package MyCalculator;

import MyCalculator.Operation.Operand;
import MyCalculator.Operation.Operation;
import MyCalculator.Operation.Operator;

/**
 * Created by Administrator on 2019/4/15.
 */
public class PostfixConvert {

    public static OperationList convert(OperationList operationList){
        OperationStack operationStack = new OperationStack();
        OperationList destOperationList = new OperationList();

        Operation op = null;
        while ((op = operationList.poll()) != null)
        {
            if(op instanceof Operand) {
                destOperationList.push(op);
            }else if(op instanceof Operator) {
                Operator curOperator = (Operator)op;

                if(operationStack.size() == 0) {
                    operationStack.push(curOperator);
                }else {
                    Operator peekOperator = null;
                    while (operationStack.size() != 0
                            && (peekOperator = (Operator)operationStack.peek()) != null
                            && peekOperator.getPriority() >= curOperator.getPriority())
                    {
                        Operation popOperator = operationStack.pop();
                        destOperationList.push(popOperator);
                    }
                    operationStack.push(op);
                }
            }
        }

        while (operationStack.size() != 0)
        {
            destOperationList.push((Operator)operationStack.pop());
        }

        return destOperationList;
    }

}
