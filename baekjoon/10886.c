#include <stdio.h>

int main(void) {
	int n,i,isCute, count = 0;
	scanf(" %d",&n);
	for(i=0; i< n; i++){
		scanf(" %d", &isCute);
		count += isCute;
	}
	printf("Junhee %s cute!", (n>>1)<count?"is":"is not");
	return 0;
}