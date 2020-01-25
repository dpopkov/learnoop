package learn.oop.asdppp.ch06episode;

public class Game {
    private final Scorer scorer = new Scorer();
    private int itsCurrentFrame = 0;
    private boolean firstThrowInFrame = true;

    public int score() {
        return scoreForFrame(itsCurrentFrame);
    }

    public int scoreForFrame(int frame) {
        return scorer.scoreForFrame(frame);
    }

    public void add(int pins) {
        scorer.addThrow(pins);
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (lastBallInFrame(pins)) {
            advanceFrame();
        } else {
            firstThrowInFrame = false;
        }
    }

    private boolean lastBallInFrame(int pins) {
        return strike(pins) || !firstThrowInFrame;
    }

    private boolean strike(int pins) {
        return firstThrowInFrame && pins == 10;
    }

    private void advanceFrame() {
        itsCurrentFrame = Math.min(10, itsCurrentFrame + 1);
    }
}
