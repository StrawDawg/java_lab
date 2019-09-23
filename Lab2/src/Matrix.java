import java.util.Random;

public class Matrix {

   public int[][] mat;
   public int n;
   public int m;

    Matrix(int n, int m) {
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
                System.out.print(" " + mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void myTask() {
        int maxnum = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < n; l++) {
                    for (int k = 0; k < m; k++) {
                        if (mat[i][j] == mat[l][k] && i != l && j != k && mat[i][j] >= maxnum) {
                            maxnum = mat[i][j];
                            l = n;
                            k = m;
                        }
                    }
                }
            }
        }
        if (maxnum >= 0) {
            System.out.println("The max repetitive number in the matrix is: " + maxnum);
        } else {
            System.out.println("There is no repetitive numbers in the matrix.");
        }
    }
}
