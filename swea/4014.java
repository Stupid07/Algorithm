import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    static int N, X, result;
    static int[][] map = new int[20][20];
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        StringTokenizer tokens;
        for(int testCase = 1; testCase <= T; testCase++) {
            result = 0;
            tokens = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokens.nextToken());
            X = Integer.parseInt(tokens.nextToken());
            for(int i = 0 ; i < N; i++) {
                tokens = new StringTokenizer(reader.readLine());
                for(int j = 0 ; j < N; j++) {
                    map[i][j] = Integer.parseInt(tokens.nextToken());
                }
            }
             
            boolean isRowFine, isColumnFine;
            int rowVal, rowCount, columnVal, columnCount;
             
            for(int i = 0 ; i < N; i++) {
                 
                rowVal = map[i][0];
                rowCount = 1;
                isRowFine = false;
                 
                for(int j = 1 ; j < N; j++) {
                     
                    if(map[i][j] == rowVal) {
                        rowCount++;
                        if(isRowFine && rowCount == X) {
                            isRowFine = false;
                            rowCount = 0;
                        }
                    }else {
                        if(isRowFine) { // 아직 필수가 차기전에 다른 크기가 나와버림
                            break;
                        }if(map[i][j]+1 == rowVal) {
                            rowVal = map[i][j];
                            rowCount = 1;
                            isRowFine = true;
                            //다음 오는게 작을 경우 ( 일정 카운트가 필요함 )
                        }else if(map[i][j] == rowVal + 1) {
                            if(rowCount < X) {
                                isRowFine = true;
                                break;
                            }
                             
                            rowVal = map[i][j];
                            rowCount = 1;
                            // 다음 오는게 클 경우 ( 일정 카운트가 있어야함 )
                        }else {
                            isRowFine = true;
                            break;
                            //너무 큰 차이
                        }
                    }
                     
                }
                 
                if(!isRowFine) {
                    result++;
                }
                 
                columnVal = map[0][i];
                columnCount = 1;
                isColumnFine = false;
                 
                 
                for(int j = 1 ; j < N; j++) {
                    if(map[j][i] == columnVal) {
                        columnCount++;
                        if(isColumnFine && columnCount == X) {
                            isColumnFine = false;
                            columnCount = 0;
                        }
                    }else {
                        if(isColumnFine) { // 아직 필수가 차기전에 다른 크기가 나와버림
                            break;
                        }if(map[j][i]+1 == columnVal) {
                            columnVal = map[j][i];
                            columnCount = 1;
                            isColumnFine = true;
                            //다음 오는게 작을 경우 ( 일정 카운트가 필요함 )
                        }else if(map[j][i] == columnVal + 1) {
                            if(columnCount < X) {
                                isColumnFine = true;
                                break;
                            }
                             
                            columnVal = map[j][i];
                            columnCount = 1;
                            // 다음 오는게 클 경우 ( 일정 카운트가 있어야함 )
                        }else {
                            isColumnFine = true;
                            break;
                            //너무 큰 차이
                        }
                    }
                     
                }
                 
                if(!isColumnFine) {
                    result++;
                }
                 
            }
             
             
            writer.write(new StringBuilder(16).append('#').append(testCase).append(' ').append(result).append('\n').toString());
        }
        writer.flush();
        writer.close();
    }
}