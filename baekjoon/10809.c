#include <stdio.h>
int main(void){
	char one,string[101]={'\0'};
	int i=0,alpha[26];
	for(;i<26;i++)
	alpha[i]=-1;
	
	fgets(string,101,stdin);
	
	for(i=0,one=string[i];one!='\0'&&one!='\n';one=string[++i])
		if(alpha[one-97]==-1)alpha[one-97]=i;
	
	for(i=0;i<26;i++)
	printf("%d ",alpha[i]);
	return 0;
}