package strategy;

public class BalloonCongrats implements Congrats{
    @Override
    public void congrats() {
        System.out.println("Blow confetti");
    }
}
