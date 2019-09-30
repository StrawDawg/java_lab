import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Matrix {

   public int[][] mat;
   public int n;
   public int m;

    public Matrix(int n, int m) {
        Random random = new Random();

        this.n = n;
        this.m = m;
        mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = random.nextInt(100);
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("\t" + mat[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void myTask() {
        int maxnum = -1;
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                numbers.add(mat[i][j]);
            }
        }

        for(int i = 0; i < numbers.size(); i++){

            if(Collections.frequency(numbers, numbers.get(i)) == 1) {
                numbers.remove(numbers.get(i));
                i--;
            }
        }

        Collections.sort(numbers);
        
        if(!numbers.isEmpty()) {
            maxnum = numbers.get(numbers.size() - 1);
        }

        if (maxnum >= 0) {
            System.out.println("The max repetitive number in the matrix is: " + maxnum);
        } else {
            System.out.println("There is no repetitive numbers in the matrix.");
        }
    }
}
