public abstract class Player {

    private boolean whiteSide;
    private boolean humanPlayer;

    public Player(boolean whiteSide) {
        this.whiteSide = whiteSide;
    }

    public boolean isWhiteSide() {
        return this.whiteSide;
    }

    public boolean isHumanPlayer() {
        return this.humanPlayer;
    }

    public void setWhite() {
        this.whiteSide = true;
    }
}
