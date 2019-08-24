#include <stdio.h>
int main(void){
	char string[21]={'\0'};
	int i=0,j,k,T,R;
	
	for(scanf("%d",&T);i<T;i++)
	{
		scanf("%d %s",&R,string);
		for(j=0;string[j]!='\0'&&string[j]!='\n';j++)
			for(k=0;k<R;k++)
				printf("%c",string[j]);
		
		printf("\n");
	}
	
	return 0;
}