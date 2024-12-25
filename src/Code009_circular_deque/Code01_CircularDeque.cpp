#include <deque>
using namespace std;

class MyCircularDeque
{
private:
    deque<int> queue;
    int size;
    int limit;

public:
    MyCircularDeque(int k) : size(0), limit(k) {}

    bool insertFront(int value)
    {
        if (isFull())
            return false;
        queue.push_front(value);
        size++;
        return true;
    }

    bool insertLast(int value)
    {
        if (isFull())
            return false;
        queue.push_back(value);
        size++;
        return true;
    }

    bool deleteFront()
    {
        if (isEmpty())
            return false;
        queue.pop_front();
        size--;
        return true;
    }

    bool deleteLast()
    {
        if (isEmpty())
            return false;
        queue.pop_back();
        size--;
        return true;
    }

    int getFront()
    {
        if (isEmpty())
            return -1;
        else
            return queue.front();
    }

    int getRear()
    {
        if (isEmpty())
            return -1;
        else
            return queue.back();
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

class MyCircularDeque2
{
private:
    int *q;
    int front, rear, size, limit;

public:
    MyCircularDeque2(int k)
    {
        q = new int[k];
        front = rear = size = 0;
        limit = k;
    }

    bool insertFront(int value)
    {
        if (isFull())
        {
            return false;
        }
        else
        {
            if (isEmpty())
            {
                front = rear = 0;
                q[0] = value;
            }
            else
            {
                front = front == 0 ? (limit - 1) : (front - 1);
                q[front] = value;
            }
            size++;
            return true;
        }
    }

    bool insertLast(int value)
    {
        if (isFull())
        {
            return false;
        }
        else
        {
            if (isEmpty())
            {
                front = rear = 0;
                q[0] = value;
            }
            else
            {
                rear = rear == limit - 1 ? 0 : (rear + 1);
                q[rear] = value;
            }
            size++;
            return true;
        }
    }

    bool deleteFront()
    {
        if (isEmpty())
            return false;
        else
        {
            size--;
            front = (front == limit - 1) ? 0 : (front + 1);

            return true;
        }
    }

    bool deleteLast()
    {
        if (isEmpty())
            return false;
        else
        {
            size--;
            rear = rear == 0 ? (limit - 1) : (rear - 1);
            return true;
        }
    }

    int getFront()
    {
        if (isEmpty())
            return -1;
        else
            return q[front];
    }

    int getRear()
    {
        if (isEmpty())
            return -1;
        else
            return q[rear];
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
