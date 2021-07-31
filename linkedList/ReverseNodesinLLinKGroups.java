package linkedList;
import java.util.*;
public class ReverseNodesinLLinKGroups {
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
	
	public void reverseKGroups(Node head,int k)
	{
		if(head==null || head.next==null) return;
		int length=0;
		Node head1=head;
		while(head1.next!=null)
		{
			length++;
			head1=head1.next;
		}
		Node dummy=new Node(0);
		dummy.next=head;
		Node prev=dummy,curr=dummy,ahead=dummy;
		while(length>=k)
		{
			curr=prev.next;
			ahead=curr.next;
			for(int i=1;i<k;i++)
			{
				curr.next=ahead.next;
				ahead.next=prev.next;
				prev.next=ahead;
				ahead=curr.next;
			}
			prev=curr;
			length-=k;
		}
		display(dummy.next);
	}

	private void display(Node curr) {
		while(curr!=null)
		{
			System.out.print(curr.data+" ");
			curr=curr.next;
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		ReverseNodesinLLinKGroups a=new ReverseNodesinLLinKGroups();
		a.addToLast(1);
		a.addToLast(2);
		a.addToLast(3);
		a.addToLast(4);
		a.addToLast(5);
		a.addToLast(6);
		a.addToLast(7);
		a.addToLast(8);
		a.reverseKGroups(a.head, 3);
		
	}

}
