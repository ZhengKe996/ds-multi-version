#include <iostream>
#include <vector>
using namespace std;
// 测试链接 : https://leetcode.cn/problems/design-circular-queue/

class MyCircularQueue
{
public:
    vector<int> queue;

    int front, rear, size, limit;
    MyCircularQueue(int k)
    {
        queue.resize(k);
        front = rear = size = 0;
        limit = k;
    }

    bool enQueue(int value)
    {
        if (isFull())
            return false;
        queue[rear] = value;
        rear = rear == limit - 1 ? 0 : (rear + 1);
        size++;
        return true;
    }

    bool deQueue()
    {
        if (isEmpty())
            return false;
        front = front == limit - 1 ? 0 : (front + 1);
        size--;
        return true;
    }

    int Front()
    {
        if (isEmpty())
            return -1;
        return queue[front];
    }

    int Rear()
    {
        if (isEmpty())
            return -1;
        int last = rear == 0 ? (limit - 1) : (rear - 1);
        return queue[last];
    }

    bool isEmpty()
    {
        return size == 0;
    }

    bool isFull()
    {
        return size == limit;
    }
};
