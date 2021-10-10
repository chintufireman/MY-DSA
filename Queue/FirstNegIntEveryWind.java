import java.util.*;

public class FirstNegIntEveryWind {
	public static void main(String[] args) {
		int arr[] = {12, -1, -7, 8, -15, 30, 16, 28};
		int n = arr.length;
		int k = 3;
		printFirstNegativeInteger(arr, n, k);
	}

	static void printFirstNegativeInteger(int arr[], int n, int k) {
		LinkedList<Integer> di = new LinkedList<>();
		for (int i = 0; i < k ; i++ ) {
			if (arr[i] < 0)
				di.add(i);
		}
		for (int i = k; i < n ; i++ ) {
			if (!di.isEmpty())
				System.out.println(arr[di.peek()]);
			else
				System.out.println("0");
			while (!di.isEmpty() && di.peek() <= i - k)
				di.remove();
			if (arr[i] < 0)
				di.add(i);
		}
		if (!di.isEmpty())
			System.out.println(arr[di.peek()]);
		else
			System.out.println("0");

	}
}