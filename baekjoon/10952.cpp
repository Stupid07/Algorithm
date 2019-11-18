#include <iostream>
using namespace std;
int main() {
	int A,B;
	while(true)
	{
		cin>>A>>B;
		if(A||B) cout<<A+B<<endl;
		else break;
	}
	return 0;
}