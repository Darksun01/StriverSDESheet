package stacksandQueues;
import java.util.*;
public class NextGreaterElement {
	public void bruteForce(int []arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]<arr[j])
				{
					System.out.println(arr[i]+" --> "+arr[j]);
					break;
				}
				if(j==arr.length-1)
				{
					System.out.println(arr[i]+" --> "+"-1");
					break;
				}
			}
		}
		System.out.println(arr[arr.length-1]+" --> "+"-1");
	}
	
	public void optimalApproach(int []arr)
	{
		Stack<Integer> st=new Stack<Integer>();
		for(int i=arr.length-1;i>=0;i--)
		{
			while(!st.isEmpty() && arr[i]>=st.peek())
			{
				st.pop();
			}
			if(i<arr.length)
			{
				if(!st.isEmpty())
				{
					System.out.println(arr[i]+" --> "+st.peek());
				}
				else
				{
					System.out.println(arr[i]+" --> "+"-1");
				}
				st.push(arr[i]);
			}
		}
	}
	// we are using circular array so for ex in the arr given below 6 will not have its NGE as -1 but as 12
	public  void aLittleVariant(int []arr,int n) 
	{
		Stack<Integer> st=new Stack<Integer>();
		for(int i=2*n-1;i>=0;i--)
		{
			while(!st.isEmpty() && arr[i%n]>=st.peek())
			{
				st.pop();
			}
			if(i<n)
			{
				if(!st.isEmpty())
				{
					System.out.println(arr[i]+" --> "+st.peek());
				}
				else
				{
					System.out.println(arr[i]+" --> "+"-1");
				}
			}
			st.push(arr[i%n]);
		}
	}
	
	public void bruteForceVariant(int []arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			boolean flag=false;
			for(int j=i+1;j<=2*arr.length-1;j++)
			{
				if(arr[i]<arr[j%arr.length])
				{
					flag=true;
					System.out.println(arr[i%arr.length]+" --> "+arr[j%arr.length]);
					break;
				}
			}
			if(!flag)
			{
				System.out.println(arr[i]+" --> "+"-1");
			}
		}
	}

	public static void main(String[] args) {
		NextGreaterElement a=new NextGreaterElement();
		int []arr= {4,12,5,3,1,2,5,3,1,2,4,6};
	//	a.bruteForce(arr);
	//	a.optimalApproach(arr);
		a.aLittleVariant(arr, arr.length);
	//	a.bruteForceVariant(arr);
	}

}
