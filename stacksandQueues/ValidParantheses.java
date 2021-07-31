package stacksandQueues;
import java.util.*;
public class ValidParantheses {
	public boolean validParantheses(String str)
	{
		Stack<Character> st=new Stack<Character>();
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='(' || str.charAt(i)=='[' || str.charAt(i)=='{')
			{
				st.push(str.charAt(i));
			}
			else
			{
				if(!st.isEmpty())
				{
					char c=st.peek();
					st.pop();
					if(c!='(' && str.charAt(i)==')')
					{
						return false;
					}
					else if(c!='{' && str.charAt(i)=='}')
					{
						return false;
					}
					else if(c!='[' && str.charAt(i)==']')
					{
						return false;
					}
				}
				else
				{
					return false;
				}
			}
		}
		if(st.isEmpty())
		{
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		ValidParantheses a=new ValidParantheses();
		String str="[()]";
		System.out.println(a.validParantheses(str));

	}

}
