class TwoStacks {
	int top1, top2;
	int size;
	int arr[];
	public TwoStacks(int size) {
		this.size = size;
		this.top1 = size / 2 + 1;
		this.top2 = size / 2;
		this.arr = new int[size];
	}

	public void push1(int data) {
		if (this.top1 < 0) {
			System.out.println("Stack overflow");
		} else {
			this.top1--;
			this.arr[top1] = data;
			System.out.println(data + "has been pushed in stack1");
		}
	}
	public void push2(int data) {
		if (this.top2 == (this.size - 1)) {
			System.out.println("Stack overflow");
		} else {
			this.top2++;
			this.arr[top2] = data;
			System.out.println(data + "has been pushed in stack2");
		}
	}
	public int pop1() {
		if (this.top1 <= this.size / 2) {
			int x = this.arr[top1];
			this.top1++;
			return x;
		} else {
			System.out.print("Stack UnderFlow");
			System.exit(1);
		}
		return 0;
	}
	int pop2() {
		if (this.top2 >= this.size / 2 + 1) {
			int x = this.arr[top2];
			this.top2--;
			return x;
		} else {
			System.out.print("Stack UnderFlow");
			System.exit(1);
		}
		return 1;
	}
}
class ImplTwoStacksInArray {
	public static void main(String[] args) {
		TwoStacks ts = new TwoStacks(5);
		ts.push1(5);
		ts.push2(10);
		ts.push2(15);
		ts.push1(11);
		ts.push2(7);
		System.out.print("Popped element from stack1 is "
		                 + " : " +  ts.pop1() + "\n");
		ts.push2(40);
		System.out.print("Popped element from stack2 is "
		                 + ": " +  ts.pop2()
		                 + "\n");
	}
}