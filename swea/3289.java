import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static final int MAX_N = 1000000;
    static int n, m;
    static int[] group = new int[MAX_N + 1];
     
    static int findParent(int number) {
        if(group[number] == 0) {
            return number;
        }
         
        return group[number] = findParent(group[number]);
    }
     
     
    static void union(int first, int second) {
        int firstParent = findParent(first);
        int secondParent = findParent(second);
         
        if(firstParent != secondParent) {
            group[firstParent] = secondParent;
        }
    }
     
    static char checkParent(int first, int second) {
        int firstParent = findParent(first);
        int secondParent = findParent(second);
         
        if(firstParent == secondParent) {
            return '1';
        }
         
        return '0';
    }
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        for(int testCase = 1; testCase <= T; testCase++) {
            tokens = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(tokens.nextToken());
            m = Integer.parseInt(tokens.nextToken());
            StringBuilder result = new StringBuilder(m).append('#').append(testCase).append(' ');
             
             
            char command;
            int firstNumber, secondNumber;
            for(int i = 0 ; i < m; i++) {
                tokens = new StringTokenizer(reader.readLine());
                command = tokens.nextToken().charAt(0);
                firstNumber = Integer.parseInt(tokens.nextToken());
                secondNumber = Integer.parseInt(tokens.nextToken());
                 
                if(command == '0') {
                    union(firstNumber, secondNumber);
                }else if(command == '1') {
                    result.append(checkParent(firstNumber, secondNumber));
                }
            }
             
             
            writer.write(result.append('\n').toString());
            Arrays.fill(group, 1, n+1, 0);
         
        }
        writer.flush();
        writer.close();
    }
}