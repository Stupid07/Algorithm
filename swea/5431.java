import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        boolean[] students = new boolean[101];
        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            Arrays.fill(students, true);
            for(int i = 0; i < K; i++) {
                students[sc.nextInt()] = false;
            }
             
            System.out.print("#"+test_case+" ");
            for(int i = 1; i <= N; i++) {
                if(students[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}