import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    private final int WINDOW_WIDTH = 800;
    private final int WINDOW_HEIGHT = 1000;
    private TicTacToe T;
    private Image O;
    private Image X;

    public TicTacToeViewer(TicTacToe T) {
        this.T = T;
        X = new ImageIcon("Resources/X.png").getImage();
        O = new ImageIcon("Resources/O.png").getImage();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("TicTacToe");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }

    public Image getImageX() {
        return this.X;
    }

    public Image getImageO() {
        return this.O;
    }

    public void paint(Graphics g) {
        Font s = new Font("Roman", Font.ROMAN_BASELINE, 20);
        g.setFont(s);
        g.setColor(Color.red);
        g.drawString("0", 150, 50);
        g.drawString("1", 300, 50);
        g.drawString("2", 450, 50);
        g.drawString("0", 50, 150);
        g.drawString("1", 50, 300);
        g.drawString("2", 50, 450);
        g.setColor(Color.BLACK);
        Square[][] squares = T.getBoard();
        for(int i = 0; i < squares.length; i++) {
            for(int j = 0; j < squares[i].length; j++) {
                squares[i][j].draw(g, this);
                if(T.getGameOver() && !T.checkTie()) {
                    g.drawString(T.getWinner() + " WINS", 300, 700);
                }
                else if (T.checkTie()) {
                    g.drawString("It's a Tie!", 300, 700);
                }
            }
        }
    }
}
