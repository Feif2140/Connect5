import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectFive extends JFrame implements ActionListener {
    private final int[][] board; // -1 = black        1 = red
    private final JButton[][] gb = new JButton[5][8];
    private int one = -1, two = -1, three = -1, four = -1, five = -1, six = -1, seven = -1, eight = -1;
    private String turn;
    private final JLabel whoDisplay = new JLabel("Red players turn");
    private boolean gameover;

    public ConnectFive() {

        JPanel panel = new JPanel(new GridLayout(5, 8, 0, 0));
        panel.setBorder(new LineBorder(Color.blue, 1));
        whoDisplay.setBorder(new LineBorder(Color.red, 2));

        add(panel, BorderLayout.CENTER);
        JFrame f = new JFrame();
        f.setBounds(0, 0, 817, 555);

        board = new int[5][8];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = 0;
                gb[i][j] = new JButton();
                gb[i][j].setFont(new Font("Default", Font.BOLD, 65));
                gb[i][j].setBackground(new Color(51, 153, 255));
//                gb[i][j].setBorder(new LineBorder(new Color(103, 101, 101), 2));
                panel.add(gb[i][j]);
                gb[i][j].addActionListener(this);
            }
        }
        turn = "red";
        gameover = false;
        addIcon();
        add(whoDisplay, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int xVal, yVal;
        if (!gameover) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 8; j++) {
                    if (e.getSource() == gb[i][j]) {
                        xVal = j;
                        yVal = i;
                        if (j == 0 && one < 4) {
                            one++;
                            board[4 - one][j] = (turn.equals("red")) ? 1 : -1;
                            turn = (turn.equals("red")) ? "black" : "red";
                            System.out.println(xVal + "," + yVal + "one " + one);
                        }
                        if (j == 1 && two < 4) {
                            two++;
                            board[4 - two][j] = (turn.equals("red")) ? 1 : -1;
                            turn = (turn.equals("red")) ? "black" : "red";
                        }
                        if (j == 2 && three < 4) {
                            three++;
                            board[4 - three][j] = (turn.equals("red")) ? 1 : -1;
                            turn = (turn.equals("red")) ? "black" : "red";
                        }
                        if (j == 3 && four < 4) {
                            four++;
                            board[4 - four][j] = (turn.equals("red")) ? 1 : -1;
                            turn = (turn.equals("red")) ? "black" : "red";
                        }
                        if (j == 4 && five < 4) {
                            five++;
                            board[4 - five][j] = (turn.equals("red")) ? 1 : -1;
                            turn = (turn.equals("red")) ? "black" : "red";
                        }
                        if (j == 5 && six < 4) {
                            six++;
                            board[4 - six][j] = (turn.equals("red")) ? 1 : -1;
                            turn = (turn.equals("red")) ? "black" : "red";
                        }
                        if (j == 6 && seven < 4) {
                            seven++;
                            board[4 - seven][j] = (turn.equals("red")) ? 1 : -1;
                            turn = (turn.equals("red")) ? "black" : "red";
                        }
                        if (j == 7 && eight < 4) {
                            eight++;
                            board[4 - eight][j] = (turn.equals("red")) ? 1 : -1;
                            turn = (turn.equals("red")) ? "black" : "red";
                        }
                    }
                }
            }
        }
        addIcon();
        whoDisplay.setText( (turn.equals("black"))? "Yellow Players Turn" : "Red Players Turn");
        if (doesRedWin()){
            gameover = true;
            whoDisplay.setText("RED PLAYER VICTORY!!");
        }
        if (doesBlackWin()){
            gameover = true;
            whoDisplay.setText("YELLOW PLAYER VICTORY!!");
        }
    }

    public void addIcon() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == -1) {
                    gb[i][j].setForeground(new Color( 255,255, 0));
                    gb[i][j].setText("\u25CF");
                }
                if (board[i][j] == 0) {
                    gb[i][j].setForeground(new Color( 235,230, 220));
                    gb[i][j].setText("\u25CF");
                }
                if (board[i][j] == 1) {
                    gb[i][j].setForeground(Color.red);
                    gb[i][j].setText("\u25CF");
                }
            }
        }
    }

    public Boolean doesRedWin() {

        for (int j = 0; j < 8; j++) {
            int count = 0;
            for (int i = 0; i < 5; i++) {
                if (board[i][j] == 1) count++;
                if (count == 5) return true;
            }
        }
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 8; j++) {
                count = (board[i][j] == 1) ? count+1 : 0;
                if (count == 5) return true;
            }
        }
        for (int j = 0; j<4; j++){
            int count = 0, i = 0;
            while (i<5) {
                if (board[i][j] == 1) {
                    count++;
                    i++;
                    j++;
                } else break;
            }
            if (count == 5) return true;
        }
        for (int j = 0; j<4; j++){
            int count = 0, i = 4;
            while (i>=0) {
                if (board[i][j] == 1) {
                    count++;
                    i--;
                    j++;
                } else break;
            }
            if (count == 5) return true;
        }
        return false;
    }

    public Boolean doesBlackWin() {

        for (int j = 0; j < 8; j++) {
            int count = 0;
            for (int i = 0; i < 5; i++) {
                if (board[i][j] == -1) count++;
                if (count == 5) return true;
            }
        }
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 8; j++) {
                count = (board[i][j] == -1) ? count+1 : 0;
                if (count == 5) return true;
            }
        }
        for (int j = 0; j<4; j++){
            int count = 0, i = 0;
            while (i<5) {
                if (board[i][j] == -1) {
                    count++; i++; j++;
                } else break;
            } if (count == 5) return true;
        }
        for (int j = 0; j<4; j++){
            int count = 0, i = 4;
            while (i>=0) {
                if (board[i][j] == -1) {
                    count++; i--; j++;
                } else break;
            } if (count == 5) return true;
        }
        return false;
    }
}
