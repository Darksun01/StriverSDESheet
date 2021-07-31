package stacksandQueues;
import java.util.*;
public class ImplementationOfCircularQueueUsingLL {
	LinkedList<Integer> queue;
	ImplementationOfCircularQueueUsingLL()
	{
		 queue=new LinkedList<Integer>();
	}
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	public void enqueue(int n)
	{
		queue.addLast(n);
	}
	public void dequeue()
	{
		queue.removeFirst();
	}
	public void getFront()
	{
		System.out.println(queue.getFirst());
	}

	public static void main(String[] args) {
		ImplementationOfCircularQueueUsingLL a=new ImplementationOfCircularQueueUsingLL();
		for(int i=1;i<=6;i++)
		{
			a.enqueue(i);
		}
		a.dequeue();
		a.dequeue();
		a.enqueue(8);
		while(!a.isEmpty())
		{
			a.getFront();
			a.dequeue();
		}

	}

}
