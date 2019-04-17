package MyCalculator.Operation;

import MyCalculator.MyCalculator;

/**
 * Created by Administrator on 2019/4/14.
 */
public abstract class Operator extends Operation{

    final int PRIORITY_ADD = 1;
    final int PRIORITY_MINUS = 1;
    final int PRIORITY_MULTIPLY = 2;
    final int PRIORITY_DEVIDE = 2;

    int priority = 0;

    public int getPriority(){
        if(priority == 0)
            throw new RuntimeException("priority not initialized");
        return priority;
    }

    public int comparePriority(Operator operator)
    {
        return getPriority() - operator.getPriority();
    }

    public abstract Operand operate(Operand operand1, Operand operand2);

    public abstract String strId();

}
