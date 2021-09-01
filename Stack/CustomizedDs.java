import java.util.ArrayList;
public class CustomizedDs {
	class Pair {
		int min_elment;
		int element;
		Pair(int data, int min_elment) {
			this.min_elment = min_elment;
			this.element = data;

		}
	}
	int min;
	ArrayList<Pair> stack = new ArrayList<>();
	CustomizedDs() {
		this.min = Integer.MAX_VALUE;
	}
	void addElement(int x) {
		if (stack.size() == 0 || x < min) {
			min = x;
		}
		Pair pair = new Pair(x, min);
		stack.add(pair);
		System.out.println(x + " added");
	}
	int getLastElement() {
		if (stack.size() == 0) {
			System.out.println("stack underflow");
			return -1;
		} else
			return stack.get(stack.size() - 1).element;
	}
	int getMin() {
		if (stack.size() == 0) {
			System.out.println("no element in stack");
			return -1;
		} else {
			return stack.get(stack.size() - 1).min_elment;
		}
	}
	void removeLastElement() {
		if (stack.size() == 0) {
			System.out.println("stack underflow");
		} else if (stack.size() > 1) {
			min = stack.get(stack.size() - 2).min_elment;
		} else {
			min = Integer.MAX_VALUE;
		}
		stack.remove(stack.size() - 1);
		System.out.println("removed successfully");
	}
	public static void main(String[] args) {
		CustomizedDs newStack = new CustomizedDs();
		newStack.addElement(5);
		newStack.addElement(7);
		newStack.addElement(3);
		System.out.println("min element :: " + newStack.getMin());
		newStack.removeLastElement();
		System.out.println("min element ::" + newStack.getMin());
	}
}