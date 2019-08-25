import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        final int STUDENTS = 1000;
        for(int test_case = 1; test_case <= T; test_case++) {
            int caseNumber = sc.nextInt();
            int result = 0;
            int[] numbers = new int[101];
            for(int i=0; i < STUDENTS; i++ ) {
                numbers[sc.nextInt()]++;
            }
            int maxIndex = numbers.length -1;
            for(int i=maxIndex -1; i >= 0; i--) {
                if(numbers[maxIndex]< numbers[i]) {
                    maxIndex = i;
                }
            }
            result = maxIndex;
            System.out.println("#"+caseNumber+" "+result);
        }
 
    }
}