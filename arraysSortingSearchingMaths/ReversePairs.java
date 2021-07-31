package arraysSortingSearchingMaths;
import java.util.*;
public class ReversePairs {
	public int bruteForce(int []arr)
	{
		int count=0;
		int n=arr.length;
		for(int i=0;i<n;i++)
		{
			for(int j=i+1;j<n;j++)
			{
				if(arr[i]>2*(double)arr[j])
				{
					count++;
				}
			}
		}
		return count;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public int optimalApproach(int []arr)
	{
		return mergeSort(arr,0,arr.length-1);
	}

	private int mergeSort(int[] arr, int left, int right) {
		if(left>=right) return 0;
		int mid=left+(right-left)/2;
		int countInv=mergeSort(arr,left,mid);
		countInv+=mergeSort(arr,mid+1,right);
		countInv+=merge(arr,left,mid,right);
		return countInv;
	}
	private int merge(int[] arr, int left, int mid, int right) {
		int count=0;
		int j=mid+1;
		for(int i=left;i<=mid;i++)
		{
			while(j<=right && arr[i]>(2*(double)arr[j]))
			{
				j++;
			}
			count+=(j-(mid+1));
		}
		int low=left,high=mid+1;
		ArrayList<Integer> list=new ArrayList<Integer>();
		while(low<=mid && high<=right)
		{
			if(arr[low]<=arr[high])
			{
				list.add(arr[low++]);
			}
			else
			{
				list.add(arr[high++]);
			}
		}
		while(low<=mid)
		{
			list.add(arr[low++]);
		}
		while(high<=right)
		{
			list.add(arr[high++]);
		}
		for(int i=left;i<=right;i++)
		{
			arr[i]=list.get(i-left);
		}
		return count;
	}
	public static void main(String[] args) {
		ReversePairs a=new ReversePairs();
		int []arr= {1,3,2,3,1};
		System.out.println(a.bruteForce(arr));
		System.out.println(a.optimalApproach(arr));

	}

}
