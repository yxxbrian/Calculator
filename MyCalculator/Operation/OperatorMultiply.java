package MyCalculator.Operation;

/**
 * Created by Administrator on 2019/4/14.
 */
public class OperatorMultiply extends Operator{
    public OperatorMultiply() {
        priority = PRIORITY_MULTIPLY;
    }

    @Override
    public Operand operate(Operand operand1, Operand operand2) {
        return operand1.multiply(operand2);
    }

    @Override
    public String strId() {
        return "*";
    }

    @Override
    public String toString() {
        return "OperatorMultiply{}";
    }
}
