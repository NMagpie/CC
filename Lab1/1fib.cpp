#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

//every function works n<=46;

void fone(int n) {
	
	int f1=1, f2=1,temp=0;
	
	for (int i=0;i<n;i++) {
		cout << f1 << " ";
		
		temp=f2;
		f2+=f1;
		f1=temp;
	}
	
	return;
}

vector<int> v;

int ftwobase(int n) {
	
	if (n==1) { v[1]=1; return 1; }
	if (n==0) { v[0]=1; return 1; }
	
	v[n]=ftwobase(n-1)+ftwobase(n-2);
	return v[n];
	}
	
 void ftwo(int n){
	
	v.resize(n);
	
	ftwobase(n);
	
	for (int i=0;i<n;i++) { cout<< v[i] << " "; }
	
	return;
}

void fthree(int n) {
	
	int fn=0;
	const float phi=1.6180339887498948482;
	
	for (int i=1;i<n+1;i++) {
	fn=round((pow(phi,i)-(pow(-phi,-i)))/(2*phi-1));//round(pow(phi,i)/sqrt(5));
	cout << fn << " ";
	}

	return;
}

void ffour(int n) {
	
	return;
}

int main() {
	
	int n;
	
	cout<<"Write the n:";
	
	cin >> n;
	
	fthree(n);
	
	return 0;
}
