import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution{
    static final int[] keypad = new int[] {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
    static int[] pattern = new int[1000];
    static int patternSize;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        String word;
        int wordSize;
        for(int testCase = 1; testCase <= T; testCase++) {
            int result = 0;
            tokens = new StringTokenizer(reader.readLine());
            word = tokens.nextToken();
            patternSize = word.length();
            for(int i = 0 ; i < patternSize ; i++) {
                pattern[i] = word.charAt(i) - '0';
            }
             
            N = Integer.parseInt(tokens.nextToken());
             
            tokens = new StringTokenizer(reader.readLine());
            for(int i = 0; i < N; i++) {
                word = tokens.nextToken();
                wordSize = word.length();
                if(patternSize != wordSize) {
                    continue;
                }
                int j;
                for(j = 0; j < wordSize; j++) {
                    if(pattern[j] !=keypad[word.charAt(j) - 'a']) {
                        break;
                    }
                }
                 
                if(j == patternSize) {
                    result++;
                }
            }
             
            writer.write(new StringBuilder(16).append('#').append(testCase).append(' ').append(result).append('\n').toString());
        }
        writer.flush();
        writer.close();
    }
}