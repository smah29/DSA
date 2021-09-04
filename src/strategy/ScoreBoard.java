package strategy;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ScoreBoard {
    ScoreBoardBase scoreBoardBase;
    Congrats congrats;
    public void viewScore(int taps, int multiplier){
        System.out.println(scoreBoardBase.calculateScore(taps,multiplier));
        congrats.congrats();
    }

}
