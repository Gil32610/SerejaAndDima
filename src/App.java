import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        int[] nums = { 8, 1, 3, 4, 1, 2, 6, 2 };
        pickingResult(nums);
    }

    public static void pickingResult(int[] nums) {
        Stack<Integer> right = new Stack<>();
        Stack<Integer> left = new Stack<>();
        fillStack(left, nums, false);
        fillStack(right, nums, true);

        int serejaPoints = 0;
        int dimaPoints = 0;

        while (!left.isEmpty() || !right.isEmpty()) {
            if (left.isEmpty())
                serejaPoints += right.pop();
            else if (right.isEmpty())
                serejaPoints += left.pop();
            else
                serejaPoints += right.peek() >= left.peek() ? right.pop() : left.pop();

            if (left.isEmpty() && right.isEmpty())
                break;
            if (right.isEmpty())
                dimaPoints += left.pop();
            else if (left.isEmpty())
                dimaPoints += right.pop();
            else {
                dimaPoints += right.peek() >= left.peek() ? right.pop() : left.pop();
            }
        }
        System.out.println("Sereja points: " + serejaPoints + "\nDima points: " + dimaPoints);
    }

    public static void fillStack(Stack<Integer> s, int[] array, boolean isRight) {
        if (isRight)
            for (int i = array.length / 2; i < array.length; i++) {
                s.push(array[i]);
            }
        else {
            for (int i = (array.length / 2) - 1; i >= 0; i--) {
                s.push(array[i]);
            }
        }
    }
}
