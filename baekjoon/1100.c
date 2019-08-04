#include <stdio.h>
int main(void){
	char str[9]={'\0'};
	int sum=0,i,j;
	for(i=0;i<8;i++){
		fscanf(stdin,"%s",str);
		for(((i&1)?(j=1):(j=0));j<8;j+=2)
			if(str[j]=='F') sum++;
	}
	printf("%d",sum);
	return 0;
}
