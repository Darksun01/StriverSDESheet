package arraysSortingSearchingMaths;
import java.util.*;
public class MajorityElelment {
	public void bruteForce(int []arr)
	{
		int count=0;
		int max=Integer.MIN_VALUE;
		int maxElement=0;
		for(int i=0;i<arr.length;i++)
		{
			count=0;
			for(int j=0;j<arr.length;j++)
			{
				if(arr[i]==arr[j])
				{
					count++;
				}
			}
			if(max<count)
			{
				max=count;
				maxElement=arr[i];
			}
		}
		System.out.println(maxElement);
	}
	public void betterApproach(int []nums)
	{
		  Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	        int min=Integer.MIN_VALUE;
	        for(int i=0;i<nums.length;i++)
	        {
	            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
	        }
	        int key=0;
	        for(Map.Entry<Integer,Integer> entry:map.entrySet())
	        {
	            if(entry.getValue()>min)
	            {
	                min=entry.getValue();
	                key=entry.getKey();
	            }
	        }
	        System.out.println(key);
	}
	public void optimalApproach(int []arr)//Moores Voting Algo
	{
		if(arr.length==0) return;
		int element=0;
		int count=0;
		for(int i=0;i<arr.length;i++)
		{
			if(count==0)
			{
				element=arr[i];
			}
			if(arr[i]==element)
			{
				count++;
			}
			else
			{
				count--;
			}
		}
		System.out.println(element);
	}

	public static void main(String[] args) {
		MajorityElelment a=new MajorityElelment();
		int []arr= {3,2,3};
		a.bruteForce(arr);
		a.betterApproach(arr);
		a.optimalApproach(arr);

	}

}
