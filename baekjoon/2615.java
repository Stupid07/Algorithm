import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static final int MAX = 19;
	static int win;
	static int row, column;
	static int[][] map = new int[MAX+1][MAX+1];
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 1; i <= MAX; i++) {
			String line = reader.readLine();
			for(int j = 0; j < MAX; j++) {
				map[i][j+1] = line.charAt(j*2) - '0';
			}
		}
		
		int preRowValue, preRowCount, preColumnValue, preColumnCount;
		int leftUpDiagonalValue, leftUpDiagonalCount, leftDownDiagonalValue, leftDownDiagonalCount;
		int rightUpDiagonalValue, rightUpDiagonalCount, rightDownDiagonalValue, rightDownDiagonalCount;
		for(int i = 1; i <= MAX; i++) {
			preRowValue = preColumnValue = 0;
			preRowCount = preColumnCount = 0;
			
			int j;
			for(j = 1; j <= MAX; j++) {
				if(map[i][j] == preRowValue) {
					preRowCount++;
				}else {
					if(preRowCount == 5 && preRowValue != 0) {
						break;
					}else {
						preRowValue = map[i][j];
						preRowCount = 1;
					}
				}
			}
			
			if(preRowCount == 5 && preRowValue != 0) {
				win = preRowValue;
				row = i;
				column = j-5;
				break;
			}
			
			for(j = 1; j <= MAX; j++) {
				if(map[j][i] == preColumnValue) {
					preColumnCount++;
				}else {
					if(preColumnCount == 5 && preColumnValue != 0) {
						break;
					}else {
						preColumnValue = map[j][i];
						preColumnCount = 1;
					}
				}
			}
			
			if(preColumnCount == 5 && preColumnValue != 0) {
				win = preColumnValue;
				row = j-5;
				column = i;
				break;
			}
			
			leftUpDiagonalValue = leftUpDiagonalCount = 0;
			leftDownDiagonalValue = leftDownDiagonalCount = 0;
			int preIndex = 1;
			for(j = i; j <= MAX; j++, preIndex++) {
				if(map[preIndex][j] == leftUpDiagonalValue) {
					leftUpDiagonalCount++;
				}else {
					if(leftUpDiagonalCount == 5 && leftUpDiagonalValue != 0) {
						break;
					}else {
						leftUpDiagonalValue = map[preIndex][j];
						leftUpDiagonalCount = 1;
					}
				}
				
				if(map[j][preIndex] == leftDownDiagonalValue) {
					leftDownDiagonalCount++;
				}else {
					if(leftDownDiagonalCount == 5 && leftDownDiagonalValue != 0) {
						break;
					}else {
						leftDownDiagonalValue = map[j][preIndex];
						leftDownDiagonalCount = 1;
					}
				}
			}
			
			if(leftUpDiagonalCount == 5 && leftUpDiagonalValue != 0) {
				win = leftUpDiagonalValue;
				row = preIndex -5;
				column = j-5;
				break;
			}else if(leftDownDiagonalCount == 5 && leftDownDiagonalValue != 0) {
				win = leftDownDiagonalValue;
				row = j - 5;
				column = preIndex - 5;
				break;
			}
			
			
			
			rightUpDiagonalValue = rightUpDiagonalCount = 0;
			rightDownDiagonalValue = rightDownDiagonalCount = 0;
			preIndex = 1;
			for(j = i; j >= 1; j--, preIndex++) {
				if(map[j][preIndex] == rightUpDiagonalValue) {
					rightUpDiagonalCount++;
				}else {
					if(rightUpDiagonalCount == 5 && rightUpDiagonalValue != 0) {
						break;
					}else {
						rightUpDiagonalValue = map[j][preIndex];
						rightUpDiagonalCount = 1;
					}
				}
				
				
				if(map[MAX-preIndex+1][MAX-j+1] == rightDownDiagonalValue) {
					rightDownDiagonalCount++;
				}else {
					if(rightDownDiagonalCount == 5 && rightDownDiagonalValue != 0) {
						break;
					}else {
						rightDownDiagonalValue = map[MAX-preIndex+1][MAX-j+1];
						rightDownDiagonalCount = 1;
					}
				}
			}
			
			if(rightUpDiagonalCount == 5 && rightUpDiagonalValue != 0) {
				win = rightUpDiagonalValue;
				row = j + 5;
				column = preIndex -5;
				break;
			}else if(rightDownDiagonalCount == 5 && rightDownDiagonalValue != 0) {
				win = rightDownDiagonalValue;
				row = MAX -preIndex + 1 + 5;
				column = MAX -j +1 - 5;
				break;
			}
			
		}
		
		System.out.println(win);
		if(win != 0)
			System.out.println(String.format("%d %d", row, column));
	}
}