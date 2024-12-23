#include <iostream>
#include <vector>
#include <random>

using namespace std;

int findLeft(const vector<int> &arr, int num)
{
    int l = 0, r = arr.size() - 1, m = 0;

    int ans = -1;
    while (l <= r)
    {
        m = l + ((r - l) >> 1); // 使用位运算来计算中点，这在C++中是有效的
        if (arr[m] >= num)
        {
            ans = m; // 更新答案并继续在左半部分查找
            r = m - 1;
        }
        else
        {
            l = m + 1; // 在右半部分查找
        }
    }
    return ans; // 返回最左边的索引或-1（如果未找到）
}

/**
 * 对数器
 */
int right(const vector<int>& arr, int num) {
    for (size_t i = 0; i < arr.size(); i++) {
        if (arr[i] >= num) {
            return i;
        }
    }
    return -1; // 如果没有找到满足条件的元素，则返回-1
}

/**
 * 生成 随机数组
 */
vector<int> randomArray(int n, int v)
{
    vector<int> arr(n);
    random_device rd;                     // 用于获取随机数种子
    mt19937 gen(rd());                    // 以rd()作为种子的Mersenne Twister伪随机数生成器
    uniform_int_distribution<> dis(1, v); // [1, v]范围内的均匀分布

    for (int i = 0; i < n; ++i)
    {
        arr[i] = dis(gen); // 生成随机数并赋值给arr[i]
    }

    return arr;
}

int main()
{

    srand(time(0)); // 初始化随机数生成器

    int N = 100;
    int V = 1000;
    int testTime = 500000;
    cout << "测试开始" << endl;
    for (int i = 0; i < testTime; ++i)
    {
        int n = rand() % N + 1; // 生成1到N之间的随机数（包含N）
        vector<int> arr = randomArray(n, V);
        sort(arr.begin(), arr.end()); // 对数组进行排序
        int num = rand() % V + 1;     // 生成1到V之间的随机数（包含V，但逻辑上通常不包含V的边界值，这里保持与Java一致）

        if (right(arr, num) != findLeft(arr, num))
        {
            cout << "出错了!" << endl;
            // 可以选择在这里退出程序或者记录错误
            // return 1; // 如果要退出程序，可以使用这个语句（但需要先包含<cstdlib>并返回非零值）
        }
    }

    cout << "测试结束" << endl;
    return 0;
}