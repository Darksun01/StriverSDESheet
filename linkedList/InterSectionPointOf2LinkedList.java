package linkedList;
import java.util.*;
public class InterSectionPointOf2LinkedList {
	private class Node{
		int data;
		Node next;
		public Node(int data)
		{
			this.data=data;
			next=null;
		}
	}
	private  Node head=null;
	private  Node tail=null;
	public void addTolast(int data)
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
	public void display(Node curr ) {
		while(curr!=null)
		{
			System.out.print(curr.next+" ");
			curr=curr.next;
		}
		System.out.println();
	}
	public Node bruteForce(Node head1,Node head2)
	{
		Node temp=head2;
		while(head1!=null)
		{
			temp=head2;
			while(temp!=null)
			{
				if(head1==temp)
				{
				//	System.out.println(head1.data);
					return head1;
				}
				temp=temp.next;
			}
			head1=head1.next;
		}
		return null;
	}
	
	public Node betterApproach(Node head1,Node head2)
	{
		HashSet<Node> set=new HashSet<Node>();
		while(head1!=null)
		{
			set.add(head1);
			head1=head1.next;
		}
		while(head2!=null)
		{
			if(set.contains(head2))
			{
				return head2;
			}
			set.add(head2);
			head2=head2.next;
		}
		return null;
	}
	
	public Node optimalApproach(Node head1,Node head2)
	{
		if(head1==null || head2==null) return null;
		Node a=head1,b=head2;
		while(a!=b)
		{
			a=a==null?head2:a.next;
			b=b==null?head1:b.next;
		}
		return a;
	}

	public static void main(String[] args) {
		InterSectionPointOf2LinkedList list1=new InterSectionPointOf2LinkedList();
		InterSectionPointOf2LinkedList list2=new InterSectionPointOf2LinkedList();
		InterSectionPointOf2LinkedList list3=new InterSectionPointOf2LinkedList();
		list1.addTolast(1);
		list1.addTolast(2);

		list2.addTolast(2);
		list2.addTolast(8);
		list2.addTolast(1);
		list2.addTolast(3);
		
		list3.addTolast(8);
		list3.addTolast(7);
		list3.addTolast(6);
		list1.tail.next=list3.head;
		list2.tail.next=list3.head;
		
//		Node ans=list1.bruteForce(list1.head, list2.head);
//		Node ans=list1.betterApproach(list1.head, list2.head);
		Node ans=list1.optimalApproach(list1.head, list2.head);
		System.out.println(ans.data);

	}

}
