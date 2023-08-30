import javax.swing.*;

public class ChessFrame extends JFrame {
    private ChessPanel panel = new ChessPanel();

    public ChessFrame() {

        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ChessFrame();
    }
}
