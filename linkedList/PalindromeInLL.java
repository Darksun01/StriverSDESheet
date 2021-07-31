package linkedList;
import java.util.*;
public class PalindromeInLL {
	private class Node{
		int data;
		Node next;
		public Node(int data)
		{
			this.data=data;
			next=null;
		}
	}
	public Node head=null;
	public Node tail=null;
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
	public boolean bruteforce(Node head)
	{
		if(head==null) return true;
		ArrayList<Integer> list=new ArrayList<Integer>();
		while(head!=null)
		{
			list.add(head.data);
			head=head.next;
		}
		int size=list.size();
		int start=list.get(0);
		int end=list.get(size-1);
		while(start<=end)
		{
			if(start!=end)
			{
				return false;
			}
			start++;end--;
		}
		return true;
	}
	public boolean optimalApproach(Node head)
	{
		if(head==null || head.next==null) return true;
		Node fast=head,slow=head;
		while(fast.next!=null && fast.next.next!=null)
		{
			fast=fast.next.next;
			slow=slow.next;
		}
		slow.next=reverseLL(slow.next);
		slow=slow.next;
		while(slow!=null)
		{
			if(head.data!=slow.data)
			{
				return false;
			}
			head=head.next;
			slow=slow.next;
		}
		return true;
	}

	private Node reverseLL(Node curr) {
		Node prev=null;
		while(curr!=null)
		{
			Node ahead=curr.next;
			curr.next=prev;
			prev=curr;
			curr=ahead;
		}
		return prev;
	}
	public static void main(String[] args) {
		PalindromeInLL list=new PalindromeInLL();
		list.addToLast(1);
		list.addToLast(0);
		list.addToLast(0);
//		list.addToLast(3);
//		list.addToLast(2);
//		list.addToLast(1);
		System.out.println(list.bruteforce(list.head));
//		System.out.println(list.optimalApproach(list.head));
	}

}
