import java.util.*;
public class FirstNonRepeatingChar {
	public static void main(String[] args) {
		String s = "aabc";
		firstNonRepeatChar(s);
	}
	static void firstNonRepeatChar(String str) {
		int charFreq[] = new int[26];
		Queue<Character> q = new LinkedList<Character>();
		for (int i = 0; i < str.length() ; i++ ) {
			charFreq[str.charAt(i) - 'a']++;
			q.add(str.charAt(i));

			while (!q.isEmpty()) {
				if (charFreq[q.peek() - 'a'] > 1)
					q.remove();
				else {
					System.out.print(q.peek() + " ");
					break;
				}
			}
			if (q.isEmpty()) {
				System.out.print(-1 + " ");
			}
		}
		System.out.println();

	}
}