import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        boolean[][] map = new boolean[N][N];
        String line;

        for(int i = 0 ; i < N; i++){
            line = reader.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = line.charAt(j) == '1';
            }
        }
        
        StringBuilder result = makeQuadTree(map, 0, 0, N, new StringBuilder());

        System.out.println(result.toString());
    }
    
    public static int[][] quadrant = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};

    public static StringBuilder makeQuadTree(boolean[][] map, int startX, int startY, int size, StringBuilder quadTree){
        int midSize = size>>1;
        int nextX, nextY;
        
        if(isUnited(map, startX, startY, size)){
            return quadTree.append(map[startX][startY] ? '1' : '0');
        }

        quadTree.append('(');
        for(int i = 0; i < quadrant.length; i++){
            nextX = startX + quadrant[i][0]*midSize;
            nextY = startY + quadrant[i][1]*midSize;
            if(isUnited(map, nextX, nextY, midSize)) {
                quadTree.append(map[nextX][nextY] ? '1' : '0');
            }else{
                makeQuadTree(map, nextX, nextY, midSize, quadTree);
            }
        }
        quadTree.append(')');
        
        return quadTree;
    }

    public static boolean isUnited(boolean[][] map, int startX, int startY, int size){
        boolean standard = map[startX][startY];
        
        for(int i = startX, maxX = startX+size; i < maxX; i++){
            for(int j = startY, maxY = startY+size; j < maxY; j++){
                if(standard != map[i][j]){
                    return false;
                }
            }
        }

        return true;
    }
}