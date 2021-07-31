package linkedList;
import java.util.*;
public class RemoveNthNodeFromTheEndofLL {
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
	public void add(int data)
	{
		Node newNode=new Node(data);
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
	public void display(Node head)
	{
		Node curr=head;
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr=curr.next;
		}
		System.out.println();
	}
	public void bruteForce(Node head,int k)
	{
		Node dummy=new Node(0);
		dummy.next=head;
		Node first=head;
		int length=0;
		while(first!=null)
		{
			length++;
			first=first.next;
		}
		length-=k;
		first=dummy;
		while(length-->0)
		{
			first=first.next;
		}
		first.next=first.next.next;
		display(head);
	}
	
	public void optimlaApproach(Node head,int n)
	{
		Node dummy=new Node(0);
		dummy.next=head;
		Node slow=dummy;
		Node fast=dummy;
		for(int i=0;i<=n;i++)
		{
			fast=fast.next;
		}
		while(fast!=null)
		{
			fast=fast.next;
			slow=slow.next;
		}
		slow.next=slow.next.next;
		display(dummy.next);
	}

	public static void main(String[] args) {
		RemoveNthNodeFromTheEndofLL a=new RemoveNthNodeFromTheEndofLL();
		for(int i=1;i<=6;i++)
		{
			a.add(i*10);
		}
		a.display(head);
		a.bruteForce(head, 2);
		a.optimlaApproach(head, 2);

	}

}
