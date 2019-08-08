import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	private static final int MAX_INPUT = 36;
	private static boolean[][] map = new boolean[6][6]; 
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = reader.readLine();
		int[] prePos = new int[2];
		int[] startPos = changePos(line.charAt(0), line.charAt(1));
		boolean check = true;
		prePos[0] = startPos[0];
		prePos[1] = startPos[1];
		map[startPos[0]][startPos[1]] = true;
		for(int i = 1; i < MAX_INPUT; i++) {
			line = reader.readLine();
			int[] nextPos = changePos(line.charAt(0), line.charAt(1));
			if(isMove(prePos, nextPos) && !map[nextPos[0]][nextPos[1]]) {
				map[nextPos[0]][nextPos[1]] = true;
				prePos = nextPos;
			}else {
				check = false;
				break;
			}
		}
		
		if(check && isMove(prePos, startPos)) {
			System.out.println("Valid");
		}else {
			System.out.println("Invalid");
		}
	}
	
	private static boolean isMove(int[] prePos, int[] nextPos) {
		int diffX = Math.abs(prePos[0] - nextPos[0]);
		int diffY = Math.abs(prePos[1] - nextPos[1]);
		if((diffX == 2 && diffY == 1) || (diffX == 1 && diffY == 2)) {
			return true;
		}
		return false;
	}
	
	private static int[] changePos(char y, char x) {
		int[] pos = new int[2];
		pos[0] = 6 - (x - '0');
		pos[1] = y - 'A';
		return pos;
	}
	
}
