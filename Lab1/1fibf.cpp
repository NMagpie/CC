#include <iostream>
#include <cmath>
#include <chrono>
#include <iomanip>

using namespace std;
using namespace std::chrono;


//every function works n<=92;

long long fone(int n) {
	
	auto start = high_resolution_clock::now();

	
	long long f1=1, f2=1,temp=0;
	for (int i=0;i<n-1;i++) {			
		temp=f2;
		f2+=f1;
		f1=temp;
	}
	
	auto finish = high_resolution_clock::now();
	double time = duration_cast<nanoseconds>(finish - start).count();
	time *= 1e-9;
	cout << "Time:" << fixed << setprecision(10) << time << endl;
	
	return f1;
}

long long ftwobase(int n) {
	
	if (n==1) { return 1; }
	if (n==0) { return 0; }

	return ftwobase(n-1)+ftwobase(n-2);
	}
	
long long ftwo(int n) {
	
	auto start = high_resolution_clock::now();
	
	long long n1 = ftwobase(n);
	
	auto finish = high_resolution_clock::now();
	double time = duration_cast<nanoseconds>(finish - start).count();
	time *= 1e-9;
	cout << "Time:" << fixed << setprecision(10) << time << endl;
	
	return n1;
}

long long fthree(int n) {
	auto start = high_resolution_clock::now();
	
	long long fn=0;
	const float phi=1.6180339887498948482045868343656381177203091798057628621354486227052604628189024497072072041893911374;
	
	fn=round((pow(phi,n)-(pow(-phi,-n)))/(2*phi-1));

	auto finish = high_resolution_clock::now();
	double time = duration_cast<nanoseconds>(finish - start).count();
	time *= 1e-9;
	cout << "Time:" << fixed << setprecision(10) << time << endl;

	return fn;	
}

long long ffour(int n) {
	
	auto start = high_resolution_clock::now();

	long long a[4],b[4],bt[4];
	a[0]=a[1]=a[2]=1; a[3]=0;
	b[0]=b[1]=b[2]=1; b[3]=0;
	
	n--;

	for (int i=0;i<n;i++) {

	bt[0]=b[0]*a[0]+b[1]*a[2];
	bt[1]=b[0]*a[1]+b[1]*a[3];
	bt[2]=b[2]*a[0]+b[3]*a[2];
	bt[3]=b[2]*a[1]+b[3]*a[3];
	
	b[0]=bt[0]; b[1]=bt[1]; b[2]=bt[2]; b[3]=bt[3];

	}
	
	auto finish = high_resolution_clock::now();
	double time = duration_cast<nanoseconds>(finish - start).count();
	time *= 1e-9;
	cout << "Time:" << fixed << setprecision(10) << time << endl;

	return b[2];
}

int main() {
	
	
	int n=10000000000;
	
	//cout<<"Enter the n:";
	
	//cin >> n;
	
	cout << fone(n) << endl;
	
	//cout << ftwo(n) << endl;
	
	cout << fthree(n) << endl;
	
	cout << ffour(n) << endl;
	
	return 0;
}
