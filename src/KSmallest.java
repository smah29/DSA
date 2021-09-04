public class KSmallest {
    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};
        int k = 4;
        int n = arr.length;
        long start = System.currentTimeMillis();
        System.out.println(kSmallest(arr, 0, n - 1, k));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }


    private static int kSmallest(int[] arr, int l, int r, int k) {
        if (k > 0 && k <= r - l + 1) {
            int pos = partition(arr, l, r);
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

    private static int partition(int[] arr, int l, int r) {
        int n = r - l + 1;
        int random = (int) Math.random() * (n - 1);
        if (l + random != r) {
            swap(arr, l + random, r);
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
