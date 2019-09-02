#include <stdio.h>

int main(void) {
	const int MAX = 9;
	int i,j,number, maxNumber = 0, row, column;
	for(i = 0; i < MAX; i++){
		for(j = 0; j < MAX; j++){
			scanf(" %d",&number);
			if(number > maxNumber){
				maxNumber = number;
				row = i;
				column = j;
			}
		}
	}
	
	printf("%d\n%d %d\n", maxNumber, row+1, column+1);
	return 0;
}