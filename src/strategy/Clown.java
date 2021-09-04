package strategy;

public class Clown implements ScoreBoardBase{
    @Override
    public int calculateScore(int taps, int multiplier) {
        return taps * multiplier + 2;
    }
}
