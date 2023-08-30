import java.util.ArrayList;

public class Game {
    private Player[] players = { null, null };
    private Board board = new Board();
    private Player currentTurn;
    private ArrayList<Move> moves = new ArrayList<>();

    public Game(Player p1, Player p2) {
        p1.setWhite();
        players[0] = p1;
        players[1] = p2;

        board.resetBoard();


        if (p1.isWhiteSide()) {
            currentTurn = p1;
        } else {
            currentTurn = p2;
        }

        moves.clear();
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) {
        Spot startSpot = board.getSpot(startX, startY);
        Spot endSpot = board.getSpot(endX, endY);

        Move move = new Move(player, startSpot, endSpot);

        return makeMove(move, player);
    }

    public boolean makeMove(Move move, Player player) {

        Piece sourcePiece = move.getStart().getPiece();

        if (sourcePiece == null) {
            System.out.println("null");
            return false;
        }

        if (player != currentTurn) {
            System.out.println("currturn");
            return false;
        }

        if (sourcePiece.isWhite() != player.isWhiteSide()) {
            System.out.println("whiteside");

            return false;
        }

        if (!sourcePiece.canMove(board, move.getStart(), move.getEnd())) {
            System.out.println("canmove");

            return false;
        }

        Piece endPiece = move.getStart().getPiece();
        if (endPiece != null) {
            endPiece.setKilled(true);
            move.setPieceKilled(endPiece);
        }

        // add castling move

        moves.add(move);

        if(move.getStart().getPiece() instanceof Pawn) {
            move.getStart().getPiece().setFirstMove(false);
        }

        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        if (currentTurn == players[0]) {
            currentTurn = players[1];
        } else {
            currentTurn = players[0];
        }

        return true;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }

}
