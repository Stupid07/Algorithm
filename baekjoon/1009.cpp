#include <iostream>
using namespace std;

int main() {
	int num;
	int a;
	int b;
	int temp;
	cin >>num;
	for(int i = 0; i < num; i++)
	{
		cin>>a>>b;
		a%=10;
		b -=1;
		switch(a)
		{
		case 0:a = 10; b = 0;break;
		case 2:
		case 3:
		case 7:
		case 8:b %=4;break;
		case 4:
		case 9:b %=2;break;
		default:b = 0; break;
		}
		temp = a;
	
		for(int j =0; j < b; j++)
		a *=temp;
	
		if(a != 10)
		a%=10;
	
		if(i != num-1)
		cout<< a<<endl;
		else
		cout << a;
	}
	return 0;
}