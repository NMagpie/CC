#include <iostream>
#include <chrono>
#include <string>

using namespace std;

void pidigit(int n);

int main() {

	double time;
	
	int n[] = {20,100,500,1000,2500,5000};
	
	
	for (int j=0;j<6;j++){
		time =0;
	for (int i=0;i<10;i++) {
		auto start = chrono::steady_clock::now();
		//printf("\n%d\n",pidigit(n));
		
		pidigit(n[j]);
		
		auto end = chrono::steady_clock::now();
		
		time = time + (double)chrono::duration_cast<chrono::nanoseconds>(end - start).count()/1000000;
		
		//cout <<endl<<a<<" ns"<<endl;
		//printf("\n %.3f ms\n",time);
	}
	time /=10.;
	printf("\nFor %d = %.4f ms\n",n[j],time);}

    return 0;
}

void pidigit(int n) {
	//70=19 digits the less - is not precise
	n*=3.53;
	//string s="";
    int r[n + 1];
    int i, k;
    int b, d;
    int c = 0;

    for (i = 0; i < n; i++) {
        r[i] = 2000;
    }

    for (k = n; k > 0; k -= 14) {
        d = 0;

        i = k;
        for (;;) {
            d += r[i] * 10000;
            b = 2 * i - 1;

            r[i] = d % b;
            d /= b;
            i--;
            if (i == 0) break;
            d *= i;
        }
        //s= s+ to_string(c+d/10000);
        //cout <<endl << s << endl;
        //printf("%.4d", c + d / 10000);
        c = d % 10000;
    }
    //return s.length();
}
