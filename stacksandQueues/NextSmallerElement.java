package stacksandQueues;
import java.util.*;
public class NextSmallerElement {
	public void bruteForce(int []arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]>arr[j])
				{
					System.out.println(arr[i]+" --> "+arr[j]);
					break;
				}
				if(j==arr.length-1)
				{
					System.out.println(arr[i]+" --> "+"-1");
				}
			}
		}
		System.out.println(arr[arr.length-1]+" --> "+"-1");
	}
	
	public  void optimalApproach(int []arr)
	{
		Stack<Integer> st=new Stack<Integer>();
		for(int i=arr.length-1;i>=0;i--)
		{
			while(!st.isEmpty() && st.peek()>=arr[i])
			{
				st.pop();
			}
			if(i<arr.length)
			{
				if(!st.isEmpty()) {
				System.out.println(arr[i]+" --> "+st.peek());
				}
				else
				{
					System.out.println(arr[i]+" --> "+"-1");
				}
			}
			st.push(arr[i]);
		}
	}

	public static void main(String[] args) {
		NextSmallerElement a=new NextSmallerElement();
		int []arr= {4,12,5,3,1,2,5,3,1,2,4,6};
	//	a.bruteForce(arr);
		a.optimalApproach(arr);

	}

}
