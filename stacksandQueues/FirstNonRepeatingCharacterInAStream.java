package stacksandQueues;
import java.util.*;
public class FirstNonRepeatingCharacterInAStream {
	 
	public void bruteForce(StringBuilder sb)
	{
		HashMap<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<sb.length();i++) {
		map.put(sb.charAt(i),map.getOrDefault(sb.charAt(i), 0)+1);
		}
	//	char c='';
		for(int i=0;i<sb.length();i++)
		{
			if(map.get(sb.charAt(i))==1)
			{
				System.out.println(sb.charAt(i));
				break;
			}
			if(i==sb.length()-1)
			{
				System.out.println("-1");
			}
		}
	}
	public void betterApproach(String str)
	{
		
		Queue<Character> queue=new LinkedList<Character>();
		int []count=new int[256];
		for(int i=0;i<str.length();i++)
		{
			queue.add(str.charAt(i));
			count[str.charAt(i)]++;
			while(!queue.isEmpty())
			{
				if(count[str.charAt(i)]>1)
				{
					queue.remove();
				}
				else
				{
					System.out.println(queue.peek());
					break;
				}
			}
			if(queue.isEmpty())
			{
				System.out.println(-1);
			}
		}
	}

	public static void main(String[] args) {
		FirstNonRepeatingCharacterInAStream a=new FirstNonRepeatingCharacterInAStream();
//		StringBuilder sb=new StringBuilder();
//		sb.append('c');
//		sb.append('c');
//		sb.append('a');
//		sb.append('a');
		a.betterApproach("aabcbcg");
	}

}
