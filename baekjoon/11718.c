#include <stdio.h>
int main(void) {
	char n[101]={'\0'};
	while(fgets(n,100,stdin)!=NULL)printf("%s",n);
	return 0;
}
