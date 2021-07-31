package arraysSortingSearchingMaths;
import java.util.*;
public class FindDuplicateNumber {
	private  class SortArray{
		public  int[] mergeSort(int []arr,int start,int end)
		{
			if(start==end)
			{
				int []base=new int[1];
				base[0]=arr[start];
				return base;
			}
			int mid=start+(end-start)/2;
			int []firstHalf=mergeSort(arr,start,mid);
			int []secondHalf=mergeSort(arr,mid+1,end);
			int []merged=merge2SortedArray(firstHalf,secondHalf,firstHalf.length,secondHalf.length);
			return merged;
		}

		private int[] merge2SortedArray(int[] arr1, int[] arr2, int n, int m) {
			int []merged=new int[m+n];
			int i=0,j=0,k=0;
			while(i<n && j<m)
			{
				if(arr1[i]<=arr2[j])
				{
					merged[k]=arr1[i];
					i++;k++;
				}
				else if(arr2[j]<arr1[i])
				{
					 merged[k]=arr2[j];
					 j++;k++;
				}
				else
				{
					merged[k]=arr1[i];
					i++;j++;k++;
				}
			}
			while(i<n)
			{
				merged[k]=arr1[i];
				i++;k++;
			}
			while(j<m)
			{
				merged[k]=arr2[j];
				j++;k++;
			}
			return merged;
		}
	}
	SortArray a=new SortArray();
	public void bruteForce(int []arr) // O(n^2)
	{
		if(arr.length==0)
		{
			return;
		}
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					System.out.println(arr[i]);
				}
			}
		}
	}
	public void betterApproach(int []arr)//O(nlogn) 
	{
		if(arr.length==0)
		{
			return;
		}
		a.mergeSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length-1;i++)
		{
			if(arr[i]==arr[i+1])
			{
				System.out.println(arr[i]);
				return;
			}
		}
	}
	public void evenBetter(int []arr)//O(n) O(n)
	{
		Set<Integer> set=new HashSet<Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(set.contains(arr[i]))
			{
				System.out.println(arr[i]);
				return;
			}
			else
			{
				set.add(arr[i]);
			}
		}
	}
	public void optimalApproach(int []arr)//O(n) O(1)
	{
		if(arr.length==0)
		{
			return;
		}
		int slow=arr[0];
		int fast=arr[0];
		
		do {
			slow=arr[slow];
			fast=arr[arr[fast]];
		}while(slow!=fast);
		
		fast=arr[0];
		while(fast!=slow)
		{
			fast=arr[fast];
			slow=arr[slow];
		}
		System.out.println(slow);
	}

	public static void main(String[] args) {
		FindDuplicateNumber a=new FindDuplicateNumber();
		int []arr= {1,3,4,2,2};
	//	a.bruteForce(arr);
	//	a.betterApproach(arr);
	//	a.evenBetter(arr);
		a.optimalApproach(arr);

	}

}
