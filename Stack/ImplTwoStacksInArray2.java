class TwoStacks {
	int top1, top2, size;
	int a[];
	public TwoStacks(int size) {
		this.size = size;
		this.top1 = -1;
		this.top2 = size;
		this.a = new int[size];
	}
	void push1(int data) {
		if (top1 < top2 - 1) {
			top1++;
			a[top1] = data;
			System.out.println(data + "pushed in stack1");
		} else {
			System.out.println("Stack1 overflow");
			System.exit(1);
		}
	}
	void push2(int data) {
		if (top1 < top2 - 1) {
			top2--;
			a[top2] = data;
			System.out.println(data + "pushed in stack2");
		} else {
			System.out.println("stack2 overflow");
			System.exit(1);
		}
	}
	int pop1() {
		if (top1 < 0) {
			System.out.println("Stack1 underflow");
			System.exit(1);
			return 0;
		} else {
			int data = a[top1];
			top1--;

			return data;
		}
	}
	int pop2() {
		if (top2 == size) {
			System.out.println("Stack2 underflow");
			System.exit(1);
			return 0;
		} else {
			int data = a[top2];
			top2++;
			return data;
		}
	}
}
class ImplTwoStacksInArray2 {
	public static void main(String[] args) {
		TwoStacks ts = new TwoStacks(5);
		ts.push1(5);
		ts.push2(10);
		ts.push2(15);
		ts.push1(11);
		ts.push2(7);
		System.out.println("Popped element from"
		                   + " stack1 is " + ts.pop1());
		ts.push2(40);
		System.out.println("Popped element from"
		                   + " stack2 is " + ts.pop2());
	}
}