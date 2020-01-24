#include <cstdio>
int main(){
	char string[10]={'\0'};
	int z,i,t,num[10001]={0};
	for(i=1;i<=10000;i++)
	{
		sprintf(string,"%d",i);
		for(t=0,z=i;string[t]!='\0';t++)
			z+=(string[t]-'0');
		if(z<=10000)
		num[z]++;
		if(num[i]==0)
		printf("%d\n",i);
	}
	return 0;
}