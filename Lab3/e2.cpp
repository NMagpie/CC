#include <iostream>
#include <ctime>
#include <cstdlib>

int main() {
	
	int n=0;
	
	scanf("%d",&n);
	
	bool *c = new bool[n];
	
	for (int i=0;i<n;i++) {
		c[i]=true;
	}
	
	clock_t begin = clock();
	
	c[1]=false;
	int i=2,j=0,count =0;
	
	while (i<=n){
		j=2*i;
		while (j<=n){
			c[j]=false;
			j=j+i;
			count++;
		}
		i++;
	}
	
	clock_t end = clock();
	double time_spent = (double)(end - begin) / (CLOCKS_PER_SEC/1000);
	
	printf("Time: %.6lf\n",time_spent);
	
	printf("count: %d\n",count);
	
	system("pause");
	
	/*for (int i=2;i<n;i++) {
		if (c[i]) printf("%d ",i);
	} */
	
	return 0;
}
