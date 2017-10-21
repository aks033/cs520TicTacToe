public class Main {
    public static void main(String []args) {
        View TicTacToeView = new View();
        Model TicTacToeModel = new Model(TicTacToeView);
        Controller TicTacToeCont = new Controller(TicTacToeModel);
    }
}
