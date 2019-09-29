import java.util.LinkedList;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int keySize = key.length, lockSize = lock.length;
        LinkedList<int[]> keyResult;
        LinkedList<int[]> lockResult = searchStart(lock,0);
        if(lockResult.size() == 0) {
        	return true;
        }
        
        int[] lockBios = lockResult.poll();
        int lockCount = lockResult.size();
        int[] keyBios;
        int count;
        int[] nextKey;
        int keyX,keyY;
        int[][] rotation = key;
        
        for(int k = 0 ; k < 4; k++) {            
            count = 0;
            keyResult = search(rotation,1);
            if(keyResult.size() == 0) {
            	break;
            }
            
            for(int i = 0, len = keyResult.size(); i< len; i++) {
	            keyBios = keyResult.get(i);
	            count = 0;
	            
	            for(int[] keySet : keyResult) {
	            	keyX = lockBios[0]+keySet[0]-keyBios[0];
	            	keyY = lockBios[1]+keySet[1]-keyBios[1];
	            	if(isIndex(keyX, keyY, lockSize)) {
	            		if(lock[keyX][keyY] == 0) {
	            			count++;
	            		}else {
	            			count = -1;
	            			break;
	            		}
	            	}
	            }
	            
	            
	            if(count == lockCount) {
	            	answer = true;
	            	break;
	            }
            }
            rotation = rotationArray(rotation);
        }
        
        return answer;
    }
	
	public int[][] rotationArray(int[][] array){
		int arraySize = array.length;
		int[][] rotation = new int[arraySize][arraySize];
        for(int i = 0 ; i < arraySize; i++) {
        	for(int j = 0; j< arraySize; j++) {
        		rotation[i][j] = array[arraySize-1-j][i];
        	}
        }
        return rotation;
	}
	
	public boolean isIndex(int x, int y, int max) {
		if(0 <= x && x < max && 0 <= y && y < max){
			return true;
		}
		return false;
	}
	
	
	public LinkedList<int[]> search(int[][] array, int correct){
		LinkedList<int[]> list = new LinkedList<>();
		for(int i = 0; i < array.length; i++) {
        	for(int j = 0; j < array[0].length; j++) {
        		if(array[i][j] == correct) {
        			list.offer(new int[] {i, j});
        			
        		}
        	}
        }
		return list;
	}
	
	public LinkedList<int[]> searchStart(int[][] array, int correct) {
		boolean isStart = true;
		int startX  = 0, startY = 0;
		LinkedList<int[]> list = new LinkedList<>();
		for(int i = 0; i < array.length; i++) {
        	for(int j = 0; j < array[0].length; j++) {
        		if(array[i][j] == correct) {
        			if(isStart) {
        				list.offer(new int[] {i,j});
        				startX = i;
        				startY = j;
        				isStart = false;
        			}
        			list.offer(new int[] {i-startX, j-startY});
        			
        		}
        	}
        }
		return list;
	}
}