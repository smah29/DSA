package strategy;

public class ClownCongrats implements Congrats {
    @Override
    public void congrats() {
        System.out.println("Clown clap");
    }
}
