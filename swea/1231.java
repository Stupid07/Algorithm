import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result;
        int N;
        char[] tree = new char[101];
        for(int test_case = 1; test_case <= 10; test_case++) {
            N = Integer.parseInt(reader.readLine());
            result = new StringBuilder(N + 4).append("#").append(test_case).append(" ");
            for(int i=1; i <= N; i++) {
                tree[i] = reader.readLine().split(" ")[1].charAt(0);
            }
            preorder(result, N, tree, 1);
            result.append("\n");
            writer.write(result.toString());
        }
        writer.flush();
        writer.close();
    }
     
    public static void preorder(StringBuilder sb, int N, char[] tree, int index) {
        if(index <= N) {
            preorder(sb, N, tree, index *2);
            sb.append(tree[index]);
            preorder(sb, N, tree, index *2 +1);
        }
    }
}