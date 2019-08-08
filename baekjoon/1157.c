#include <stdio.h>
int main(void){
	int i=0,max=0,count=0;
	int alpha[26]={0,};
	char name[1024]={0,},ca=0;
	while(fgets(name,1024,stdin))
	{
		for(i=0,ca=name[i];ca!='\0'&&ca!='\n';ca=name[++i])
		ca<91?alpha[ca-65]++:alpha[ca-97]++;
	}
	for(i=1;i<26;i++)
	{
	if(alpha[max]<alpha[i]){max=i;count=0;}
	else if(alpha[max]==alpha[i])count++;
	}
	printf("%c",count>0?'?':65+max);
	return 0;
}