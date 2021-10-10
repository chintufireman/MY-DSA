public class CorrectNumber {
	public static void main(String[] args) {

		System.out.println(numberCorrectOrNot(7876));
	}
	static boolean numberCorrectOrNot(int n) {
		int m = n;
		String s = Integer.toString(m);
		int num[] = new int[s.length()];
		for (int i = 0; i < s.length() ; i++ ) {
			num[i] = s.charAt(i) - '0';

		}
		int i = 0;
		int count = 1;
		while ((i < s.length() - 1) && (count == 1)) {
			int n1 = num[i] - num[i + 1];
			int n2 = num[i + 1] - num[i];
			if ((n1 == 1 || n1 == -1) && (n2 == 1 || n2 == -1)) {
				count = 1;
			} else
				count = 0;
			i++;
		}
		if (count == 1)
			return true;
		else
			return false;
	}
}

