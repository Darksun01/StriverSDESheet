package linkedList;
import java.util.*;
public class MiddleOfTheLinkedList {
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
		while(head!=null)
		{
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
	}
	public void bruteForce(Node head)
	{
		Node temp=head;
		int length=0;
		while(temp!=null)
		{
			length++;
			temp=temp.next;
		}
		length=length/2;
		for(int i=0;i<length;i++)
		{
			head=head.next;
		}
		System.out.println(head.data);
	}
	public void optimal(Node head)
	{
		Node slow=head,fast=head;
		while(fast!=null && fast.next!=null)
		{
			fast=fast.next.next;
			slow=slow.next;
		}
		System.out.println(slow.data);
	}

	public static void main(String[] args) {
		MiddleOfTheLinkedList a=new MiddleOfTheLinkedList();
		for(int i=1;i<=6;i++)
		{
			a.add(i*10);
		}
		a.display(head);
//		a.bruteForce(head);
		a.optimal(head);
		
	}

}
