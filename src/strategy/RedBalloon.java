package strategy;

public class RedBalloon implements ScoreBoardBase{
    @Override
    public int calculateScore(int taps, int multiplier) {
        return taps * multiplier + 1;
    }
}
