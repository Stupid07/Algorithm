#include <stdio.h>
#include <string.h>
int main(void) {
	int i,j,len;
	char num[11]={'\0'},temp;
	fgets(num,11,stdin);
	len = strlen(num);
	for(i=0;i<len;i++)
		for(j=i;j>0;j--)
			{
				if(num[j-1]<num[j])
				{
						temp = num[j];
						num[j] = num[j-1];
						num[j-1] = temp;
				}else break;
			}
	printf("%s",num);
	return 0;
}