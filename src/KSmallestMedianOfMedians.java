import java.util.Arrays;

public class KSmallestMedianOfMedians {
    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1, 6, 8, 7};
        int k = 7;
        int n = arr.length;
        //long start = System.currentTimeMillis();
        System.out.println(kSmallest(arr, 0, n - 1, k));
        //long end = System.currentTimeMillis();
        //System.out.println(end - start);
    }


    private static int kSmallest(int[] arr, int l, int r, int k) {
        if (k > 0 && k <= r - l + 1) {
            int n = r - l + 1;//number of elements in array
            int i;
            int[] median = new int[(n + 4) / 5];
            for (i = 0; i < n / 5; i++)
                median[i] = findMedian(arr, l + i * 5, 5);
            if (i * 5 < n) {
                median[i] = findMedian(arr, l + i * 5, n % 5);
                i++;
            }
            int medOfMed = (i == 1) ? median[i - 1] :
                    kSmallest(median, 0, i - 1, i / 2);
            int pos = partition(arr, l, r, medOfMed);
            if (pos - l == k - 1) {
                return arr[pos];
            }
            if (pos - l > k - 1) {
                return kSmallest(arr, l, pos - 1, k);
            } else {
                return kSmallest(arr, pos + 1, r, k - pos + l - 1);
            }
        }
        return Integer.MAX_VALUE;
    }

    private static int findMedian(int[] arr, int l, int size) {
        Arrays.sort(arr, l, l + size);
        return arr[l + (size / 2)];
    }

    private static int partition(int[] arr, int l, int r, int medOfMed) {
        for (int i = l; i <= r; i++) {
            if (arr[i] == medOfMed) {
                swap(arr, i, r);
                break;
            }
        }
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
