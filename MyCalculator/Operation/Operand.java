package MyCalculator.Operation;

import MyCalculator.MyCalculator;

/**
 * Created by Administrator on 2019/4/14.
 */
public abstract class Operand <E> extends Operation {

    public Operand(E num) {
        this.num = num;
    }

    private E num;

    public E getNum() {
        return num;
    }

    public abstract Operand add(Operand e);

    public abstract Operand minus(Operand e);

    public abstract Operand multiply(Operand e);

    public abstract Operand devide(Operand e);

    @Override
    public String toString() {
        return "" + num;
    }
}
