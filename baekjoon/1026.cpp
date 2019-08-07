#include <iostream>
#include<algorithm>
using namespace std;

void qsort(int B[],int v[], int s , int e)
{
	int pivot = v[s];
	int bs = s, be = e;
	while(s<e) {
		while(B[pivot] <= B[v[e]]&&s<e) e--;
		if(s>e) break;
		while(B[pivot] >= B[v[s]]&&s<e) s++;
		if(s>e) break;
		swap(v[s],v[e]);
	}
	swap(v[bs],v[s]);
	if(bs<s)
	qsort(B,v,bs,s-1);
	if(be>e)
	qsort(B,v,s+1,be);
}


int main() {
	int num;
	int A[50];
	int B[50];
	int B_index[50];
	int newA[50];
	int s = 0;
	cin >>num;
	
	for(int i = 0; i < num; i++)
	cin>>A[i];
	
	for(int i = 0; i < num; i++)
	cin>>B[i];
	
	for(int i = 0; i < num; i++)
	B_index[i]= i;
	
	sort(A,A+num);
	
	qsort(B,B_index,0,num-1);
	
	for(int i = 0 ; i <num; i++)
		newA[B_index[i]]=A[num-1-i];
		
	for(int i = 0; i < num; i++)
	 s+=(newA[i]*B[i]);
	 
	 cout <<s;
	
	return 0;
}