#include <stdio.h>

int main(void) {
	int l, p, participant, person, i;
    
	scanf("%d %d",&l, &p);
	participant = l*p;
    
	for(i = 0; i < 5; i++){
		scanf(" %d", &person);
		printf("%d ", person-participant);
	}
	
	return 0;
}