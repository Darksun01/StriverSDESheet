package linkedList;
import java.util.*;
public class AddTwoNumbersgivenAsTheLinkedList {
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
	public void onlyApproach(AddTwoNumbersgivenAsTheLinkedList list1,AddTwoNumbersgivenAsTheLinkedList list2)
	{
		Node l1=list1.head,l2=list2.head;
		int carry=0,sum=0;
		Node dummy=new Node(0);
		Node temp=dummy;
		while(l1!=null || l2!=null || carry==1)
		{
			sum=0;
			if(l1!=null)
			{
				sum+=l1.data;
				l1=l1.next;
			}
			if(l2!=null)
			{
				sum+=l2.data;
				l2=l2.next;
			}
			sum+=carry;
			carry= sum/10;
			Node newNode=new Node(sum%10);
			temp.next=newNode;
			temp=temp.next;
		}
		display(dummy.next);
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
	
	public static void main(String[] args) {
		AddTwoNumbersgivenAsTheLinkedList list1=new AddTwoNumbersgivenAsTheLinkedList();
		AddTwoNumbersgivenAsTheLinkedList list2=new AddTwoNumbersgivenAsTheLinkedList();
		list1.addToLast(2);
		list1.addToLast(4);
		list1.addToLast(3);
		list2.addToLast(5);
		list2.addToLast(6);
		list2.addToLast(7);
		list2.addToLast(9);
		AddTwoNumbersgivenAsTheLinkedList a=new AddTwoNumbersgivenAsTheLinkedList();
		a.onlyApproach(list1, list2);

	}

}
