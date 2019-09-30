import java.util.ArrayList;
import java.util.List;

public class Numbers {

    public List<Integer> listOfNums;

    public Numbers() {
        listOfNums = new ArrayList<Integer>();
    }

    public void splitAndFind(String line){
        String[] words = line.split("[\\s.,]+");

        for(int i = 0; i < words.length; i++){
            if(isNum(words[i])){
                listOfNums.add(Integer.parseInt(words[i]));
            }
        }
    }

    public static boolean isNum(String strNum) {
        try {
            int num = Integer.parseInt(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

}
