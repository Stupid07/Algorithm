import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution{
    static HashSet<Integer> set = new HashSet<>();
    static LinkedList<Integer> appendList =new LinkedList<>();
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        for(int test_case = 1; test_case <= T; test_case++) {
             
            N = Integer.parseInt(reader.readLine());
            tokens = new StringTokenizer(reader.readLine());
            set.add(0);
            for(int i = 0; i< N; i++) {
                int num = Integer.parseInt(tokens.nextToken());
                for(Integer number : set) {
                    appendList.add(number + num);
                }
                set.addAll(appendList);
                appendList.clear();
            }
             
            writer.write(new StringBuilder(16).append("#").append(test_case).append(" ").append(set.size()).append("\n").toString());
            set.clear();
             
        }
        writer.flush();
        writer.close();
    }
 
}