import java.sql.SQLOutput;
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibCalculate());
    }

    public static int fibCalculate() {
        return Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(10)
                .map(i -> i[0])
                .reduce((x, y) -> {
                    System.out.print(x + " ");
                    return x + y;
                })
                .orElse(0);

    }
}


