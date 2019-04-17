package MyCalculator;

import MyCalculator.Operation.*;

/**
 * Created by Administrator on 2019/4/14.
 */
public class CalcgramParser {

    public CalcgramParser() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(new OperatorAdd().strId())
                .append(new OperatorMinus().strId())
                .append(new OperatorMultiply().strId())
                .append(new OperatorDevide().strId());
        operations = stringBuilder.toString();
    }

    String operations;

    public OperationList parse(String calcString)
    {
        OperationList operationList = new OperationList();

        int index = 0;
        int length = calcString.length();
        int handleStart = 0;
        while (index < length)
        {
            if(operations.indexOf(calcString.charAt(index)) >= 0)
            {
                //handle operand
                String operandStr = calcString.substring(handleStart, index);
                Operand operand = stringToOperand(operandStr);
                operationList.push(operand);

                //handle operator
                Operator operator = stringToOperator(calcString.substring(index,index+1));
                operationList.push(operator);

                handleStart = ++index;
                continue;
            }
            ++index;
        }

        if(index-1 >= handleStart)
        {
            String operandStr = calcString.substring(handleStart, index);
            Operand operand = stringToOperand(operandStr);
            operationList.push(operand);
        }

        return operationList;
    }

    public Operand stringToOperand(String operand){
        if(operand.indexOf('.') < operand.length()) {
            Double dblNum = Double.valueOf(operand);
            return new OperandDouble(dblNum);
        }else {
            Integer integer = Integer.valueOf(operand);
            return new OperandInteger(integer);
        }
    }

    public Operator stringToOperator(String operator)
    {
        if(operator.length() == 1) {
            if(operator.equals(new OperatorAdd().strId()))
                return new OperatorAdd();
            else if(operator.equals(new OperatorMinus().strId()))
                return new OperatorMinus();
            else if (operator.equals(new OperatorMultiply().strId()))
                return new OperatorMultiply();
            else if (operator.equals(new OperatorDevide().strId()))
                return new OperatorDevide();
            else
                throw new RuntimeException("Invalid operator");
        }
        else
            throw new RuntimeException("Invalid operator string");
    }

}
