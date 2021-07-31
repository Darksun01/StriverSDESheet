package stacksandQueues;
import java.util.*;
public class ImplementMinStackInO1Space {
	Stack<Integer> st=new Stack<Integer>();
	int min;
	public void push(int x)
	{
		if(st.size()==0)
		{
			st.push(x);
			min=x;
		}
		else
		{
			if(x>=min)
			{
				st.push(x);
			}
			else
			{
				st.push(2*x-min);
				min=x;
			}
		}
	}
	
	public void pop()
	{
		if(st.size()==0)
		{
			System.out.println("Stack Underflow");
			return;
		}
		if(st.peek() >= min)
		{
			st.pop();
		}
		else
		{
			min=2*min-st.peek();
			st.pop();
		}
	}
	
	public void top()
	{
		if(st.size()==0)
		{
			System.out.println("Stack Underflow");
			return;
		}
		if(st.peek()>=min)
		{
			System.out.println(st.peek());
		}
		else
		{
			System.out.println(min);
		}
	}
	public void size()
	{
		System.out.println(st.size());
	}
	public void getMin()
	{
		System.out.println(min);
	}
	public static void main(String[] args) {
		ImplementMinStackInO1Space a=new ImplementMinStackInO1Space();
		a.push(5);
		a.push(6);
		a.push(10);
		a.push(4);
		a.push(8);
		a.pop();
		a.pop();
		a.getMin();
	}

}
