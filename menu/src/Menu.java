import java.nio.channels.ScatteringByteChannel;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static void showOptions(){
        System.out.println("\t\tMenu:\n1) Factorial");
        System.out.println("2) Reverse string\n3) Find substring\n0) Enough");
    }
    public static void factorial(){
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter a natural number(<=20): ");
            int num = s.nextInt();

            if (num > 20){
                throw new IllegalArgumentException();
            }
            else {
                System.out.println(factorialCalc(num));
            }
        } catch (IllegalArgumentException e){
            System.out.println("Invalid number.");
            factorial();
        } catch (InputMismatchException ex){
            System.out.println("Input error: not a number.");
            factorial();
        }
    }

    public static void reverse(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String line = s.nextLine();
        String reverseline = new StringBuffer(line).reverse().toString();
        System.out.println(reverseline);
    }

    public static void find(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a string:");
        String line = s.nextLine();
        System.out.println("Enter some symbols:");
        String subline = s.nextLine();
        if (line.contains(subline)){
            System.out.println("The string contains such a substring.");
        }
        else{
            System.out.println("The string  does not contain such a substring.");
        }
    }

    private static long factorialCalc(int n){
        long result = 1;

        for(int i = 2; i <= n; i++){
            result = result * i;
        }
        return result;
    }
}
