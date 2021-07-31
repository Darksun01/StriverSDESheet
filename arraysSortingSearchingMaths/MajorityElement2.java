package arraysSortingSearchingMaths;
import java.util.*;
public class MajorityElement2 {
	public List<Integer> bruteForce(int []arr)
	{
		List<Integer> list=new ArrayList<Integer>();
		int count=0;
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
			if(count>(arr.length/3))
			{
				if(!list.contains(arr[i]))
				{
					list.add(arr[i]);
				}
			}
		}
		return list;
	}
	public void BetterApraoch(int []arr)
	{
		int n=arr.length;
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++)
		{
			map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
		}
		for(Map.Entry<Integer, Integer> entry:map.entrySet())
		{
			if(entry.getValue()>n/3)
			{
				System.out.println(entry.getKey());
			}
		}
	}
	public List<Integer> optimalApproach(int []arr)
	{
		int n=arr.length;
		int num1=-1,num2=-1,count1=0,count2=0;
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<n;i++)
		{
			if(arr[i]==num1)
			{
				count1++;
			}
			else if(arr[i]==num2)
			{
				count2++;
			}
			else if(count1==0)
			{
				num1=arr[i];
				count1=1;
			}
			else if(count2==0)
			{
				num2=arr[i];
				count2=1;
			}
			else 
			{
				count1--;count2--;
			}
		}
		count1=0;count2=0;
		for(int i=0;i<n;i++)
		{
			if(arr[i]==num1) count1++;
			else if(arr[i]==num2) count2++;
		}
		if(count1>n/3) list.add(num1);
		if(count2>n/3) list.add(num2);
		
		return list;
	}

	public static void main(String[] args) {
		MajorityElement2 a=new MajorityElement2();
		int []arr= {3,2,3};
		List<Integer> ans=a.bruteForce(arr);
//		for(int i:ans)
//		{
//			System.out.println(i);
//		}
		a.BetterApraoch(arr);

	}

}
