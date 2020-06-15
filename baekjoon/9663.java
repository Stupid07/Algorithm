import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static int N;
    public static int[] array;
    public static int count;
    
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        array = new int[N];

        countCombination(0);

        System.out.println(count);
    }

    public static void countCombination(int depth){
        if(depth == N){
            count++;
            return;
        }

        for(int i = 0; i < N; i++){
            array[depth] = i;
            if(isPossible(depth)){
                countCombination(depth+1);
            }
        }
    }

    public static boolean isPossible(int depth){
        for(int i = 0 ; i < depth; i++){
            if(array[i] == array[depth] || (depth-i) == Math.abs(array[i] - array[depth])){
                return false;
            }
        }
        return true;
    }
}