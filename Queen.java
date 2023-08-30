public class Queen extends Piece {

    public Queen(boolean white) {
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
        if (x == 0 && y >= 1) {
            return true;
        }

        if (y == 0 && x >= 1) {
            return true;
        }

        if (x == y) {
            return true;
        }

        return false;
    }

}
