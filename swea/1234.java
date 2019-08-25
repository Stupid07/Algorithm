import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N;
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        for(int test_case = 1; test_case <= 10; test_case++) {
            String[] line = reader.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            String data = line[1];
            for(int i=0; i < N; i++) {
                Character ch = data.charAt(i);
                 
                if(!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                }else {
                    stack.push(ch);
                }
                 
            }
             
            while(!stack.isEmpty()) {
                result.append(stack.pop());
            }
             
             
            result.append(" ");
            for(int temp = test_case; temp >0;temp/=10)
                result.append(temp%10);
             
            result.append("#");
            result.reverse();
            result.append("\n");
            writer.write(result.toString());
            result.delete(0, result.length());
        }
        writer.flush();
        writer.close();
    }
}