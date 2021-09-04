package lra;

public class LRA_RMQ {
    static int[] st;

    private static void construct(int[] arr, int length) {
        int x = (int) Math.ceil(Math.log(length) / Math.log(2));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size];
        constructUtil(arr, 0, length - 1, 0);
    }


    private static int getMinIndex(int[] arr, int i, int j) {
        if (i == -1) return j;
        if (j == -1) return i;
        return arr[i] < arr[j] ? i : j;
    }

    private static int getMid(int ss, int se) {
        return ss + (se - ss) / 2;
    }

    public static void main(String[] args) {
        int arr[] = {9, 3, 5, 5, 6, 2, 5};
     //   int arr[] = {6, 1, 5, 4, 5, 2, 6};
        int n = arr.length;

        System.out.println(getMaxRecArea(arr, n));
    }

    private static int getMaxRecArea(int[] arr, int n) {
        construct(arr, n);
        return getMaxRecAreaUtil(arr, n, 0, n - 1);
    }

    private static int getMaxRecAreaUtil(int[] arr, int n, int l, int r) {
        if (l > r) return Integer.MIN_VALUE;
        if (l == r) return arr[l];
        int minIndex = getRMQ(arr, n, l, r);
        return Math.max(Math.max(getMaxRecAreaUtil(arr, n, l, minIndex - 1),
                getMaxRecAreaUtil(arr, n, minIndex + 1, r)), (r - l + 1) * arr[minIndex]);
    }

    private static int getRMQ(int arr[], int n, int qs, int qe) {
        if (qs < 0 || qe >= n || qs > qe) {
            System.out.println("Invalid input");
            return -1;
        }
        return getRMQUtil(arr, 0, n - 1, qs, qe, 0);
    }

    private static int getRMQUtil(int arr[], int ss, int se, int qs, int qe, int si) {
        if (ss >= qs && se <= qe) {
            return st[si];
        }
        if (se < qs || ss > qe) {
            return -1;
        }
        int mid = getMid(ss, se);
        return getMinIndex(arr, getRMQUtil(arr, ss, mid, qs, qe, 2 * si + 1),
                getRMQUtil(arr, mid + 1, se, qs, qe, 2 * si + 2));
    }

    private static int constructUtil(int[] arr, int ss, int se, int si) {
        if (ss == se) {
            return (st[si] = ss);
        }
        int mid = getMid(ss, se);
        st[si] = getMinIndex(arr, constructUtil(arr, ss, mid, 2 * si + 1),
                constructUtil(arr, mid + 1, se, 2 * si + 2));
        return st[si];
    }
}
