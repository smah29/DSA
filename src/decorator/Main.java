package decorator;

public class Main {
    public static void main(String[] args) {
        IceCream iceCream = new BasicIceCream();
        System.out.println(iceCream.cost());
        iceCream = new MintIceCream(iceCream);
        System.out.println(iceCream.cost());
        iceCream = new VanillaIceCream(iceCream);
        System.out.println(iceCream.cost());
    }
}
