#include <iostream>
#include <stack>
using namespace std;

class MyQueue
{
private:
    stack<int> in;
    stack<int> out;
    void In2Out()
    {
        if (out.empty())
        {
            while (!in.empty())
            {
                out.push(in.top());
                in.pop();
            }
        }
    }

public:
    MyQueue()
    {
    }

    void push(int x)
    {
        in.push(x);
        In2Out();
    }

    int pop()
    {
        In2Out();
        int x = out.top();
        out.pop();
        return x;
    }

    int peek()
    {
        In2Out();
        return out.top();
    }

    bool empty()
    {
        return in.empty() && out.empty();
    }
};