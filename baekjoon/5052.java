import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	final static String YES = "YES\n", NO = "NO\n";
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(reader.readLine());
		for(int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(reader.readLine());
			MyList list = new MyList();
			boolean isCollision = false;
			String phoneNumber;
			for(int i = 0; i < N; i++) {
				phoneNumber = reader.readLine();
				if(!isCollision && list.push(phoneNumber)) {
					isCollision = true;
				}
			}
			if(isCollision) {
				writer.write(NO);
			}else {
				writer.write(YES);
			}
		}
		writer.close();
	}
	
	static class MyList{
		class Node{
			boolean isLast;
			Node[] childs;
			
			public Node() {
				childs = new Node[10];
			}
		}
		
		Node root;
		
		public MyList() {
			root = new Node();
		}
		
		public boolean push(String phoneNumber) {
			Node preNode = root;
			boolean isCollision = true;
			for(int i= 0, size= phoneNumber.length(); i < size; i++) {
				int number = phoneNumber.charAt(i) - '0';
				
				if(preNode.childs[number] == null) {
					isCollision = false;
					preNode.childs[number] = new Node();
				}
				
				preNode = preNode.childs[number];
				if(preNode.isLast) {
					isCollision = true;
					break;
				}
			}
			preNode.isLast = true;
			
			return isCollision;
		}
	}
}