#include <stdio.h>
int main(void)
{
	int num=0,i=0;
	for(scanf("%d",&num);num;num--)
	{
		for(i=num;i;i--)
			printf("*");
		printf("\n");
	}
	return 0;
}