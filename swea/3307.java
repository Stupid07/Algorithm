import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
 
public class Solution {
    static int N;
    static int max;
    static int[] numbers;
    static int[] choice;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for(int testCase = 1; testCase <= T; testCase++) {
            max = Integer.MIN_VALUE;
            N = Integer.parseInt(reader.readLine());
            numbers = new int[N];
            choice = new int[N];
            StringTokenizer tokens = new StringTokenizer(reader.readLine());
            int subMax;
            for(int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(tokens.nextToken());
                subMax = 0;
                for( int j = 0; j < i; j++) {
                    if(numbers[j] < numbers[i] && subMax < choice[j]) {
                        subMax = choice[j];
                    }
                }
                choice[i] = subMax +1;
                if(max < choice[i])
                    max = choice[i];
            }
            System.out.println("#" + testCase + " " + max);
        }
    }
     
}