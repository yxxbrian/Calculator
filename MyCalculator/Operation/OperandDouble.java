package MyCalculator.Operation;

/**
 * Created by Administrator on 2019/4/14.
 */
public class OperandDouble extends Operand<Double> {

    public OperandDouble(Double num) {
        super(num);
    }

    /**
     * add two Operand
     */
    public OperandDouble add(OperandInteger op1){
        return new OperandDouble(getNum() + op1.getNum());
    }

    public OperandDouble add(OperandDouble op1) {
        return new OperandDouble(getNum() + op1.getNum());
    }

    @Override
    public Operand add(Operand e) {
        Class clz = e.getClass();

        if(clz == OperandInteger.class) {
            return add((OperandInteger)e);
        }else if(clz == OperandDouble.class){
            return add((OperandDouble)e);
        }else {
            throw new RuntimeException("Unsupported operand type");
        }
    }


    /**
     * minus two operand
     */

    @Override
    public Operand minus(Operand e) {
        Class clz = e.getClass();

        if(clz == OperandInteger.class) {
            return minus((OperandInteger) e);
        }else if(clz == OperandDouble.class){
            return minus((OperandDouble) e);
        }else {
            throw new RuntimeException("Unsupported operand type");
        }
    }

    private OperandDouble minus(OperandInteger op1) {
        return new OperandDouble(getNum() - op1.getNum());
    }

    private OperandDouble minus(OperandDouble op1) {
        return new OperandDouble(getNum() - op1.getNum());
    }


    /**
     * @param e
     * @return multiply result
     */

    @Override
    public Operand multiply(Operand e) {
        Class clz = e.getClass();

        if(clz == OperandInteger.class) {
            return multiply((OperandInteger) e);
        }else if(clz == OperandDouble.class){
            return multiply((OperandDouble) e);
        }else {
            throw new RuntimeException("Unsupported operand type");
        }
    }

    private OperandDouble multiply(OperandInteger op1) {
        return new OperandDouble(getNum() * op1.getNum());
    }

    private OperandDouble multiply(OperandDouble op1) {
        return new OperandDouble(getNum() * op1.getNum());
    }

    @Override
    public Operand devide(Operand e) {
        Class clz = e.getClass();

        if(clz == OperandInteger.class) {
            return devide((OperandInteger) e);
        }else if(clz == OperandDouble.class){
            return devide((OperandDouble) e);
        }else {
            throw new RuntimeException("Unsupported operand type");
        }
    }

    private OperandDouble devide(OperandInteger op1) {
        return new OperandDouble(getNum() / op1.getNum());
    }

    private OperandDouble devide(OperandDouble op1) {
        return new OperandDouble(getNum() / op1.getNum());
    }
}
