package arraysSortingSearchingMaths;
import java.util.*;
public class PowXN {
	public void bruteForce(double x,int n)
	{
		double ans=1;
		long num=n;
		if(num<0) num*=-1;
		for(int i=1;i<=n;i++)
		{
			ans*=x;
		}
		if(n<0) ans=(double)1.0/ans;
		System.out.println(ans);
	}
	public double optimalApproachRecursion(double x,int n)
	{
		double ans=1;
		long num=n;
		if(num<0) num*=-1;
		if(num==0) return 1;
		if(num%2==0)
		
			return optimalApproachRecursion(x*x,n/2);
		
		else
		
			return x*optimalApproachRecursion(x,n-1);
		
	}
	public void optimalApproach(double x,int n)
	{
		double ans=1.0;
		long num=n;
		if(num<0) num*=-1;
		while(num>0)
		{
			if(num%2==0)
			{
				x=x*x;
				num/=2;
			}
			else
			{
				ans*=x;
				num-=1;
			}
		}
		if(n<0) ans=(double)1.0/(double)ans;
		System.out.println(ans);
	}

	public static void main(String[] args) {
		PowXN a=new PowXN();
		double x=2.0;
		int n=10;
		a.bruteForce(x, n);
		System.out.println(a.optimalApproachRecursion(x, n));
		a.optimalApproach(x, n);

	}

}
