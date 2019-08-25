import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeSet;
 
public class Solution {
    static final int MAX_NUMBER = 10;
    static int N , nSize;
    static LinkedList<Integer> numList = new LinkedList<>();
    static TreeSet<Integer> set = new TreeSet<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
             
            return o2 - o1;
        }
     
    });
    static int result;
     
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        for(int test_case = 1; test_case <= T; test_case++) {
            result = Integer.MAX_VALUE;
            tokens = new StringTokenizer(reader.readLine());
             
            for(int i = 0; i < MAX_NUMBER; i++) {
                if(tokens.nextToken().charAt(0) == '1') {
                    numList.add(i);
                    set.add(i);
                }
            }
             
            String temp =reader.readLine();
            nSize = temp.length();
            N = Integer.parseInt(temp);
             
            makeSet();
             
            findCal(N, 0);
             
            if(result == Integer.MAX_VALUE) result = -1;
             
            writer.write(new StringBuilder(16).append("#").append(test_case).append(" ").append(result).append("\n").toString());
            numList.clear();
            set.clear();
        }
        writer.flush();
        writer.close();
    }
     
    static void makeSet() {
        int tempNum;
        LinkedList<Integer> temp = new LinkedList<>();
        for(int i = 1, end = nSize; i < end; i++) {
            for(Integer setNum : set) {
                tempNum = setNum * 10;
                for(Integer num : numList) {
                    temp.add(tempNum + num);
                }
            }
             
            set.addAll(temp);
            temp.clear();
        }
    }
     
    static void findCal(int num, int size) {
        if(set.contains(num)) {
            size += String.valueOf(num).length() + 1;
            result = Math.min(result, size);
            return;
        }
         
        for(Integer setNum : set) {
            if(setNum > 1 && setNum < num && (num % setNum == 0)) {
                 
                findCal(num / setNum, size + checkLength(setNum) + 1);
            }
        }
         
    }
     
    static int checkLength(int num) {
        return String.valueOf(num).length();
    }
     
}