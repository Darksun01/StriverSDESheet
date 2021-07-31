package arraysSortingSearchingMaths;
import java.util.*;
public class BuyAndSellStocks {
	public void bruteForce(int []arr,int n)
	{
		int profit=0;
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				if(arr[i]<arr[j])
				{
					int profit1=arr[j]-arr[i];
					profit=Math.max(profit, profit1);
				}
			}
		}
		System.out.println(profit);
	}
	public void optimalApproach(int []arr,int n)
	{
		int min=Integer.MAX_VALUE,profit=0;
		for(int i=0;i<n;i++)
		{
			if(arr[i]<min)
			{
				min=arr[i];
			}
			else
			{
				int profit1=arr[i]-min;
				profit=Math.max(profit, profit1);
			}
		}
		System.out.println(profit);
	}

	public static void main(String[] args) {
		BuyAndSellStocks a=new BuyAndSellStocks();
		int []arr= {7,1,5,3,6,4};
		a.bruteForce(arr, arr.length);
		a.optimalApproach(arr, arr.length);

	}

}
