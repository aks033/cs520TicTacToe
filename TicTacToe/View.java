package TicTacToe;

import javax.swing.*;
import java.awt.*;


final class View implements ViewInterface{

    JButton[][] blocks = new JButton[3][3];// Buttons to play the game
    JButton reset = new JButton("Reset");// Button to reset the game
    JTextArea playerturn= new JTextArea();// To display text on the grid

    /**
     * View Class constructor which sets the basic Graphical user interface of the game using swing. It creates the
     * basic grid and  buttons for the game and also sets the initial message to be displayed on the board.
     */
    View(){
        JFrame gui = new JFrame("Tic Tac Toe");
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gui.setSize(new Dimension(500, 350));
        gui.setResizable(true);

        JPanel gamePanel = new JPanel(new FlowLayout());
        JPanel game = new JPanel(new GridLayout(3,3));
        gamePanel.add(game, BorderLayout.CENTER);

        JPanel options = new JPanel(new FlowLayout());
        options.add(reset);
        JPanel messages = new JPanel(new FlowLayout());
        messages.setBackground(Color.white);

        gui.add(gamePanel, BorderLayout.NORTH);
        gui.add(options, BorderLayout.CENTER);
        gui.add(messages, BorderLayout.SOUTH);

        messages.add(playerturn);
        playerturn.setText("Player 1 to play X");

        for(int row = 0; row<3 ;row++) {
            for(int column = 0; column<3 ;column++) {
                blocks[row][column] = new JButton();
                blocks[row][column].setPreferredSize(new Dimension(75,75));
                blocks[row][column].setText("");
                game.add(blocks[row][column]);
            }
        }
        gui.setVisible(true);

    }

    /**
     * This method sets the message to be displayed on the game board based on the player turn and also the final results
     * @param message: message to be displayed on the board
     */

    public void setPlayerTurn(String message) {
            playerturn.setText(message);

    }
}