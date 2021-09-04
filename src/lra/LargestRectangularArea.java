package lra;

public class LargestRectangularArea {
    public static void main(String[] args) {
        int hist[] = {6, 2, 5, 4, 5, 3, 2};
        System.out.println(getLargestRectangularArea(hist));
    }

    private static int getLargestRectangularArea(int[] arr) {
        int maxArea = 0;
        int minHeight = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, arr[i]);
            minHeight = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                minHeight = Math.min(arr[j], minHeight);
                int width = i - j + 1;
                maxArea = Math.max(maxArea, width * minHeight);
            }
        }
        return maxArea;
    }
}
