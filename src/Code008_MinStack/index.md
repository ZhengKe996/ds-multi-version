# 最小栈
```java
class MinStack2 {
    public final int MAXN = 8001;
    public int data[];
    public int min[];
    public int size;

    public MinStack2() {
        data = new int[MAXN];
        min = new int[MAXN];
        size = 0;
    }

    public void push(int val) {
        data[size] = val;
        if (size == 0 || val <= min[size - 1])
            min[size] = val;
        else
            min[size] = min[size - 1];
        size++;
    }

    public void pop() {
        size--;
    }

    public int top() {
        return data[size-1];
    }

    public int getMin() {
        return min[size-1];
    }
}
```