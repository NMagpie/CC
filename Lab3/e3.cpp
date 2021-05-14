#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;

int main() {
	
	int n=0;
	

	scanf("%d",&n);
	
	bool *c = new bool[n];
	
	if (c==NULL) { printf("error"); return 1;
	}
	
	for (int i=0;i<n;i++) {
		c[i]=true;
	}
	
	clock_t begin = clock();
	
	c[1]=false;
	int i=2,j=0;
	
while (i<=n){
  if (c[i]){
  j=i+1;
  while (j<=n){
    if (j % i == 0) {
      c[j] = false;
    }
    j=j+1;
  }
}
 i=i+1;
}

	clock_t end = clock();
	double time_spent = (double)(end - begin) / (CLOCKS_PER_SEC/1000);
	
	printf("Time: %.6lf\n",time_spent);
	
	system("pause");
	
	/*for (int i=2;i<n;i++) {
		if (c[i]) printf("%d ",i);
	} */
	
	return 0;
}
