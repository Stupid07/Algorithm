import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringBuilder result;
        String word;
        String[] wordSet = new String[400];
        for(int test_case = 1; test_case <= T; test_case++) {
            result = new StringBuilder().append("#").append(test_case).append(" ");
            int N = Integer.parseInt(reader.readLine());
            word = reader.readLine();
            for(int i=0 , end = word.length(); i < end; i++) {
                wordSet[i]= word.substring(i);
            }
            Arrays.sort(wordSet,0,word.length());
            if(N < word.length())
                result.append(wordSet[N-1]);
            else
                result.append("none");
            writer.write(result.append("\n").toString());
        }
        writer.flush();
        writer.close();
    }
}