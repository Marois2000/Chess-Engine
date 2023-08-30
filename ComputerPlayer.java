/**
 * ComputerPlayer
 */
public class ComputerPlayer extends Player{

    private boolean whiteSide;
    private boolean humanPlayer;

    public ComputerPlayer(boolean whiteSide) {
        this.whiteSide = whiteSide;
        this.humanPlayer = false;
    }
    
}