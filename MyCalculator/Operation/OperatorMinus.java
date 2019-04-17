package MyCalculator.Operation;

/**
 * Created by Administrator on 2019/4/14.
 */
public class OperatorMinus extends Operator {

    public OperatorMinus() {
        priority = PRIORITY_MINUS;
    }

    @Override
    public Operand operate(Operand operand1, Operand operand2) {
        return operand1.minus(operand2);
    }

    @Override
    public String strId() {
        return "-";
    }

    @Override
    public String toString() {
        return "OperatorMinus{}";
    }
}
