import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result;
        StringTokenizer st;
        LinkedList<Integer> list = new LinkedList<>();
        int N, M, x, y;
        for(int test_case = 1; test_case <= 10; test_case++) {
            result = new StringBuilder().append("#").append(test_case).append(" ");
            N = Integer.parseInt(reader.readLine());
            st = new StringTokenizer(reader.readLine());
            while(st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            M = Integer.parseInt(reader.readLine());
            String[] commend = reader.readLine().trim().split("I");
            for(int i = 1; i<= M; i++) {
                st = new StringTokenizer(commend[i].trim());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                while(st.hasMoreTokens() && x <10) {
                    list.add(x++, Integer.parseInt(st.nextToken()));
                }
            }
            for(int i = 0; i < 10; i++) {
                result.append(list.removeFirst()).append(" ");
            }
            result.append("\n");
            list.clear();
            writer.write(result.toString());
        }
        writer.flush();
        writer.close();
    }
}