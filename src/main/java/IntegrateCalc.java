import java.util.function.DoubleUnaryOperator;

public class IntegrateCalc {
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double stepSize = Math.pow(10, 8);
        double step = (b - a) / stepSize;

        double result = 0;
        for (double i = 0; i <= stepSize - 1; i++) {
            double x = a + i * step;
            double xNext = a + (i + 1) * step;
            double fApplied = f.applyAsDouble(x);
            result += fApplied * (xNext - x);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(integrate(x -> x + 2, 0, 10));
    }
}
