#include <iostream>
using namespace std;

//穷举法
int findmax(int a[], int length)
{
	int maxlen = 0;
	for (int i = 0; i < length; i++) {
		int sum = a[i];
		if (sum == 0) {
			maxlen = 1;
		}
		for (int j = i + 1; j < length; j++) {
			sum += a[j];
			if (sum == 0 && maxlen < j - i + 1) {
				maxlen = j - i + 1;
			}
		}
	}
	return maxlen;
}

int main()
{
	int a[12] = {1,1,1,1,1,1,-3,1,1,1,1,-4};
	cout << findmax(a, 12) << endl;
	return 0;
} 
