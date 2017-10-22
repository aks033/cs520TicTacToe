package TicTacToe;

import junit.framework.TestCase;

import java.util.Objects;

public class ControllerTest extends TestCase {
    public void testResetGame() throws Exception {
        TicTacToe.View view = new TicTacToe.View();
        TicTacToe.Model model = new TicTacToe.Model(view);
        boolean reset_check = true;
        //boolean false_flag = reset_check;
        TicTacToe.Controller controller = new TicTacToe.Controller(model);
        controller.model.getResetButton().doClick();
        if(controller.model.getResetButton().isEnabled()){
            for(int row=0;row<3;row++){
                for(int col=0;col<3;col++){
                    reset_check = Objects.equals(controller.buttons[row][col].getText(), "");
                    if (!reset_check){
                        reset_check = false;
                    }
                }


            }
        }
        assertEquals(true,reset_check);
    }

}