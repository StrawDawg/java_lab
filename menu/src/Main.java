import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);

        do{
            Menu.showOptions();
            input = sc.nextLine();

            switch(input){
                case "0":
                    break;
                case "1":
                    Menu.factorial();
                    break;
                case "2":
                    Menu.reverse();
                    break;
                case "3":
                    Menu.find();
                    break;
                default:
                    System.out.println("Incorrect input data.");
            }
        }while(!input.equals("0"));
    }
}
