#include <iostream>
#include<algorithm>
using namespace std;

int main() {
	int num;
	int aliquot[50];
	cin >>num;
	
	for(int i = 0; i < num; i++)
	cin>>aliquot[i];
	
	sort(aliquot,aliquot+num);
	
	if(num % 2 == 0)
	cout<<(aliquot[0]*aliquot[num-1]);
	else
	cout<<(aliquot[num/2]*aliquot[num/2]);
	return 0;
}