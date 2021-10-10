import java.util.*;

public class MinStringValue {
	static final int MAX_CHAR = 26;

	public static void main(String[] args) {
		String s = "abbccc";
		int k = 2;
		System.out.println(minStringValue(s, k));
	}
	static int minStringValue(String s, int k) {
		int size = s.length();
		int freq[] = new int[MAX_CHAR];
		if (k == size)
			return 0;
		for (int i = 0; i < size ; i++ ) {
			freq[s.charAt(i) - 'a']++;
		}
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0 ; i < MAX_CHAR ; i++ ) {
			if (freq[i] != 0)
				q.add(freq[i]);
		}
		while (k != 0) {
			q.add(q.poll() - 1);
			k--;
		}
		int sum = 0;
		while (!q.isEmpty()) {
			sum += q.peek() * q.poll();

		}
		return sum;
	}
}