package linkedList;
import java.util.*;
public class DeleteANodeInO1Time {
	//Only given reference to that node
	private class Node{
		int data;
		Node next;
		public Node(int data)
		{
			this.data=data;
			next=null;
		}
	}
	private static Node head=null;
	private static Node tail=null;
	public void addToLast(int item)
	{
		Node newNode=new Node(item);
		if(head==null)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			tail.next=newNode;
			tail=newNode;
		}
	}
	public void display(Node node)
	{
		while(node!=null)
		{
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}
	public void delete(Node node)
	{
		node.data=node.next.data;
		node.next=node.next.next;
	//	display(node);
	}

	public static void main(String[] args) {
		DeleteANodeInO1Time a=new DeleteANodeInO1Time();
		a.addToLast(1);
		a.addToLast(2);
		a.addToLast(3);
		a.addToLast(4);
		a.addToLast(5);
		a.delete(a.head.next);
		a.display(head);

	}

}
