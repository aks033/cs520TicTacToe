import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
        View view;
        Model model;

    public Controller( Model model, View view)
    {
        this.model = model;
        this.view = view;
        addActionListeners();
    }

    private void addActionListeners() {

        for(int row = 0; row<3 ;row++) {
            for(int column = 0; column<3 ;column++)
                view.blocks[row][column].addActionListener(this);
        }

        view.reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.setSymbol();
        model.decrementTurnsLeft();
        if(model.turnsLeft%2 == 1) {
            view.playerturn.setText("'X': Player 1");
        } else{
            view.playerturn.setText("'O': Player 2");
        }
        ((JButton)e.getSource()).setText(model.userSymbol);
        ((JButton)e.getSource()).setEnabled(false);
        if (diagonalCheck() || columnCheck()){
            view.playerturn.setText("Player "+model.player + " wins");
            disableButtons();
        }
        else if(model.turnsLeft==0){
            view.playerturn.setText("DRAW");
        }
    }


    public boolean diagonalCheck(){
        if (view.blocks[0][0].getText() == view.blocks[1][1].getText() &&
                view.blocks[1][1].getText() == view.blocks[2][2].getText() &&
                view.blocks[0][0].getText()  != "")
            return(true);

        if (view.blocks[2][0].getText() == view.blocks[1][1].getText() &&
                view.blocks[1][1].getText() == view.blocks[0][2].getText() &&
                view.blocks[2][0].getText()  != "")
            return(true);
        return(false);
    }

    public boolean columnCheck(){
            for (int i=0; i<3; i++)
            {
                if (view.blocks[0][i].getText() == view.blocks[1][i].getText() &&
                        view.blocks[1][i].getText() == view.blocks[2][i].getText() &&
                        view.blocks[0][i].getText() != "")
                    return (true);
                if (view.blocks[i][0].getText() == view.blocks[i][1].getText()&&
                        view.blocks[i][1].getText() == view.blocks[i][2].getText() &&
                        view.blocks[i][0].getText() != "")
                    return (true);
            }
            return(false);
    }

    void disableButtons(){
        for(int i = 0;i<3;i++) {
            for(int j = 0;j<3;j++) {
                view.blocks[i][j].setEnabled(false);
            }
        }
    }

    public void resetGame() {
        for(int row = 0;row<3;row++) {
            for(int column = 0;column<3;column++) {
                view.blocks[row][column].setText("");
                view.blocks[row][column].setEnabled(true);
            }
        }
        model.player = 1;
        model.turnsLeft = 9;
        view.playerturn.setText("Player 1 to play 'X'");
    }
}
