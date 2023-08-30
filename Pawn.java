public class Pawn extends Piece {
    public boolean firstMove = true;
    public boolean enPassant = false;

    public Pawn(Boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {

        try {
            if (end.getPiece().isWhite() == this.isWhite()) {
                return false;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        int verticalStep = Integer.signum(end.getX() - start.getX());

        if (x == 1 && y == 1 && end.getPiece() != null) {
            return true;
        }

        if (firstMove && board.getSpot(start.getX() + verticalStep * 2, start.getY()).getPiece() != null) {
            return false;
        }

        if (board.getSpot(start.getX() + verticalStep, start.getY()).getPiece() != null) {
            return false;
        }

        if(this.isWhite() && verticalStep < 0) {
            return false;
        }

        if (x == 2 && y == 0 && firstMove) {
            return true;
        }

        if (x == 1 && y == 0) {
            return true;
        }

        

        // setup other moves eventually

        return false;
    }

    public void setFirstMove(boolean firstMove) {
        this.firstMove = false;
    }

}
