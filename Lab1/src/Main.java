import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int k;
        double x;
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("Enter k: ");
            k = in.nextInt();

            System.out.println("Enter x: ");
            x = in.nextDouble();

            if(x < -1 || x >= 1) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid argument x");
            return;
        } catch (InputMismatchException ex) {
            System.out.println("Input error: not a number");
            return;
        }
        System.out.printf("%.15f %.15f", Taylor.getsumm(k, x), Math.log(1+x));
    }
}