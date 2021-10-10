import java.util.*;

public class MaxTimeToRotAllOrange {
	public static final int R = 3;
	public static final int C = 5;
	static class Ele {
		int x = 0, y = 0;
		public Ele(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static boolean isValid(int i, int j) {
		return (i >= 0 && j >= 0 && i < R && j < C);
	}
	static boolean isDelim(Ele temp) {
		return (temp.x == -1 && temp.y == -1);
	}
	static boolean checkALl(int arr[][]) {
		for (int i = 0; i < R  ; i++ ) {
			for (int  j = 0 ; j < C ; j++ ) {
				if (arr[i][j] == 1)
					return true;
			}
		}
		return false;
	}
	static int rotAllOranges(int arr[][]) {
		Queue<Ele> q = new LinkedList<>();
		Ele temp;
		int ans = 0;
		for (int i = 0; i < R ; i++ ) {
			for (int j = 0; j < C ; j++ ) {
				if (arr[i][j] == 2) {
					q.add(new Ele(i, j));
				}
			}
		}
		q.add(new Ele(-1, -1));
		while (!q.isEmpty()) {
			boolean flag = false;
			while (!isDelim(q.peek())) {
				temp = q.peek();
				if (isValid(temp.x + 1, temp.y) && arr[temp.x + 1][temp.y] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x + 1][temp.y] = 2;
					temp.x++;
					q.add(new Ele(temp.x, temp.y));
					temp.x--;
				}
				if (isValid(temp.x, temp.y + 1) && arr[temp.x][temp.y + 1] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x][temp.y + 1] = 2;
					temp.y++;
					q.add(new Ele(temp.x, temp.y));
					temp.y--;
				}
				if (isValid(temp.x - 1, temp.y) && arr[temp.x - 1][temp.y] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x - 1][temp.y] = 2;
					temp.x--;
					q.add(new Ele(temp.x, temp.y));
					temp.x++;
				}

				if (isValid(temp.x, temp.y - 1) && arr[temp.x][temp.y - 1] == 1) {
					if (!flag) {
						ans++;
						flag = true;
					}
					arr[temp.x][temp.y - 1] = 2;
					temp.y--;
					q.add(new Ele(temp.x, temp.y));
					temp.y++;
				}
				q.remove();

			}
			q.remove();
			if (!q.isEmpty()) {
				q.add(new Ele(-1, -1));
			}
		}
		return (checkALl(arr)) ? -1 : ans;
	}
	public static void main(String[] args) {
		int arr[][] = { {2, 1, 0, 2, 1},
			{1, 0, 1, 2, 1},
			{1, 0, 0, 2, 1}
		};
		int ans = rotAllOranges(arr);
		if (ans == -1)
			System.out.println("All oranges cannot rot");
		else
			System.out.println("Time required for all oranges to rot = " + ans);

	}



}

