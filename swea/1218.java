import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
 
public class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<Character>();
        int result, N;
        char data,topData;
        boolean isRight;
        for(int test_case = 1; test_case <= 10; test_case++) {
            result = 0;
            stack.clear();
            isRight = true;
            N = Integer.parseInt(reader.readLine());
            String line = reader.readLine();
            for(int i = 0, size = line.length(); i < size && isRight; i++) {
                data = line.charAt(i);
                if(data == '(' || data == '{' || data == '[' || data == '<') {
                    stack.push(data);
                }else if(stack.isEmpty()) {
                    isRight = false;
                }else{
                    topData = stack.pop();
                    switch(data) {
                    case ')':
                        if(topData != '(')
                            isRight = false;
                        break;
                    case '}':
                        if(topData != '{')
                            isRight = false;
                        break;
                    case ']':
                        if(topData != '[')
                            isRight = false;
                        break;
                    case '>':
                        if(topData != '<')
                            isRight = false;
                        break;
                    }
                }
            }
             
            if(isRight && stack.isEmpty())
                result = 1;
             
            writer.write(new StringBuilder().append("#").append(test_case).append(" ").append(result).append("\n").toString());
        }
        writer.flush();
        writer.close();
    }
}