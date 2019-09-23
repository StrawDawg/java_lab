import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter number of rows: ");
            int n = sc.nextInt();
            System.out.println("Enter number of columns: ");
            int m = sc.nextInt();
            Matrix test = new Matrix(n, m);
            test.printMatrix();
            test.myTask();
        } catch (InputMismatchException e) {
            System.out.println("Input error: not a number");
            return;
        }
    }
}
