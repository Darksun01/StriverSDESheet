package arraysSortingSearchingMaths;
import java.util.*;
public class SearchIn2DMatrixLeetcode {
	public boolean bruteForce(int [][]arr,int target)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<arr[0].length;j++)
			{
				if(arr[i][j]==target)
				{
					return true;
				}
			}
		}
		return false;
	}
	public boolean betterApproach(int [][]arr,int target)// since every row is sorted we will use binary search to reduce time complexity
	{
		int i=0,j=arr.length-1;
		while(i<arr.length && j>=0)
		{
			if(arr[i][j]==target)
			{
				return true;
			}
			else if(arr[i][j]>target)
			{
				j--;
			}
			else
			{
				i++;
			}
		}
		return false;
	}
	public boolean optimalApproach(int [][]arr,int target)
	{
		int n=arr.length,m=arr[0].length;
		int l=0,r=(n*m)-1;
		while(l<=r)
		{
			int mid=l+(r-l)/2;
			if(arr[mid/m][mid%m]==target)
			{
				return true;
			}
			else if(arr[mid/m][mid%m]>target)
			{
				r=mid-1;
			}
			else
			{
				l=mid+1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SearchIn2DMatrixLeetcode a=new SearchIn2DMatrixLeetcode();
		int [][]arr={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target=13;
		System.out.println(a.bruteForce(arr, target)+" "+a.betterApproach(arr, target)+" "+a.optimalApproach(arr, target));
//		System.out.println(a.bruteForce(arr, target));
		

	}

}
