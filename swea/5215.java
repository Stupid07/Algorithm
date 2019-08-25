import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            /////////////////////////////////////////////////////////////////////////////////////////////
            int maxScore = 0;
            int n = sc.nextInt();
            int limitCal = sc.nextInt();
            ArrayList<Integer> calList = new ArrayList<Integer>();
            ArrayList<Integer> scoreList = new ArrayList<Integer>();
            for(int i = 0; i < n; i++) {
                int score = sc.nextInt();
                int calorie = sc.nextInt();
                int sizeOfCalList = calList.size();
                for(int j = 0 ; j < sizeOfCalList; j++) {
                    if((calList.get(j) + calorie) <= limitCal) {
                        calList.add(calList.get(j) + calorie);
                        scoreList.add(scoreList.get(j) + score);
                    }
                }
                calList.add(calorie);
                scoreList.add(score);
            }
            for(Integer score : scoreList) {
                if(score > maxScore) {
                    maxScore = score;
                }
            }
             
            System.out.println("#" +test_case + " " + maxScore);
            /////////////////////////////////////////////////////////////////////////////////////////////
        }
    }
}