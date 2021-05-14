#include <iostream>
#include <iomanip>
#include <cmath>
#include <chrono>

double fac(double num) {
    double result = 1.0;
    for (double i=2.0; i<num; i++)
       result *= i;
    return result;
}

int main() {
    using namespace std;
    double time =0;
    	int n[] = {20,100,500,1000,2500,5000};
	
	
	for (int j=0;j<6;j++){
    time =0;
    for (int i=0;i<10;i++){
    auto start = chrono::steady_clock::now();
    double pi=0.0;
    for (double k = 0.0; k < double(n[j]); k++) {
        pi += (pow(-1.0,k) * fac(6.0 * k) * (13591409.0 + (545140134.0 * k))) 
            / (fac(3.0 * k) * pow(fac(k), 3.0) * pow(640320.0, 3.0 * k + 3.0/2.0));
    }
    pi *= 12.0;
    auto end = chrono::steady_clock::now();
    time = time + (double)chrono::duration_cast<chrono::nanoseconds>(end - start).count()/1000000.;
    //printf("\n %.3f ms\n",(double)chrono::duration_cast<chrono::nanoseconds>(end - start).count()/1000000.);
	}
    //cout << setprecision(20000) << 1.0 / pi << endl;
    //auto end = chrono::steady_clock::now();
    time /=10.;
	printf("\nFor %d = %.4f ms\n",n[j],time);
	}
    return 0;
}
