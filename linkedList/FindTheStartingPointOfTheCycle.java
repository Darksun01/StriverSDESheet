package linkedList;
import java.util.*;
public class FindTheStartingPointOfTheCycle {
	private class Node{
		int data;
		Node next;
		public Node(int data)
		{
			this.data=data;
			next=null;
		}
	}
	private Node head=null;
	private Node tail=null;
	
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
	
	public Node bruteForce(Node head)
	{
		if(head==null || head.next==null) return null;
		Set<Node> set=new HashSet<Node>();
		while(head!=null)
		{
			if(set.contains(head))
			{
				return head;
			}
			set.add(head);
			head=head.next;
		}
		return null;
	}
	public Node optimalApproach(Node head)
	{
		if(head==null || head.next==null) return null;
		Node fast=head,slow=head;
		while(fast.next!=null && fast.next.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
			if(fast==slow)
			{
				fast=head;
				while(fast!=slow)
				{
					fast=fast.next;
					slow=slow.next;
				}
				return fast;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		FindTheStartingPointOfTheCycle a=new FindTheStartingPointOfTheCycle();
		a.addToLast(1);
		a.addToLast(2);
		a.addToLast(3);
		a.addToLast(4);
		a.addToLast(5);
		a.addToLast(6);
		a.addToLast(7);
		a.tail.next=a.head.next.next.next;
		Node ans=a.bruteForce(a.head);
		Node res=a.optimalApproach(a.head);
		if(ans!=null)
		{
			System.out.println(ans.data);
		}
		else
		{
			System.out.println("NUll");
		}

	}

}
