package MyCalculator.Operation;

/**
 * Created by Administrator on 2019/4/14.
 */
public class OperatorAdd extends Operator {

    public OperatorAdd() {
        priority = PRIORITY_ADD;
    }

    @Override
    public Operand operate(Operand operand1, Operand operand2) {
        return operand1.add(operand2);
    }

    @Override
    public String strId(){
        return "+";
    }

    @Override
    public String toString() {
        return "OperatorAdd{}";
    }
}
