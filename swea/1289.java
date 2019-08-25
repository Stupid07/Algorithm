import java.util.Scanner;
public class Solution{
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int count = 0;
            char word = '0';
            char[] line = sc.next().toCharArray();
            for(int i = 0; i < line.length; i++) {
                if(line[i] != word) {
                    count++;
                    word = word == '0' ? '1' : '0';
                }
            }
            System.out.println("#"+test_case+" "+count);
        }
         
    }
}