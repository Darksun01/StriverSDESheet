package linkedList;
//import java.util.*;

//import linkedList.CloneLinkedListwithRandomPointers.Node;
public class CloneALinkedListWithRandomPointers {
	private class Node{
		int data;
		Node next,random;
		public Node(int data)
		{
			this.data=data;
			next=null;
			random=null;
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
	void print(Node head)
	{
		Node curr=head;
		while(curr!=null)
		{
			System.out.print("Data="+curr.data+" "+"Random="+curr.random.data+" ");
			curr=curr.next;
		}
		System.out.println();
	}
	public Node clone(Node head)
	{
		Node curr=head;
		while(curr!=null)
		{
			Node temp=new Node(curr.data);
			temp.next=curr.next;
			curr.next=temp;
			curr=curr.next.next;
		}
		curr=head;
		
		while(curr!=null) {
			if(curr.random==null)
			{
				curr.next.random=null;
			}
			else
			{
				curr.next.random=curr.random.next;
			}
			curr=curr.next.next;
		}
		Node original=head;
		Node copy=head.next;
		while(original.next!=null)
		{
			Node temp=original.next;
			original.next=original.next.next;
			original=temp;
		}
		return copy;
	}

	public static void main(String[] args) {
		CloneALinkedListWithRandomPointers list=new CloneALinkedListWithRandomPointers();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		head.random=head.next.next;
		head.next.random=head;
		head.next.next.random=head.next.next.next.next;
		head.next.next.next.random=head.next.next.next;
		head.next.next.next.next.random=head.next;
		System.out.println("Original List:");
		list.print(head);
		Node headCopy=list.clone(head);
		list.print(headCopy);

	}

}
