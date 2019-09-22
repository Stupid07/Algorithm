#include <stdio.h>
int main(void) {
	int N;
	scanf("%d",&N);
	printf("%d",(N == (N & (~N + 1))) ? 1 : 0);
	return 0;
}