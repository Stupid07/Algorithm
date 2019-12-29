#include <stdio.h>

int main(void) {
	int t,h,w,i,j;
	char f[11][11]={};
	for(scanf("%d",&t);t;t--){
		scanf("%d %d ",&h,&w);
		for(i=0;i<h;i++){
			for(j=0;j<w;j++){
				scanf(" %c",&f[i][j]);
			}
		}
		for(i=0;i<h;i++){
			for(j=w-1;j>=0;j--){
				printf("%c",f[i][j]);
			}
			printf("\n");
		}
	}
	return 0;
}