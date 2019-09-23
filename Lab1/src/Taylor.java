public class Taylor {
    public static double getsumm(int k, double x) {
        int i = 0;
        double result = 0.0, currentComponent = 0.0;
        do {
            i++;
            currentComponent = calculation(i, x);
            result += currentComponent;
        } while (Math.abs(calculation(i, x)) >= Math.pow(10, -1 * k));
        return result;
    }
    private static double calculation(int i, double x) {
        return Math.pow(-1, i + 1.0) * Math.pow(x, i) / i;
    }
}
