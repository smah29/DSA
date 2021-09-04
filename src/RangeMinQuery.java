public class RangeMinQuery {
    int[] st;

    public RangeMinQuery(int[] arr, int length) {
        int x = (int) Math.ceil(Math.log(length) / Math.log(2));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size];
        constructUtil(arr, 0, length - 1, 0);
    }

    private int constructUtil(int[] arr, int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
        int mid = getMid(ss, se);
        st[si] = Math.min(constructUtil(arr, ss, mid, 2 * si + 1),
                constructUtil(arr, mid + 1, se, 2 * si + 2));
        return st[si];
    }

    private int getMid(int ss, int se) {
        return ss + (se - ss) / 2;
    }

    public static void main(String[] args) {
        int arr[] = {9, 3, 5, 1, 6, 2, 5};
        int n = arr.length;
        RangeMinQuery rmq = new RangeMinQuery(arr, n);
        System.out.println(rmq.getRMQ(n, 0, n-1));
    }

    private int getRMQ(int n, int qs, int qe) {
        if (qs < 0 || qe >= n || qs > qe) {
            System.out.println("Invalid input");
            return -1;
        }
        return getRMQUtil(0, n - 1, qs, qe, 0);
    }

    private int getRMQUtil(int ss, int se, int qs, int qe, int si) {
        if (ss >= qs && se <= qe) {
            return st[si];
        }
        if (se < qs || ss > qe) {
            return Integer.MAX_VALUE;
        }
        int mid = getMid(ss, se);
        return Math.min(getRMQUtil(ss, mid, qs, qe, 2 * si + 1), getRMQUtil(mid + 1, se, qs, qe, 2 * si + 2));
    }

}
