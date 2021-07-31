package arraysSortingSearchingMaths;
import java.util.*;
class Item
{
	int value,weight;
	public Item(int value,int weight)
	{
		this.value=value;
		this.weight=weight;
	}
}
//class itemComparator implements Comparator<Item>
//{
//	@Override
//	public int compare(Item a,Item b)
//	{
//		double r1=(double)a.value/(double)a.weight;
//		double r2=(double)b.value/(double)b.weight;
//		if(r1<r2) return 1;
//		if(r1>r2) return -1;
//		else
//			return 0;
//	}
//}
public class FractionalKnapsack {
//	class Item
//	{
//		int value,weight;
//		public Item(int value,int weight)
//		{
//			this.value=value;
//			this.weight=weight;
//		}
//	}
	class itemComparator implements Comparator<Item>
	{
		@Override
		public int compare(Item a,Item b)
		{
			double r1=(double)a.value/(double)a.weight;
			double r2=(double)b.value/(double)b.weight;
			if(r1<r2) return 1;
			if(r1>r2) return -1;
			else
				return 0;
		}
	}
	public double fractionalKnapsack(int W,Item []arr,int n)
	{
		Arrays.sort(arr,new itemComparator());
		int currWeight=0;
		double finalValue=0;
		for(int i=0;i<n;i++)
		{
			if(currWeight+arr[i].weight<=W)
			{
				currWeight+=arr[i].weight;
				finalValue+=arr[i].value;
			}
			else
			{
				int remains=W-currWeight;
				finalValue+=((double)arr[i].value/(double)arr[i].weight)*remains;
				break;
			}
		}
		return finalValue;
	}

	public static void main(String[] args) {
		FractionalKnapsack a=new FractionalKnapsack();
		int W=50,n=3;
		Item[] arr;
	//	System.out.println(a.fractionalKnapsack(W, , n));
		// func is correct but i could not come up with driver func .

	}

}
