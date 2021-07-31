package linkedList;
import java.util.*;
public class ReverseALinkedList {
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
	private static int size=0;
	public void addLast(int data)
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
		size++;
	}
	public void remove(int index)
	{
		if(size==0)
		{
			System.out.println("LL is empty");
			return;
		}
		if(size==1)
		{
			head=null;
			tail=null;
			size--;
		}
		else
		{
			Node prev=head;
			for(int i=0;i<index-1;i++)
			{
				prev=prev.next;
			}
			Node temp=prev.next;
			int rv=temp.data;
			Node next=temp.next;
			prev.next=next;
			System.out.println();
			size--;
		}
	}
	public void linkedListReverse(Node head)
	{
		Node prev=null;
		while(head!=null)
        {
            Node ahead=head.next;
            head.next=prev;
            prev=head;
            head=ahead;
        }
        display(prev);
//    
//		while(prev!=null)
//		{
//			System.out.print(prev.data+" ");
//			prev=prev.next;
//		}
//		System.out.println();
//		
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

	public static void main(String[] args) {
		ReverseALinkedList a=new ReverseALinkedList();
		for(int i=1;i<=6;i++)
		{
			a.addLast(i*10);
		}
		a.display(head);
		//System.out.println(head.data);
		a.linkedListReverse(head);
	//	a.display(head);
	}

}
