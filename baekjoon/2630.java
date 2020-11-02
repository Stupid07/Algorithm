import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        boolean[][] map = new boolean[n][n];
        String line;
        
        for(int i = 0; i < n; i++){
            line = reader.readLine();
            for(int j = 0, len = n<<1; j < len; j+=2){
                if(line.charAt(j) == '1'){
                    map[i][j>>1] = true;
                }
            }
        }

        int[] result = paperCount(0,n, 0, n, map);
        
        System.out.println(String.format("%d\n%d",result[0],result[1]));
    }

    public static int[] paperCount(int startX, int endX, int startY, int endY, boolean[][] map){
        final int QUADRANT_MAX = 4;
        int midX = (startX + endX)>>1;
        int midY = (startY + endY)>>1;
        int[] counts = new int[2], subCounts;
        boolean[] isSameQuadrants = new boolean[QUADRANT_MAX];
        int[][] positions = new int[QUADRANT_MAX][QUADRANT_MAX];
        
        if(startX == endX && startY == endY){
            counts[toIndexForColor(map[startX][startY])]++;
            return counts;
        }

        positions[0][0] = positions[2][0] = startX;
        positions[1][1] = positions[3][1] = endX;
        positions[0][1] = positions[1][0] = positions[2][1] = positions[3][0] = midX;
        positions[0][2] = positions[1][2] = startY;
        positions[2][3] = positions[3][3] = endY;
        positions[0][3] = positions[1][3] = positions[2][2] = positions[3][2] = midY;

        for(int i = 0; i < QUADRANT_MAX; i++){
            isSameQuadrants[i] = isSameColor(positions[i][0], positions[i][1], positions[i][2], positions[i][3], map);
            if(isSameQuadrants[i]){
                counts[toIndexForColor(map[positions[i][0]][positions[i][2]])]++;
            }else{
                subCounts = paperCount(positions[i][0], positions[i][1], positions[i][2], positions[i][3], map);
                counts[0] += subCounts[0];
                counts[1] += subCounts[1];
            }
        }

        if(isSameQuadrants[0] && isSameQuadrants[1] && isSameQuadrants[2] && isSameQuadrants[3] && (counts[0] == 4 || counts[1] == 4)){
            counts[toIndexForColor(map[positions[0][0]][positions[0][2]])]-=3;
        }

        return counts;
    }

    public static int toIndexForColor(boolean color){
        if(color){
            return 1;
        }
        return 0;
    }

    public static boolean isSameColor(int startX, int endX, int startY, int endY, boolean[][] map){
        boolean compareValue = map[startX][startY];
        for(int i = startX; i < endX; i++){
            for(int j = startY; j < endY; j++){
                if(map[i][j] != compareValue){
                    return false;
                }
            }
        }

        return true;
    }
}
