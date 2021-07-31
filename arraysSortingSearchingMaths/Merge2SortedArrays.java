package arraysSortingSearchingMaths;
import java.util.*;
public class Merge2SortedArrays {
	public void bruteForce(int []arr1,int []arr2)
	{
		if(arr1.length==0 && arr2.length==0) return;
		int i=0,j=0;
		int []merge=new int[arr1.length+arr2.length];
		int k=0;
		while(i<arr1.length && j<arr2.length)
		{
			if(arr1[i]<=arr2[j])
			{
				merge[k]=arr1[i];
				i++;k++;
			}
			else if(arr1[i]>=arr2[j])
			{
				merge[k]=arr2[j];
				j++;k++;
			}
			else
			{
				merge[k]=arr1[i];
				k++;i++;j++;
			}
		}
		while(i<arr1.length)
		{
			merge[k]=arr1[i];
			i++;k++;
		}
		while(j<arr2.length)
		{
			merge[k]=arr2[j];
			j++;k++;
		}
		for(int t=0;t<merge.length;t++)
		{
			System.out.print(merge[t]+" ");
		}
	}
	public void betterApproach(int []arr1,int []arr2)
	{
		int i=0,j=0;
		while(i<arr1.length && j<arr2.length)
		{
			if(arr1[i]>arr2[j])
			{
				int temp=arr1[i];
				arr1[i]=arr2[j];
				arr2[j]=temp;
				Arrays.sort(arr2);
				i++;
			}
			else
			{
				i++;
			}
		}
		for(i=0;i<arr1.length;i++)
		{
			System.out.print(arr1[i]+" ");
		}
		for(j=0;j<arr2.length;j++)
		{
			System.out.print(arr2[j]+" ");
		}
	}
	public void optimalApproach(int []arr1,int []arr2)
	{
		int n = arr1.length, m = arr2.length;
        int gap = n + m;
        gap = (gap / 2) + (gap % 2);
        int pointer1 = 0;
        int pointer2 = 0;
        while (gap > 0) {
        pointer1 = 0;
        pointer2 = gap < n ? gap : gap - n;
        if (gap < n) {
            while (pointer1 < n && pointer2 < n) {
                check(arr1, arr1, pointer1, pointer2);
                pointer1++;
                pointer2++;
            }
        }

        //Setting pointer2 at the start of second array
        if(pointer2 == n){
            pointer2 = 0;
        }

        //While pointer1 is in first array and pointer 2 is in second array
        while (pointer1 < n && pointer2 < m) {
            check(arr1, arr2, pointer1, pointer2);
            pointer1++;
            pointer2++;
        }

        //Setting pointer1 at the start of second array
        if(pointer1 == n){
            pointer1 = 0;
        }

        //While pointer1 and pointer 2 are in second array
        while (pointer1 < m && pointer2 < m) {
            check(arr2, arr2, pointer1, pointer2);
            pointer1++;
            pointer2++;
        }
        if(gap == 1){
            break;
        }
        gap = (gap / 2) + (gap % 2);
        }
        for(int i=0;i<arr1.length;i++)
        {
        	System.out.print(arr1[i]+" ");
        }
        for(int j=0;j<arr2.length;j++)
        {
        	System.out.print(arr2[j]+" ");
        }
    }

	 public static void check(int arr1[], int arr2[], int pointer1, int pointer2) {
	        if (arr1[pointer1] > arr2[pointer2]) {
	            int temp = arr1[pointer1];
	            arr1[pointer1] = arr2[pointer2];
	            arr2[pointer2] = temp;
	        }
	    }
	public static void main(String[] args) {
		Merge2SortedArrays a=new Merge2SortedArrays();
		int arr1[] = { 1, 3, 5, 7}, arr2[] = {2, 4, 6, 8} ;
	//	a.bruteForce(arr1, arr2);
	//	a.betterApproach(arr1, arr2);
		a.optimalApproach(arr1, arr2);

	}

}
