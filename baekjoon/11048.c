#include <stdio.h>
#define MAX(x,y) (((x)>(y))?(x):(y))

int main(void) {
	int N,M,i,j,m[2][1000]={0};
	scanf("%d %d",&N,&M);
	for(i=0;i<N;i++){
		for(j=0;j<M;j++){
			scanf("%d ",&m[i&1][j]);
			if(i==0){
				if(j>0) m[i&1][j]+=m[i&1][j-1];
			}else{
				if(j==0){
					m[i&1][j]+=m[(i-1)&1][j];
				}else {
					m[i&1][j]+=MAX(m[i&1][j-1],m[(i-1)&1][j]);
				}
			}
		}
	}
	printf("%d",m[(N-1)&1][M-1]);
	return 0;
}