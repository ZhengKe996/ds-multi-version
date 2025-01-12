#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>

using namespace std;

const int MAXN = 100001;
vector<int> arr(MAXN);
int n;


void swap(int x, int y) {
    int tmp = arr[x];
    arr[x] = arr[y];
    arr[y] = tmp;
}

int partition(int l, int r, int x) {
    int a = l, xi = 0; // xi 用于存放<=x区域上任何一个x的位置

    for (int i = l; i <= r; i++) {
        if (arr[i] <= x) {
            swap(arr[a], arr[i]);
            if (arr[a] == x) xi = a;
            a++;
        }
    }
    swap(arr[xi], arr[a - 1]);
    return a - 1;
}

int first, last;

void partition2(int l, int r, int x) {
    first = l;
    last = r;
    int i = l;

    while (i <= last) {
        if (arr[i] == x) i++;
        else if (arr[i] < x) swap(first++, i++);
        else swap(i, last--);
    }
}

void quicksort(int l, int r) {
    if (l >= r) return;

    int x = arr[l + rand() % (r - l + 1)]; // 枢轴元素

    int mid = partition(l, r, x);
    quicksort(l, mid - 1);
    quicksort(mid + 1, r);
}



void quickSort2(int l, int r) {
    if (l >= r) return;
    int x = arr[l + rand() % (r - l + 1)]; // 枢轴元素
    partition2(l, r, x);

    int left = first, right = last;
    quickSort2(l, left - 1);
    quickSort2(right + 1, r);
}



int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    // solution
    quickSort2(0, n - 1);
    for (int i = 0; i < n - 1; i++) cout << arr[i] << " ";
    cout << arr[n - 1] << endl;
    return 0;
}