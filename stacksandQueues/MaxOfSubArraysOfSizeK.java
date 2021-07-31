package stacksandQueues;
import java.util.*;
public class MaxOfSubArraysOfSizeK {
	 static void printKMax(int arr[], int n, int k)
	    {
	        int j, max;
	 
	        for (int i = 0; i <= n - k; i++) {
	 
	            max = arr[i];
	 
	            for (j = 1; j < k; j++) {
	                if (arr[i+j] > max)
	                    max = arr[i + j];
	            }
	            System.out.print(max + " ");
	        }
	    }
	 

	public static void main(String[] args) {
		int arr[] = {2, 5, 4, 3, 1, 7};
	    int k = 3;
	    printKMax(arr,arr.length,k);
	}

}
