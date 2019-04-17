package MyCalculator;

import MyCalculator.Operation.Operand;
import MyCalculator.Operation.Operation;
import MyCalculator.Operation.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Administrator on 2019/4/14.
 */
public class CalcOperationExecutor {

    public Operand execute(OperationList operationList) {
        ListIterator<Operation> iterator = operationList.iterator();
        while (iterator.hasNext()) {
            Operation curOperation = iterator.next();
            if (curOperation instanceof Operator) {
                Operator operator = getAndRemovePreviousOperator(iterator);
                if (operator == null) {
                    System.out.println("syntax error near index " + iterator.nextIndex());
                }

                Operand secondOperand = getAndRemovePreviousOperand(iterator);
                Operand firstOperand = getAndRemovePreviousOperand(iterator);
                if (secondOperand == null || firstOperand == null) {
                    System.out.println("syntax error near index " + iterator.nextIndex());
                }

                CalcUnit calcUnit = new CalcUnit();
                calcUnit.setOperator(operator);
                calcUnit.pushOperand(firstOperand);
                calcUnit.pushOperand(secondOperand);

                Operand opRes = executeCalcUnit(calcUnit);

                iterator.add(opRes);
            }
        }

        if (operationList.getSize() == 1) {
            Operation operation = operationList.iterator().next();
            if (operation instanceof Operand) {
                System.out.println("execute successfully, result is " + operation);
                return (Operand) operation;
            }
        }

        System.out.println("calc failed, operation list now is " + operationList.toString());
        return null;
    }

    private Operand executeCalcUnit(CalcUnit calcUnit){
        Operator operator = calcUnit.getOperator();
        Operand operand1 = calcUnit.getOperands().get(0);
        Operand operand2 = calcUnit.getOperands().get(1);

        return operator.operate(operand1, operand2);
    }

    private Operand getAndRemovePreviousOperand(ListIterator<Operation> listIterator){
        if(listIterator.hasPrevious()) {
            try{
                Operand operator = (Operand)listIterator.previous();
                listIterator.remove();
                return operator;
            }catch (ClassCastException cex){
                return null;
            }
        }else {
            return null;
        }
    }

    private Operator getAndRemovePreviousOperator(ListIterator<Operation> listIterator){
        if(listIterator.hasPrevious()) {
            try{
                Operator operator = (Operator)listIterator.previous();
                listIterator.remove();
                return operator;
            }catch (ClassCastException cex){
                return null;
            }
        }else {
            return null;
        }
    }


    static class CalcUnit{

        public CalcUnit() {
            operandLimit = 2;
            operands = new ArrayList<Operand>(operandLimit);
        }

        Operator operator;
        int operandLimit;
        List<Operand> operands;

        void setOperator(Operator operator){
            this.operator = operator;
        }

        void pushOperand(Operand operand){
            if(operands.size() >= operandLimit)
                throw new RuntimeException("too many operands in this calcUnit");
            operands.add(operand);
        }

        public List<Operand> getOperands() {
            return operands;
        }

        public Operator getOperator() {
            return operator;
        }
    }


}
