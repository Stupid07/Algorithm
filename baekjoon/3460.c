#include <stdio.h>

int main(void) {
	int i, testCase, number, bitCount;
	
	scanf("%d", &testCase);
	for(i = 0 ; i < testCase; i++){
		bitCount = 0;
		scanf(" %d", &number);
		while(number){
			if(number & 1){
				printf("%d ", bitCount);
			}
			bitCount++;
			number>>=1;
		}
		printf("\n");
	}
    
	return 0;
}