public class HumanPlayer extends Player {

    private boolean whiteSide;
    private boolean humanPlayer;

    public HumanPlayer(boolean whiteSide) {
        super(whiteSide);
    }

    public void setWhite() {
        this.whiteSide = true;
    }
}
