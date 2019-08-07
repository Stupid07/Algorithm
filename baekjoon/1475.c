#include <stdio.h>
int main(void) {
	int i=0,num[9]={0},max=0;
	char string[8]={'\0',};
	fgets(string,8,stdin);
	for(;string[i]!='\0';i++)
		num[string[i]<57?string[i]-48:6]++;
	num[6]=(num[6]>>1)+(num[6]&1);
	for(i=0;i<9;i++)
		if(max<num[i])max=num[i];
	printf("%d",max);
	return 0;
}