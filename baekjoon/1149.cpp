#include <cstdio>
#include <iostream>
#include <algorithm>

int main(void) {
	int i, n, rgb[1000][3];

	scanf("%d", &n);
	for (i = 0; i < n; i++)
	{
		scanf("%d %d %d", &(rgb[i][0]), &(rgb[i][1]), &(rgb[i][2]));
		if (i != 0)
		{
			rgb[i][0] = rgb[i][0] + std::min(rgb[i - 1][1], rgb[i - 1][2]);
			rgb[i][1] = rgb[i][1] + std::min(rgb[i - 1][0], rgb[i - 1][2]);
			rgb[i][2] = rgb[i][2] + std::min(rgb[i - 1][0], rgb[i - 1][1]);
		}
	}
	printf("%d", std::min(rgb[n - 1][0], std::min(rgb[n - 1][1], rgb[n - 1][2])));
	return 0;
}