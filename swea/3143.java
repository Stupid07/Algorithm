import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        String[] words;
        String A, B;
        for(int test_case = 1; test_case <= T; test_case++) {
            int result = 0;
            words = reader.readLine().split(" ");
            A = words[0];
            B = words[1];
            result = A.length();
            A = A.replaceAll(B,"");
            result = ((result - A.length())/B.length()) + A.length();
             
            writer.write(new StringBuilder(8).append("#").append(test_case).append(" ").append(result).append("\n").toString());
        }
        writer.flush();
        writer.close();
    }
}