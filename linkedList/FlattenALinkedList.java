package linkedList;
import java.util.*;
public class FlattenALinkedList {
	private class Node{
		int data;
		Node next;
		Node bottom;
		public Node(int data)
		{
			this.data=data;
			next=null;
			bottom=null;
		}
	}
	private Node head=null;
	private Node tail=null;
	private Node down=null;
	int size=0;
	public void addToTail(int item)
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
//		return newNode;
	}
	public void  addToBottom(int data)
	{
		Node newNode=new Node(data);
		if(size==0)
		{
			head=newNode;
			down=newNode;
		}
		else
		{
			down.bottom=newNode;
			down=newNode;
		}
		size++;
	}
	public Node flatten(Node head)
	{
		if(head==null || head.next==null)
		{
			return head;
		}
		head.next=flatten(head.next);
		head=merge2LL(head,head.next);
		return head;
	}

	private Node merge2LL(Node a, Node b) {
		Node dummy=new Node(0);
		Node temp=dummy;
		while(a!=null && b!=null)
		{
			if(a.data<=b.data)
			{
				temp.bottom=a;
				temp=temp.bottom;
				a=a.bottom;
			}
			else
			{
				temp.bottom=b;
				temp=temp.bottom;
				b=b.bottom;
			}
		}
		if(a!=null) temp.bottom=a;
		else
			temp.bottom=b;
		return dummy.bottom;
	}
	public static void main(String[] args) {
//		FlattenALinkedList a=new FlattenALinkedList();
//		Node b=a.addToTail(5);
//		b.bottom=a.addToTail(7);
//		b.bottom.bottom=a.addToTail(8);
//		b.bottom.bottom.bottom.bottom=a.addToTail(30);
//		Node c=a.addToTail(10);
//		Node d=a.addToBottom(data);

	}

}
