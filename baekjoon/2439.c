#include <stdio.h>
int main(void)
{
	int num =0,i=1,j=0;
	for(scanf("%d",&num);i<=num;i++)
	{
		for(j=num;j;j--)
			printf("%c",j-i>0?' ':'*');
		printf("\n");
	}
	return 0;
}