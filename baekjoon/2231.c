#include <stdio.h>
#include <stdlib.h>
int main(void) {
	char n[8],t[8];
	int len,sum,num,tsum,j,i=0;
	scanf("%c",&n[i]);
	sum = n[i++]-'0';
	while(1){
		scanf("%c",&n[i]);
		if(n[i] != '\0')
			i++;
		else 
			break;
	}
	sum += ((i-1)*9);
	num = atoi(n);
	i=num-sum;
	
	if(i<1)
		i=1;
	for(;i<num;i++){
		tsum= i;
		len = sprintf(t,"%d",i);
		for(j=0;j<len;j++)
			tsum+=t[j]-'0';

		if(num == tsum)
			break;  
	}

	printf("%d",(i<num)? i : 0);

	return 0;
}