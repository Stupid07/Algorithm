import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(reader.readLine());
        MyStack stack = new MyStack(K);
        for(int i = 0; i < K; i++){
            stack.pushAndPop(Integer.parseInt(reader.readLine()));
        }
        System.out.println(stack.totalSum());
	}
	
	static class MyStack{
		int[] stack;
		int size;
		public MyStack(int size) {
			stack = new int[size];
			this.size = 0;
		}
		
		public void pushAndPop(int number) {
            if(number == 0){
                size--;
            }else{
                stack[size++] = number;
            }
		}
		
        public int totalSum(){
            int sum = 0;
            for(int i = 0; i < size; i++){
                sum += stack[i];
            }
            return sum;
        }
		
	}
}