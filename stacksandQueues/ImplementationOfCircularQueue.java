package stacksandQueues;
import java.util.*;
public class ImplementationOfCircularQueue {
	static int []arr;
	static int default_capacity=10;
	int ms;
	int cs;
	int front;
	int rear;;
	
	ImplementationOfCircularQueue()
	{
		arr=new int[default_capacity];
	}
	ImplementationOfCircularQueue(int capacity)
	{
		arr=new int[capacity];
		ms=capacity;
		cs=0;
		front=0;
		rear=capacity-1;
	}
	public boolean isFull()
	{
		return cs==ms;
	}
	public boolean isEmpty()
	{
		return (cs==0);
	}
	public void enque(int num)
	{
		if(!isFull())
		{
			rear=(rear+1)%ms;
			cs=cs+1;
			arr[rear]=num;
		}
	}
	public void dequeue()
	{
		if(!isEmpty())
		{
			front=(front+1)%ms;
			cs=cs-1;
		}
	}
	public int isSize()
	{
		return cs;
	}
	public int getFront()
	{
		return arr[front];
	}
	public static void main(String[] args) {
		ImplementationOfCircularQueue a=new ImplementationOfCircularQueue(6);
		for(int i=1;i<=arr.length;i++)
		{
			a.enque(i);
		}
		System.out.println(a.isSize());
		a.dequeue();
		a.dequeue();
		System.out.println(a.isSize());
		a.enque(8);
		System.out.println(a.isSize());
		while(!a.isEmpty())
		{
		//	System.out.println(a.getFront());
			a.dequeue();
		}
		System.out.println(a.isSize());
	}

}
