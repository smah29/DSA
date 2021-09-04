public class Test {
    public static void main(String[] args) {
        System.out.println(32>>31);
        decToBinary(32);
    }

    public static void decToBinary(int n)
    {
        // Size of an integer is assumed to be 32 bits
        for (int i = 31; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0)
                System.out.print("1");
            else
                System.out.print("0");
        }
    }
}
