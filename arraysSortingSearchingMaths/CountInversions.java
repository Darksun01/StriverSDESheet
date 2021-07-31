package arraysSortingSearchingMaths;
import java.util.*;
public class CountInversions {
	public void bruteForce(int []arr,int n)
	{
		int countInv=0;
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				if(arr[i]>arr[j])
				{
					countInv++;
				}
			}
		}
		System.out.println(countInv);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public int optimalApproach(int []arr,int []temp,int left,int right)
	{
		int invCount=0;
		if(right>left)
		{
			int mid=(left+right)/2;
			invCount+=optimalApproach(arr,temp,left,mid);
			invCount+=optimalApproach(arr,temp,mid+1,right);
			invCount+=merge(arr,temp,left,mid+1,right);
		}
		return invCount;
	}

	private int merge(int[] arr, int[] temp, int left, int mid, int right) {
		int i=left,j=mid,k=left;
		int invCount=0;
		while((i<=mid-1) && (j<=right))
		{
			if(arr[i]<=arr[j])
			{
				temp[k++]=arr[i++];
			}
			else
			{
				temp[k++]=arr[j++];
				invCount+=mid-i;
			}
			while(i<=mid-1)
			{
				temp[k++]=arr[i++];
			}
			while(j<=right)
			{
				temp[k++]=arr[j++];
			}
			for(int a=left;a<=right;a++)
			{
				arr[a]=temp[a];
			}
		}
			return invCount;
	}

	public static void main(String[] args) {
		CountInversions a=new CountInversions();
		int []arr= {5,2,6,1};
		a.bruteForce(arr, arr.length);
		int []temp=new int[arr.length];
		int ans=a.optimalApproach(arr, temp, 0, arr.length-1);
		System.out.println(ans);

	}

}
