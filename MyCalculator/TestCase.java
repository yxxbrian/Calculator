package MyCalculator;

/**
 * Created by Administrator on 2019/4/17.
 */
public class TestCase {

    public static void main(String[] args) {
        String input = "1+2*3+6-2/1+4/2"; //should be 13
        MyCalculator.calculate(input);
    }

}
