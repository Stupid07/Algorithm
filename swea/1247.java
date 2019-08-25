import java.util.Scanner;
 
public class Solution {
    private static int T, N;
    private static int[] company = new int[] {0, 0};
    private static int[] home = new int[] {0, 0};
    private static int[][] points = null;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            N = sc.nextInt();
            company[0] = sc.nextInt();
            company[1] = sc.nextInt();
            home[0] = sc.nextInt();
            home[1] = sc.nextInt();
            points = new int[N][2];
            for(int i = 0; i < N; i++) {
                points[i][0] = sc.nextInt();
                points[i][1] = sc.nextInt();
            }
             
            int result = findPath(new boolean[N], company, 0);
            System.out.println("#"+testCase + " " + result);
        }
    }
     
    private static int findPath(boolean[] nodes, int[] prePoint, int weight) {
        boolean isFin = true;
        for(boolean node : nodes) {
            if(!node) {
                isFin = false;
                break;
            }
        }
         
        if(isFin) {
            return weight + myDestance(prePoint, home); 
        }
         
        int minResult = Integer.MAX_VALUE;
        for(int i = 0 ; i < nodes.length; i++) {
            if(!nodes[i]) {
                nodes[i] = true;
                int pathResult = findPath(nodes, points[i], weight + myDestance(prePoint, points[i]));
                minResult = myMin(minResult, pathResult);
                nodes[i] = false;
            }
        }
         
        return minResult;
    }
     
     
    private static int myMin(int a, int b) {
        if(a <= b) {
            return a;
        }
        return b;
    }
     
    private static int myDestance(int[] pointA, int[] pointB) {
        return myAbs(pointA[0] - pointB[0]) + myAbs(pointA[1] - pointB[1]);
    }
     
    private static int myAbs(int result) {
        if(result < 0) {
            return -result;
        }
        return result;
    }
}