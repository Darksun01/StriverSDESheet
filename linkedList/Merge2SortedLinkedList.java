package linkedList;
import java.util.*;
public class Merge2SortedLinkedList {
	private class Node
	{
		int data;
		Node next;
		public Node(int data)
		{
			this.data=data;
			next=null;
		}
	}
	private  Node head=null;private  Node tail=null;
	public void addToLast(int data)
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
	public void display(Node current)
	{
		while(current!=null)
		{
			System.out.print(current.data+" ");
			current=current.next;
		}
	}
	//O(n1 +n2) O(n) 
	public void bruteForce(Merge2SortedLinkedList list1,Merge2SortedLinkedList list2)
	{
		Node first=list1.head;
		Node second=list2.head;
		Merge2SortedLinkedList res=new Merge2SortedLinkedList();
		while(first!=null && second!=null)
		{
			if(first.data<second.data)
			{
				res.addToLast(first.data);
				first=first.next;
			}
			else
			{
				res.addToLast(second.data);
				second=second.next;
			}
		}
		while(first!=null)
		{
			res.addToLast(first.data);
			first=first.next;
		}
		while(second!=null)
		{
			res.addToLast(second.data);
			second=second.next;
		}
		display(res.head);
	}
	
	public void optimalApproach(Merge2SortedLinkedList list1,Merge2SortedLinkedList list2)
	{
		if(list1==null)
		{
			display(list2.head);
		}
		if(list2==null)
		{
			display(list2.head);
		}
		Node l1=list1.head,l2=list2.head;
		if(l1.data>l2.data)
		{
			Node temp=l1;
			l1=l2;
			l2=temp;
		}
		Node res=l1;
		while(l1!=null && l2!=null)
		{
			Node temp=null;
			while(l1!=null && l1.data<=l2.data)
			{
				temp=l1;
				l1=l1.next;
			}
			temp.next=l2;
			 Node t=l1;
			 l1=l2;
			 l2=t;
		}
		display(res);
	}

	public static void main(String[] args) {
		Merge2SortedLinkedList list1=new Merge2SortedLinkedList();
		Merge2SortedLinkedList list2=new Merge2SortedLinkedList();
		list1.addToLast(5);
		list1.addToLast(7);
		list1.addToLast(9);
		list2.addToLast(3);
		list2.addToLast(4);
		list2.addToLast(8);
		list2.addToLast(10);
		Merge2SortedLinkedList a=new Merge2SortedLinkedList();
//		a.bruteForce(list1, list2);
		a.optimalApproach(list1, list2);

	}

}
