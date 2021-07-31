package arraysSortingSearchingMaths;
import java.util.*;
public class SortAnArrayOf012 {
	public void bruteForce(int []arr)
	{
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public void betterApproach(int []arr)
	{
		int count0=0,count1=0,count2=0;
		for(int i=0;i<arr.length;i++)
		{
			switch(arr[i])
			{
			case 0:
				count0++;break;
			case 1:
				count1++;break;
			case 2:
				count2++;break; 
			}
		}
		int i=0;
		while(count0-->0)
		{
			arr[i]=0;i++;
		}
		while(count1-->0)
		{
			arr[i]=1;i++;
		}
		while(count2-->0)
		{
			arr[i]=2;i++;
		}
		for(int j=0;j<arr.length;j++)
		{
			System.out.print(arr[j]+" ");
		}
		System.out.println();
	}
	public void optimalApproach(int []arr) {
		if(arr.length==0) return;
		int low=0,mid=0,high=arr.length-1;
		while(mid<=high)
		{
			switch(arr[mid])
			{
			case 0:
				swap(arr,low,mid);low++;mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(arr,mid,high);high--;
				break;
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

	private void swap(int[] arr, int start, int end) {
		int temp=arr[start];
		arr[start]=arr[end];
		arr[end]=temp;
		
	}
	public static void main(String[] args) {
		SortAnArrayOf012 a=new SortAnArrayOf012();
		int []arr= {0,1,1,0,1,2,1,2,0,0,0,1};
		a.bruteForce(arr);
		a.betterApproach(arr);
		a.optimalApproach(arr);
	}

}
