import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
    static double[] combis;
    static final int MAX_COUNT = 19;
    static final int[] notPrimes = new int[] {0,1,4,6,8,9,10,12,14,15,16,18};
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        combis = new double[MAX_COUNT];
        combis[0] = 1;
        for(int i = 1 ; i < MAX_COUNT; i++) {
            combis[i] = combis[i-1] * (MAX_COUNT-i) / i;
        }
         
        for(int test_case = 1; test_case <= T; test_case++) {
            double result = 1.0;
            double perA = 0.0, perB = 0.0;
            double notPrimeA = 0.0, notPrimeB = 0.0;
            String[] line = reader.readLine().split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            perA = A/100.0;
            perB = B/100.0;
            for(int i = 0; i < notPrimes.length; i++) {
                int primeNum = notPrimes[i];
                notPrimeA += combis[primeNum] * Math.pow(perA, primeNum) * Math.pow(1-perA, MAX_COUNT -1 -primeNum);
                notPrimeB += combis[primeNum] * Math.pow(perB, primeNum) * Math.pow(1-perB, MAX_COUNT -1 -primeNum);
            }
            result -= notPrimeA * notPrimeB;
            writer.write(String.format("#%d %.6f\n", test_case,result));
        }
        writer.flush();
        writer.close();
    }
}