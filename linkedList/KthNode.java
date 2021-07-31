package linkedList;
import java.util.*;

//import linkedList.ImplementationOfLL.Node;

public class KthNode {
	private class Node{
		int data;
		Node next;
		public Node(int data)
		{
			this.data=data;
			next=null;
		}
	}
	private Node head =null;
	private Node tail =null;
	
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
	
	public void display(Node curr)
	{
		while(curr!=null)
		{
			System.out.print(curr.data+"->");
			curr=curr.next;
		}
		System.out.println("null");
	}
	
	public Node mid(Node head)
	{
		Node fast=head,slow=head;
		while(fast.next!=null && fast.next.next!=null)
		{
			slow=slow.next;
			fast=fast.next.next;
		}
		return slow;
	}
	public int size()
	{
		Node head=this.head;
		int count=0;
		while(head!=null)
		{
			head=head.next;
			count++;
		}
		return count;
	}
	
	public Node reverse(Node head)
	{
		if(head==null) return null;
		Node prev=null;
		Node curr=head;
		while(curr!=null)
		{
			Node ahead=curr.next;
			curr.next=prev;
			prev=curr;
			curr=ahead;
		}
		return prev;
	}
	public void solution(Node head)
	{
		if(head==null) return;
		Node curr=head;
		Node mid=mid(curr);
		Node p1=head;
		Node p2=mid.next;
		mid.next=null;
		p2=reverse(p2);
		Node dummy1=p2;
		while(p1!=null && p2!=null)
		{
			int sum=p1.data+p2.data;
			p2.data=sum ; p1.data=sum;
			p1=p1.next;
			p2=p2.next;
		}
		dummy1=reverse(dummy1);
		mid.next=dummy1;
		display(curr);
	}

	public static void main(String[] args) {
		KthNode a=new KthNode();
		a.add(1);
		a.add(2);
		a.add(5);
		a.add(11);
		a.add(13);
		a.add(14);
		System.out.println("Original LL");
		a.display(a.head);
		System.out.println("Output");
		a.solution(a.head);
	//	a.reverse(a.head);
}

}
