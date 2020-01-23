#include <stdio.h>
int main(void) {
	char one,string[16];
	int i=0,time=0,hashing[26]={3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
	
	for(fgets(string,16,stdin),one=string[i];one!='\0'&&one!='\n';one=string[++i])
		time+=hashing[one-65];
	printf("%d",time);
	
	return 0;
}
