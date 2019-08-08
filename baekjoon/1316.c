#include <stdio.h>
#include <string.h>
int main(void){
	char one,string[101]={'\0'};
	int j,N,count=0,size, alpha[26];
	size= sizeof(int)*26;
	for(scanf("%d ",&N);N;N--)
	{
		fgets(string,101,stdin);
		memset(alpha,0,size);
		for(j=0,one=string[j];one!='\0'&&one!='\n';one=string[++j])
		{
			if(alpha[one-97]==0)alpha[one-97]++;
			else if(string[j-1]!=one) break;
		}
		
		if(one =='\0'||one =='\n')
		count++;
	}
	printf("%d",count);
	return 0;
}