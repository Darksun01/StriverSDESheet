package arraysSortingSearchingMaths;
import java.util.*;
public class GridUniquePaths {
	public int bruteForce(int m,int n)
	{
		return helper(0,0,m,n);
	}

	private int helper(int i, int j, int m, int n) {
		if(i==m-1 && j==n-1) return 1;
		if(i>=m || j>=n) return 0;
		
		return helper(i+1,j,m,n)+helper(i,j+1,m,n);
	}
	/////////////////////////////////////////////////////////////////////////////////////////
	int [][]dp;
	public int betterApproach(int m,int n)
	{
		dp=new int [m][n];
		return utilFunc(0,0,m,n);
	}

	private int utilFunc(int i, int j, int m, int n) {
		if(i==m-1 && j==n-1) return 1;
		if(i>=m || j>=n) return 0;
		for(int []d:dp)
		{
			Arrays.fill(d, -1);
		}
		if(dp[i][j]!=-1)
			return dp[i][j];
		else
			return dp[i][j]=utilFunc(i+1,j,m,n)+utilFunc(i,j+1,m,n);
	}
	////////////////////////////////////////////////////////////////////////////////////////
	public int optimalApproach(int m,int n)
	{
		int N=m+n-2;
		int r=m-1;
		double res=1;
		for(int i=1;i<=r;i++)
		{
			res=res*(N-r+i)/i;
		}
		return (int)res;
	}

	public static void main(String[] args) {
		GridUniquePaths a=new GridUniquePaths();
		int m=7,n=3;
		System.out.println(a.bruteForce(m, n));
		System.out.println(a.betterApproach(m, n));
		System.out.println(a.optimalApproach(m, n));

	}

}
