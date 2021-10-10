import java.util.*;

class SumOfKSubArrayOfMinMax {
	public static void main(String[] args) {
		int arr[] = {2, 5, -1, 7, -3, -1, -2};
		int n = 3;
		System.out.println("Total sum of every min max of every k window in array is"
		                   + sumOfMinMaxOfKSubArray(arr, n));
	}
	static int sumOfMinMaxOfKSubArray(int arr[], int k) {
		int sum = 0; //to cal sum
		int i;
		Deque<Integer> G = new LinkedList<>();//to store max of kth sub window
		Deque<Integer> S = new LinkedList<>();//to store min of kth sub window
		for ( i = 0; i < k ; i++ ) {
			while (!S.isEmpty() && arr[S.peekLast()] >= arr[i])
				S.removeLast();
			while (!G.isEmpty() && arr[G.peekLast()] <= arr[i])
				G.removeLast();
			G.addLast(i);
			S.addLast(i);
		}
		for (; i < arr.length; i++) {
			sum += arr[S.peekFirst()] + arr[G.peekFirst()];
			if (!S.isEmpty() && S.peekFirst() <= i - k)
				S.removeFirst();
			if (!G.isEmpty() && G.peekFirst() <= i - k)
				G.removeFirst();

			while (!S.isEmpty() && arr[S.peekLast()] >= arr[i])
				S.removeLast();
			while (!G.isEmpty() && arr[G.peekLast()] <= arr[i])
				G.removeLast();

			G.addLast(i);
			S.addLast(i);
		}
		sum += arr[S.peekFirst()] + arr[G.peekFirst()];
		return sum;

	}
}