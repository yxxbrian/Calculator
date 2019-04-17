package MyCalculator.Operation;

/**
 * Created by Administrator on 2019/4/14.
 */
public class OperatorDevide extends  Operator{

    public OperatorDevide() {
        priority = PRIORITY_DEVIDE;
    }

    @Override
    public Operand operate(Operand operand1, Operand operand2) {
        return operand1.devide(operand2);
    }

    @Override
    public String strId() {
        return "/";
    }

    @Override
    public String toString() {
        return "OperatorDevide{}";
    }
}
