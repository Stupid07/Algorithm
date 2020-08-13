import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean [][] map = new boolean[51][51];
        ArrayList<int[]> cabbagePosition = new ArrayList<>(2500);

        int maxTestCase = Integer.parseInt(reader.readLine());
        for(int testCase = 0; testCase < maxTestCase; testCase++){
            String[] inputList = reader.readLine().split(" ");
            int columnCount = Integer.parseInt(inputList[0]);
            int rowCount = Integer.parseInt(inputList[1]);
            int cabbageCount = Integer.parseInt(inputList[2]);
            int earthwormCount = 0;

            for(int i = 0; i < cabbageCount; i++){
                String[] numberList = reader.readLine().split(" ");
                int column = Integer.parseInt(numberList[0]);
                int row = Integer.parseInt(numberList[1]);
                map[column][row] = true;
                cabbagePosition.add(new int[]{column, row});
            }

            int[] currentPosition;
            for(int i = 0; i < cabbageCount; i++){
                currentPosition = cabbagePosition.get(i);
                if(map[currentPosition[0]][currentPosition[1]]){
                    earthwormCount++;
                    clearCabbage(map, currentPosition[0], currentPosition[1], columnCount, rowCount);
                }
            }
            
            writer.write(String.format("%d\n",earthwormCount));
            clearMap(map, columnCount, rowCount);
            cabbagePosition.clear();
        }
        writer.flush();
        writer.close();
    }

    public static boolean isIndex(int column, int row, int columnCount, int rowCount){
        if(0 <= column && column < columnCount
        && 0 <= row && row < rowCount){
            return true;
        }
        return false;
    }

    public static final int[][] position = {{0,1},{1,0},{0,-1},{-1,0}};

    public static void clearCabbage(boolean[][] map, int column, int row, int columnCount, int rowCount){
        int currentColumn, currentRow;
        map[column][row] = false;
        for(int i = 0; i < position.length; i++){
            currentColumn = column + position[i][0];
            currentRow = row + position[i][1];
            if(isIndex(currentColumn, currentRow, columnCount, rowCount) && map[currentColumn][currentRow]){
                clearCabbage(map, currentColumn, currentRow, columnCount, rowCount);
            }
        }
    }
    
    public static void clearMap(boolean[][] map, int columnCount, int rowCount){
        for(int i = 0; i < columnCount; i++){
            for(int j = 0; j < rowCount; j++){
                map[i][j] = false;
            }
        }
    }
}