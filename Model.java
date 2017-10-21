public class Model {

    public int turnsLeft;
    public String userSymbol;
    public int player;

    public Model() {
        turnsLeft = 9;
        userSymbol = "X";
        player = 1;
    }

    public void setSymbol(){
        if (turnsLeft%2 == 1){
            userSymbol = "X";
            player = 1;
        }
        else{
            userSymbol = "O";
            player = 2;
        }
    }

    public void decrementTurnsLeft(){
        turnsLeft--;
    }
}
