import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		int size = line.length();
		int result = 0, i;
		Stack<Character> stack = new Stack<>();
		Stack<Integer> numStack = new Stack<>();
		for(i =0; i < size; i++) {
			char preChar = line.charAt(i);
			if(preChar == '('|| preChar == '[') {
				stack.push(preChar);
			}else if(stack.isEmpty()) {
				break;
			}else {
				// ')' ']'
				char beforeChar = stack.pop();
				if(preChar ==')' && beforeChar == '(') {
					if(!stack.isEmpty() && stack.peek() =='N') {
						numStack.push(numStack.pop() + 2);
					}else {
						numStack.push(2);
						stack.push('N');
					}
				}else if(preChar == ']' && beforeChar =='[') {
					if(!stack.isEmpty() && stack.peek() =='N') {
						numStack.push(numStack.pop() + 3);
					}else {
						numStack.push(3);
						stack.push('N');
					}
				}else if(beforeChar == 'N'){
					if(!stack.isEmpty() && preChar == ')' && stack.peek() == '(') {
						stack.pop();
						numStack.push(numStack.pop()*2);
						while(!stack.isEmpty() && stack.peek() == 'N') {
							stack.pop();
							numStack.push(numStack.pop() + numStack.pop());
						}
						stack.push('N');
					}else if(!stack.isEmpty() && preChar == ']' && stack.peek() == '[') {
						stack.pop();
						numStack.push(numStack.pop()*3);
						while(!stack.isEmpty() && stack.peek() == 'N') {
							stack.pop();
							numStack.push(numStack.pop() + numStack.pop());
						}
						stack.push('N');
					}else {
						break;
					}
				}else {
					break;
				}
			}
			
		}
		if(stack.size() == 1 && stack.peek() == 'N' && i == size && !numStack.isEmpty()) {
			result = numStack.pop();
		}
		
		System.out.println(result);
	}
}