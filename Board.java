import java.util.*;

public class Board {
    public Spot[][] spots;

    public Board() {
        this.spots = new Spot[8][8];
        this.resetBoard();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            sb.append("|");
            for (int j = 0; j < 8; j++) {
                if (spots[i][j].getPiece() != null) {
                    if (!spots[i][j].getPiece().isWhite()) {
                        sb.append("B");
                    } else if (spots[i][j].getPiece().isWhite()) {
                        sb.append("W");
                    }

                    if (spots[i][j].getPiece() instanceof King) {
                        sb.append("K");
                    } else if (spots[i][j].getPiece() instanceof Queen) {
                        sb.append("Q");
                    } else if (spots[i][j].getPiece() instanceof Bishop) {
                        sb.append("B");
                    } else if (spots[i][j].getPiece() instanceof Knight) {
                        sb.append("N");
                    } else if (spots[i][j].getPiece() instanceof Rook) {
                        sb.append("R");
                    } else if (spots[i][j].getPiece() instanceof Pawn) {
                        sb.append("P");
                    }
                } else {
                    sb.append("  ");
                }

                sb.append("|");
            }
            sb.append("\n");
            sb.append("|--|--|--|--|--|--|--|--|\n");
        }

        return sb.toString();
    }

    public Spot getSpot(int x, int y) {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            try {
                throw new Exception("Index out of bound");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return spots[x][y];
    }

    public void resetBoard() {
        // white specials
        spots[0][0] = new Spot(0, 0, new Rook(true));
        spots[0][1] = new Spot(0, 1, new Knight(true));
        spots[0][2] = new Spot(0, 2, new Bishop(true));
        spots[0][3] = new Spot(0, 3, new Queen(true));
        spots[0][4] = new Spot(0, 4, new King(true));
        spots[0][5] = new Spot(0, 5, new Bishop(true));
        spots[0][6] = new Spot(0, 6, new Knight(true));
        spots[0][7] = new Spot(0, 7, new Rook(true));
        // white pawns
        spots[1][0] = new Spot(1, 0, new Pawn(true));
        spots[1][1] = new Spot(1, 1, new Pawn(true));
        spots[1][2] = new Spot(1, 2, new Pawn(true));
        spots[1][3] = new Spot(1, 3, new Pawn(true));
        spots[1][4] = new Spot(1, 4, new Pawn(true));
        spots[1][5] = new Spot(1, 5, new Pawn(true));
        spots[1][6] = new Spot(1, 6, new Pawn(true));
        spots[1][7] = new Spot(1, 7, new Pawn(true));

        // black specials
        spots[7][0] = new Spot(7, 0, new Rook(false));
        spots[7][1] = new Spot(7, 1, new Knight(false));
        spots[7][2] = new Spot(7, 2, new Bishop(false));
        spots[7][3] = new Spot(7, 3, new Queen(false));
        spots[7][4] = new Spot(7, 4, new King(false));
        spots[7][5] = new Spot(7, 5, new Bishop(false));
        spots[7][6] = new Spot(7, 6, new Knight(false));
        spots[7][7] = new Spot(7, 7, new Rook(false));
        // black pawns
        spots[6][0] = new Spot(6, 0, new Pawn(false));
        spots[6][1] = new Spot(6, 1, new Pawn(false));
        spots[6][2] = new Spot(6, 2, new Pawn(false));
        spots[6][3] = new Spot(6, 3, new Pawn(false));
        spots[6][4] = new Spot(6, 4, new Pawn(false));
        spots[6][5] = new Spot(6, 5, new Pawn(false));
        spots[6][6] = new Spot(6, 6, new Pawn(false));
        spots[6][7] = new Spot(6, 7, new Pawn(false));

        // empty spots
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                spots[i][j] = new Spot(i, j, null);
            }
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board);
    }
}
