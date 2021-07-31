package stacksandQueues;
import java.util.*;
public class LargestRectangleInAHistogram {
	public  void bruteForce(int []arr,int n)// O(N^2)
	{
		int max=0;
		int rightSmaller=n-1,leftSmaller=0;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]>arr[j])
				{
					rightSmaller=j-1;
					break;
				}
			}
			for(int k=i-1;k>=0;k--)
			{
				if(arr[i]>arr[k])
				{
					leftSmaller=k+1;
					break;
				}
			}
		    max=Math.max(max, (((rightSmaller-leftSmaller)+1)*arr[i]));
		}
		System.out.println(max);
	}
	
	public void betterApproach(int []arr,int n)//O(N) && O(3N)
	{
		Stack<Integer> st=new Stack<Integer>();
		int []leftSmaller=new int[n];
		for(int i=0;i<n;i++)
		{
			while(!st.isEmpty() && arr[st.peek()]>=arr[i])
			{
				st.pop();
			}
			if(i<n)
			{
				if(!st.isEmpty())
				{
					leftSmaller[i]=st.peek()+1;
				}
				else
				{
					leftSmaller[i]=0;
				}
			}
			st.push(i);
		}
		st.clear();
		int []rightSmaller=new int[n];
		for(int i=n-1;i>=0;i--)
		{
			while(!st.isEmpty() && arr[st.peek()]>=arr[i])
			{
				st.pop();
			}
			if(i<n)
			{
				if(!st.isEmpty())
				{
					rightSmaller[i]=st.peek()-1;
				}
				else
				{
					rightSmaller[i]=n-1;
				}
			}
			st.push(i);
		}
		int max=0;
		for(int i=0;i<n;i++)
		{
			max=Math.max(max, ((rightSmaller[i]-leftSmaller[i]+1)*arr[i]));
		}
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		LargestRectangleInAHistogram a=new LargestRectangleInAHistogram();
		int []arr= {2,1,5,6,2,3,1};
//		a.bruteForce(arr, arr.length);
		a.betterApproach(arr, arr.length);
	}

}
