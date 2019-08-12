#include <stdio.h>
#define SIZE 9
#define ANSWER 7

int t[SIZE],k[SIZE];
int find(int p,int c,int sum){
	if(c== ANSWER){
		if(sum == 100) return 1;
		else return 0;
	}else if((SIZE - p + c) >= ANSWER){
		k[p]++;
		if(find(p+1,c+1,sum+t[p])){
			return 1;
		}else{
			k[p]--;
			return find(p+1,c,sum);
		}
	}else{
		return 0;
	}
}

void insertionsort(int n[],int m){
	int i,t,j;
	for(i=1;i<m;i++){
		t=n[i];
		for(j=i;j>0;j--){
			if(n[j-1]>t) n[j]=n[j-1];
			else break;
		}
		n[j]=t;
	}
}

int main(void) {
	int i;
	for(i=0;i<SIZE;i++){
		scanf("%d",&t[i]);
	}
	
	insertionsort(t,SIZE);
	find(0,0,0);
	for(i=0;i<SIZE;i++){
		if(k[i]) printf("%d\n",t[i]);
	}
	return 0;
}