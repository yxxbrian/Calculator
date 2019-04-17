package MyCalculator;

import MyCalculator.Operation.Operation;

import java.util.*;

/**
 * Created by Administrator on 2019/4/14.
 */
public class OperationList {

    public OperationList() {
        operationList = new LinkedList<Operation>();
    }

    private LinkedList<Operation> operationList;

    public void push(Operation operation) {
        operationList.addLast(operation);
    }

    public Operation peek() {
        return operationList.peek();
    }

    public Operation poll() {
        return operationList.pollFirst();
    }

    public ListIterator<Operation> iterator() {
        return operationList.listIterator();
    }

    public int getSize() {
        return operationList.size();
    }

    @Override
    public String toString() {
        return "OperationList{" +
                "operationList=" + Arrays.toString(operationList.toArray()) +
                '}';
    }
}
