package strategy;

public class Main {
    public static void main(String[] args) {
        ScoreBoard scoreBoard = new ScoreBoard(new RedBalloon(), new BalloonCongrats());
        scoreBoard.viewScore(1, 2);
    }
}