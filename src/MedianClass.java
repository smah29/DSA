public class MedianClass {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5};
        findMedian(arr);
    }

    private static void findMedian(int[] arr) {
        int n = arr.length;
        if (n % 2 == 1) {
            System.out.println(median(arr, 0, n - 1, n / 2));
        } else {
            int a = median(arr, 0, n - 1, n / 2);
            int b = median(arr, 0, n - 1, n / 2 - 1);
            System.out.println((double)(a + b) / 2);
        }
    }

    private static int median(int[] arr, int l, int r, int mid) {
        int pos = partition(arr, l, r);
        if (pos == mid) {
            return arr[pos];
        }
        if (pos > mid) {
            return median(arr, l, pos - 1, mid);
        } else {
            return median(arr, pos + 1, r, mid);
        }
    }

    private static int partition(int[] arr, int l, int r) {
        int pivot = arr[r];
        int i = l;
        for (int j = l; j <= r; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
