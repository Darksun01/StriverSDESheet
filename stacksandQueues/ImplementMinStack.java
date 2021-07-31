package stacksandQueues;
import java.util.*;
public class ImplementMinStack {
	Stack<Integer> st1=new Stack<Integer>();
	Stack<Integer> st2=new Stack<Integer>();
	public void push(int n)
	{
		st1.push(n);
		if(st2.size()==0 || n<=st2.peek())
		{
			st2.push(n);
		}
	}
	public void pop()
	{
		if(st1.peek() == st2.peek())
		{
			st1.pop();st2.pop();
		}
		else
		{
			st1.pop();
		}
	}
	public void size()
	{
		System.out.println(st1.size());
	}
	public void minStack()
	{
		if(st2.size()==0)
		{
			System.out.println("stack undeflow");
		}
		System.out.println(st2.peek());
	}

	public static void main(String[] args) {
		ImplementMinStack a=new ImplementMinStack();
		a.push(5);
		a.push(6);
		a.push(3);
		a.push(7);
		a.push(1);
		a.push(2);
		a.pop();
		a.minStack();
	}

}
