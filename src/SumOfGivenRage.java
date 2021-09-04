public class SumOfGivenRage {
    int[] st;

    public SumOfGivenRage(int arr[], int n) {
        sumOfGivenRageUtil(arr, 0, n - 1, 0);
    }

    private int sumOfGivenRageUtil(int[] arr, int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }
        int mid = getMid(ss, se);
        //st[si]=sumOfGivenRageUtil(arr,)+sumOfGivenRageUtil();
        return st[si];

    }

    private int getMid(int ss, int se) {
        return ss + (se - ss) / 2;
    }
}
