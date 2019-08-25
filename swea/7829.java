import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase = 1; testCase <= T; testCase++) {
            int P = sc.nextInt();
            int[] numbers = new int[P];
            for(int i = 0 ; i < P; i++) {
                numbers[i] = sc.nextInt();
            }
            MySort.sort(numbers);
            if(P == 1) {
                System.out.println("#" +testCase + " " + (numbers[0]*numbers[0]));
            }else {
                System.out.println("#" +testCase + " " + (numbers[0]*numbers[P-1]));
            }
        }
    }
 
     
    static class MySort{
        public static void sort(int[] arr) {
            myMergeSort(0, arr.length-1, arr);
        }
         
        private static void myMergeSort(int start, int end, int[] arr) {
            if(start < end) {
                int mid = (start + end)/2;
                myMergeSort(start, mid, arr);
                myMergeSort(mid+1, end, arr);
                myMerge(start, mid, end, arr);
            }
        }
         
        private static void myMerge(int start, int mid, int end, int[] arr) {
            int k = start, lIdx=start, rIdx= mid+1;
            int[] temp = new int[arr.length];
             
            while(lIdx <= mid && rIdx <= end) {
                if(arr[lIdx] > arr[rIdx]) {
                    temp[k] = arr[rIdx++];
                }else {
                    temp[k] = arr[lIdx++];
                }
                k++;
            }
             
            if(lIdx<= mid) {
                while(lIdx <= mid) {
                    temp[k++] = arr[lIdx++];
                }
            }else if(rIdx <= end) {
                while(rIdx <= end) {
                    temp[k++] = arr[rIdx++];
                }
            }
             
            k = start;
            while(k <= end) {
                arr[k]=temp[k];
                k++;
            }
        }
    }
     
}