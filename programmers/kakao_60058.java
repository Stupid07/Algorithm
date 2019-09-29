import java.util.Stack;
class Solution {
    public String solution(String p) {
        StringBuilder answer = new StringBuilder(p.length());
        Stack<String> stack = new Stack<>();
        stack.push(p);
        String word, temp;
        StringBuilder builder;
        int i, size, nextCount;
        int[] count = new int[2];
        boolean isComplete;
        while(!stack.isEmpty()) {
        	word = stack.pop();
        	if(word.length() == 0) {
        		continue;
        	}
        	count[0] = count[1] = 0;
        	isComplete = true;
        	
        	count[word.charAt(0) -'(']++;
        	for(i = 1, size = word.length(); i < size; i++) {
        		if(count[0] == count[1]) {
        			break;
        		}
        		nextCount = word.charAt(i) -'(';
                if(count[0] < count[1]) {
        			isComplete = false;
        		}
        		count[nextCount]++;
        	}
        	if(isComplete) {
        		answer.append(word.substring(0, i));
        	}else {
        		answer.append("(");
        		if(i-1 != 1) {
        			builder = new StringBuilder(i-2);
        			temp = word.substring(1, i-1);
        			for(int k = 0, len = temp.length(); k < len; k++) {
        				if(temp.charAt(k) == '(') {
        					builder.append(')');
        				}else {
        					builder.append('(');
        				}
        			}
        			stack.push(builder.toString());
        		}
        		stack.push(")");
        	}
        	
        	if(i != word.length()) {
        		stack.push(word.substring(i,word.length()));
        	}
        }
        return answer.toString();
    }
}