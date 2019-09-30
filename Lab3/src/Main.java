import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Numbers test = new Numbers();

        System.out.println("Type in your text: ");
        do{
            String line = sc.nextLine();

            if(line.equals("")){
                break;
            }

            test.splitAndFind(line);
        }while(true);

        Collections.sort(test.listOfNums);

        System.out.println("Numbers in the increasing order:");
        for(int i = 0; i < test.listOfNums.size(); i++) {
            System.out.println(test.listOfNums.get(i));
        }
    }
}
