package TicTacToe;

public class Main {
    public static void main(String []args) {
        View TicTacToeView = new View();
        Model TicTacToeModel = new Model(TicTacToeView);
        TicTacToe.Controller TicTacToeCont = new TicTacToe.Controller(TicTacToeModel);
    }
}
