# 最小栈
> 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
> 
>实现 MinStack 类:
>
>MinStack() 初始化栈对象。
>
>void push(int val) 将元素val推入堆栈。
>
>void pop() 删除栈顶部的元素。
>
>int top() 获取栈顶部的元素。
>
>int getMin() 获取栈中的最小元素。

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