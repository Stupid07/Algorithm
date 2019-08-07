#include <stdio.h>
int f[2][41]={{1,0},{0,1}};
void fib(int n){
	int i=2;
	if(!(f[0][n]+f[1][n])){
		for(; i<= n; i++){
			f[0][i]=f[0][i-1] + f[0][i-2];
			f[1][i]=f[1][i-1] + f[1][i-2];
		}
	}
}

int main(void){
	int t,n;
	for(scanf("%d",&t);t;t--){
		scanf("%d",&n);
		fib(n);
		printf("%d %d\n",f[0][n],f[1][n]);
	}
	return 0;
}