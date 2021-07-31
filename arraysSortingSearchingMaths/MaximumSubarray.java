package arraysSortingSearchingMaths;
import java.util.*;
public class MaximumSubarray {
	public void bruteForce(int []arr)
	{
		if(arr.length==0) return;
		int max=0,sum=0;
		for(int i=0;i<arr.length;i++)
		{
			for(int j=i;j<arr.length;j++)
			{ 
				sum=0;
				for(int k=i;k<=j;k++)
				{
					sum+=arr[k];
				}
				max=Math.max(max, sum);
			}
		}
		System.out.println(max);
	}
	public void betterApproach(int []arr,int n)
	{
		if(arr.length==0) return;
		int max=0;
		for(int i=0;i<n;i++)
		{
			int sum=0;
			for(int j=i;j<n;j++)
			{
				sum+=arr[j];
				max=Math.max(max, sum);
			}
		}
		System.out.println(max);
	}
	public void optimalApproach(int []arr,int n)
	{
		if(arr.length==0) return;
		int sum=0,max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			sum+=arr[i];
			max=Math.max(max, sum);
			sum=sum<0?0:sum;
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		MaximumSubarray a=new MaximumSubarray();
		int []arr= {-2,1,-3,4,-1,2,1,-5,4};
	//	a.bruteForce(arr);
	//	a.betterApproach(arr, arr.length);
		a.optimalApproach(arr, arr.length);

	}

}
