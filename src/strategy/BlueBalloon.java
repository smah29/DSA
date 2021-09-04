package strategy;

public class BlueBalloon implements ScoreBoardBase {
    @Override
    public int calculateScore(int taps, int multiplier) {
        return taps * multiplier + 1;
    }
}
