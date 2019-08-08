#include <iostream>
using namespace std;
int main() {
	int x,y,day=0;
	char *week[7]={"MON","TUE","WED","THU","FRI","SAT","SUN"};
	int plus[13]={0,3,0,3,2,3,2,3,3,2,3,2,3};
	cin>>x>>y;
	
	for(int i = 1; i < x; i++)
	day+=plus[i];
	
	day+=(y-1);
	day%=7;
	
	cout <<week[day];

	return 0;
}