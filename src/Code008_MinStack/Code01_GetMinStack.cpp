#include <stack>

using namespace std;

class MinStack1
{
private:
    stack<int> data, min;

public:
    MinStack1()
    {
    }

    void push(int val)
    {
        data.push(val);
        if (min.empty() || val <= min.top())
            min.push(val);
        else
            min.push(min.top());
    }

    void pop()
    {
        data.pop();
        min.pop();
    }

    int top()
    {
        return data.top();
    }

    int getMin()
    {
        return min.top();
    }
};

class MinStack
{
private:
    static const int MAXN = 8001;
    int data[MAXN];
    int min[MAXN];
    int size;

public:
    MinStack()
    {
    }

    void push(int val)
    {
        data[size] = val;
        if (size == 0 || val <= min[size - 1])
            min[size] = val;
        else
            min[size] = min[size - 1];
        size++;
    }

    void pop()
    {
        size--;
    }

    int top()
    {
        return data[size - 1];
    }

    int getMin()
    {
        return min[size - 1];
    }
};
