import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N,temp, result;
        StringBuilder sb;
        Stack<Character> charStack = new Stack<Character>();
        Stack<Integer> intStack = new Stack<Integer>();
        for(int test_case = 1; test_case <= 10; test_case++) {
            N = Integer.parseInt(reader.readLine());
            sb = new StringBuilder(N);
            String line = reader.readLine();
            for(int i=0; i <N; i++) {
                char data = line.charAt(i);
                if(Character.isDigit(data)) {
                    sb.append(data);
                }else {
                    switch(data) {
                    case ')':
                        while(charStack.peek() != '(') {// 괄호는 항상 유효성이 옳은 경우라고 했으니 empty를 검사하지않음
                            sb.append(charStack.pop());
                        }
                        charStack.pop();
                        break;
                    case '+':
                    case '-':
                        while(!charStack.isEmpty() && (charStack.peek() == '*' || charStack.peek() == '/')) {
                            sb.append(charStack.pop());
                        }
                    case '(':
                    case '*':
                    case '/':
                        charStack.push(data);
                        break;
                    }
                }
            }
            while(!charStack.isEmpty())
                sb.append(charStack.pop());
             
            //sb에 후위 표기식이 완성
             
            for(int i = 0,size = sb.length(); i < size ; i++) {
                char data = sb.charAt(i);
                if(Character.isDigit(data)) {
                    intStack.push(data-'0');
                }else {
                    switch(data) {
                    case '+':intStack.push(intStack.pop() + intStack.pop());
                        break;
                    case '*':intStack.push(intStack.pop() * intStack.pop());
                        break;
                    case '-':temp = intStack.pop();
                    intStack.push(intStack.pop() - temp);
                        break;
                    case '/':temp = intStack.pop();
                    intStack.push(intStack.pop() / temp);
                        break;
                    }
                }
            }
            result = intStack.pop();
             
            writer.write("#"+test_case+" "+result + "\n");
        }
        writer.flush();
        writer.close();
    }
}