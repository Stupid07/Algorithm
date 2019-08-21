#include <stdio.h>

int main(void) {
	int a, b, c, result = 0;
	scanf("%d %d %d", &a, &b, &c);
	if(a==b){
		if(b== c){
			result = 10000 + (a * 1000);
		}else{
			result = 1000 + (a *  100);
		}
	}else if(b == c){
		result = 1000 + (b * 100);
	}else if(a == c){
		result = 1000 + (c * 100);
	}else{
		result = (a > b ? (a > c ? a : c) : (b > c ? b : c)) * 100;
	}
	printf("%d", result);
	return 0;
}