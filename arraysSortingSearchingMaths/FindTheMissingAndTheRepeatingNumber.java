package arraysSortingSearchingMaths;
import java.util.*;
public class FindTheMissingAndTheRepeatingNumber {
	public void bruteForce(int []arr)
	{
		if(arr.length==0) return;
		
		int missing=-1,dup=-1;
		for(int i=1;i<=arr.length;i++)
		{
			int count=0;
			for(int j=0;j<arr.length;j++)
			{
				if(i==arr[j])
				{
					count++;
				}
			}
			if(count==2)
			{
				dup=i;
			}
			if(count==0)
			{
				missing=i;
			}
		}
		System.out.println(dup+" "+missing);
	}
	public void betterApproach(int []arr)
	{
		Arrays.sort(arr);
		int dup=-1,missing=-1;
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i]==arr[i-1])
			{
				dup=arr[i];
			}
			if(arr[i]>arr[i-1]+1)
			{
				missing=arr[i-1]+1;
			}
		}
		System.out.print(dup+" "+missing);
	}
	public void evenBetter(int []arr)
	{
		int dup=-1,missing=-1;
		int sum1=0,sum2=0;
		Set<Integer> set=new HashSet<Integer>();
		for(int i=0;i<arr.length;i++)
		{
			if(!set.contains(arr[i]))
			{
				set.add(arr[i]);
				sum1+=arr[i];
			}
			else
			{
				dup=arr[i];
			}
			sum2+=i+1;
		}
		missing=sum2-sum1;
		System.out.println(dup+" "+missing);
	}
	public void optimalApproach(int []arr)
	{
		int dup=-1,missing=1;
		for(int i:arr)
		{
			if(arr[Math.abs(i)-1]<0)
			{
				dup=Math.abs(i);
			}
			else
			{
				arr[Math.abs(i)-1]*=-1;
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>0)
			{
				missing=i+1;
			}
		}
		System.out.println(dup+" "+missing);
	}

	public static void main(String[] args) {
		FindTheMissingAndTheRepeatingNumber a=new FindTheMissingAndTheRepeatingNumber();
		int []arr= {1,2,2,4};
	//	a.bruteForce(arr);
	//	a.betterApproach(arr);
	//	a.evenBetter(arr);
		a.optimalApproach(arr);
	}

}
