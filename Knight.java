public class Knight extends Piece {

    public Knight(boolean white) {
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
        return x * y == 2;
    }

}
