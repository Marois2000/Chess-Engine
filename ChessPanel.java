import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;

public class ChessPanel extends JPanel implements MouseListener {

    int spotSize = 100;
    private Color boardColor = new Color(0x661c1f);
    private ImageIcon blackPawn = new ImageIcon("Pieces/BlackPawn.png");
    private ImageIcon blackRook = new ImageIcon("Pieces/BlackRook.png");
    private ImageIcon blackKnight = new ImageIcon("Pieces/BlackKnight.png");
    private ImageIcon blackBishop = new ImageIcon("Pieces/BlackBishop.png");
    private ImageIcon blackKing = new ImageIcon("Pieces/BlackKing.png");
    private ImageIcon blackQueen = new ImageIcon("Pieces/BlackQueen.png");

    private ImageIcon whitePawn = new ImageIcon("Pieces/WhitePawn.png");
    private ImageIcon whiteRook = new ImageIcon("Pieces/WhiteRook.png");
    private ImageIcon whiteKnight = new ImageIcon("Pieces/WhiteKnight.png");
    private ImageIcon whiteBishop = new ImageIcon("Pieces/WhiteBishop.png");
    private ImageIcon whiteKing = new ImageIcon("Pieces/WhiteKing.png");
    private ImageIcon whiteQueen = new ImageIcon("Pieces/WhiteQueen.png");

    Board board;
    HumanInput input = new HumanInput();
    ArrayList<Integer> inputs = new ArrayList<>();
    Player p1 = new HumanPlayer(true);
    Player p2 = new HumanPlayer(false);
    Game game;

    public ChessPanel() {
        this.addMouseListener(this);
        this.setPreferredSize(new Dimension(spotSize * 8, spotSize * 8));

        game = new Game(p1, p2);
        board = game.getBoard();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (j % 2 == 1 && i % 2 == 1) {
                    g2d.setColor(Color.white);
                } else if (j % 2 == 0 && i % 2 == 0) {
                    g2d.setColor(Color.white);
                } else {
                    g2d.setColor(boardColor);
                }

                g2d.fillRect(i * spotSize, j * spotSize, spotSize, spotSize);


                if (!inputs.isEmpty()) {
                    if (board.getSpot(inputs.get(0), inputs.get(1)).getPiece() != null) {
                        if (board.getSpot(inputs.get(0), inputs.get(1)).getPiece().canMove(board,
                                board.getSpot(inputs.get(0), inputs.get(1)), board.getSpot(j, i))) {
                            g2d.setColor(Color.yellow);
                            g2d.fillOval(i * spotSize, j * spotSize, spotSize, spotSize);
                        }
                    }
                }

                try {

                    

                    if (board.getSpot(j, i).getPiece() != null) {
                        if (board.getSpot(j, i).getPiece() instanceof King) {
                            if (board.getSpot(j, i).getPiece().isWhite()) {
                                Image image = whiteKing.getImage();
                                g.drawImage(image, i * spotSize, j * spotSize, spotSize, spotSize, this);
                            } else {
                                Image image = blackKing.getImage();
                                g.drawImage(image, i * spotSize, j * spotSize, spotSize, spotSize, this);
                            }
                        } else if (board.getSpot(j, i).getPiece() instanceof Queen) {
                            if (board.getSpot(j, i).getPiece().isWhite()) {
                                Image image = whiteQueen.getImage();
                                g.drawImage(image, i * spotSize, j * spotSize, spotSize, spotSize, this);
                            } else {
                                Image image = blackQueen.getImage();
                                g.drawImage(image, i * spotSize, j * spotSize, spotSize, spotSize, this);
                            }
                        } else if (board.getSpot(j, i).getPiece() instanceof Bishop) {
                            if (board.getSpot(j, i).getPiece().isWhite()) {
                                Image image = whiteBishop.getImage();
                                g.drawImage(image, i * spotSize, j * spotSize, spotSize, spotSize, this);
                            } else {
                                Image image = blackBishop.getImage();
                                g.drawImage(image, i * spotSize, j * spotSize, spotSize, spotSize, this);
                            }
                        } else if (board.getSpot(j, i).getPiece() instanceof Knight) {
                            if (board.getSpot(j, i).getPiece().isWhite()) {
                                Image image = whiteKnight.getImage();
                                g.drawImage(image, i * spotSize, j * spotSize, spotSize, spotSize, this);
                            } else {
                                Image image = blackKnight.getImage();
                                g.drawImage(image, i * spotSize, j * spotSize, spotSize, spotSize, this);
                            }
                        } else if (board.getSpot(j, i).getPiece() instanceof Rook) {
                            if (board.getSpot(j, i).getPiece().isWhite()) {
                                Image image = whiteRook.getImage();
                                g.drawImage(image, i * spotSize, j * spotSize, spotSize, spotSize, this);
                            } else {
                                Image image = blackRook.getImage();
                                g.drawImage(image, i * spotSize, j * spotSize, spotSize, spotSize, this);
                            }
                        } else if (board.getSpot(j, i).getPiece() instanceof Pawn) {
                            if (board.getSpot(j, i).getPiece().isWhite()) {
                                Image image = whitePawn.getImage();
                                g.drawImage(image, i * spotSize, j * spotSize, spotSize, spotSize, this);
                            } else {
                                Image image = blackPawn.getImage();
                                g.drawImage(image, i * spotSize, j * spotSize, spotSize, spotSize, this);
                            }
                        }
                    } else {

                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX() / 100;
        int y = e.getY() / 100;
        inputs.add(y);
        inputs.add(x);
        System.out.println(inputs);
        repaint();

        if (inputs.size() == 4) {
            System.out.println(
                    game.playerMove(game.getCurrentTurn(), inputs.get(0), inputs.get(1), inputs.get(2), inputs.get(3)));
            inputs.clear();
            repaint();
        }




        System.out.println(inputs);

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
