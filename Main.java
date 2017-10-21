public class Main {
    public static void main(String []args) {

        Model TicTacToeModel = new Model();
        View TicTacToeView = new View();
        //TicTacToeView.gui.setVisible(true);
        Controller TicTacToeCont = new Controller(TicTacToeModel,TicTacToeView);
    }
}
