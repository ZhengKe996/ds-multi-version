#include <iostream>
#include <cstdio>
#include <algorithm>

using namespace std;

const int MAXN = 100001;

int arr[MAXN];
int help[MAXN];
int n;


void merge(int l, int m, int r) {
    int i = l, a = l, b = m + 1;
    while (a <= m && b <= r) help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];

    while (a <= m) help[i++] = arr[a++];
    while (b <= r) help[i++] = arr[b++];

    for (i = l; i <= r; i++) arr[i] = help[i];
}

void mergeSort1(int l, int r) {
    if (l == r) return;
    int m = l + ((r - l) >> 1);
    mergeSort1(l, m);
    mergeSort1(m + 1, r);
    merge(l, m, r);
}


void mergeSort2() {
    for (int l, m, r, step = 1; step < n; step <<= 1) {
        l = 0;
        while (l < n) {
            m = l + step - 1;
            if (m + 1 >= n) break;

            r = min(l + (step << 1) - 1, n - 1);
            merge(l, m, r);
            l = r + 1;
        }
    }
}

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    // 选择其中一个排序方法
    // mergeSort1(0, n - 1);
    mergeSort2();

    for (int i = 0; i < n - 1; i++) {
        cout << arr[i] << " ";
    }
    cout << arr[n - 1] << endl;

    return 0;
}
