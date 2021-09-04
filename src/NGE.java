import java.util.Stack;

public class NGE {
    public static void main(String[] args) {
        int arr[] = {11, 13, 21, 3};
        int n = arr.length;
        printNGE(arr, n);
    }

    private static void printNGE(int[] arr, int n) {
        Stack<Integer> s = new Stack<>();
        s.push(arr[0]);
        for (int i = 1; i < n; i++) {
            int next = arr[i];
            int element = s.peek();
            if (!s.isEmpty()) {
                while (element < next) {
                    System.out.println(s.pop() + " next is " + next);
                    if (s.isEmpty()) break;
                    element = s.peek();
                }
            }
            s.push(next);
        }
        while (!s.isEmpty()) {
            System.out.println(s.pop() + " next is -1");
        }
    }
}
