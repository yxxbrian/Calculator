package MyCalculator;

import MyCalculator.Operation.Operand;
import javafx.geometry.Pos;

/**
 * Created by Administrator on 2019/4/14.
 */
public class MyCalculator {

    public static void calculate(String string){
        OperationList operationList = new CalcgramParser().parse(string);
        OperationList postfixedOperationList = PostfixConvert.convert(operationList);
        CalcOperationExecutor calcOperationExecutor = new CalcOperationExecutor();
        Operand operand = calcOperationExecutor.execute(postfixedOperationList);

        if(operand != null){
            System.out.println("RES: " + operand);
        }else {
            System.out.println("CALC ERROR!");
        }
    }

}
