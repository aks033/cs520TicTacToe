Design:

Implemented a MVC design pattern to realize a Tic Tac Toe game model.
	-The Model stores the information like the current player, number of turns left, the symbol for the current player. The model interacts with the view for the exchange of data.
	-View controls the GUI of the game. It contains all the buttons required to play the game and also makes the game more interactive.
	-Controller will translate the user interaction, with the help of action-listeners, to modify the data in the model. The logic of the game resides in this class.

Components:

	Classes: There are 4 classes i.e Model, View, Controller and Main which is the driver class.

		View: The view sets the GUI framework in the constructor and set the texts to initial value. It also contains the following method

			setPlayerTurn(String message): it implements the functionality of setting the text on the board to make the game more interactive.

		Model: Initializes the player to player 1 and the corresponding symbol to "X", and the turnsLeft variable to 9. It has the following methods.

			setSymbolPlayer(): This method changes the user symbol based on the player turn.
			decrementTurnsLeft(): Decrements the number of turns left in the game.
			getButtonsMatrix(): Method to get the access to the play buttons on the grid.
			getResetButton(): Method to get the reset button on the grid.
			setTurnText(String message): To interact with the view to modify the text on the grid according to player number.

		Controller: Controller mediates the user interaction by changing the model and the model in turn changing the view.
            addActionListeners(): Attaches action listener to each play button and the reset button.
            actionPerformed(ActionEvent e): This method contains the logic of the game. It checks for the win by diagonal and column/row checks and accordingly changes the model and in turn the view.
            diagonalCheck(): This method checks if there are same characters on either of the diagonals and returns a boolean accordingly.
            columnRowCheck(): This method checks the columns and rows for same characters and accordingly return a boolean.
            disableButtons(): This method disables the buttons which can happen in two events i.e either any of the players have won or the game ended in a draw.
            resetGame(): Resets the buttons and other conditions like player, number of turns etc to their initial state. This is called on the click of the reset button.

Code Flow:
    - View creates the grid and buttons of the GUI.
    -For every click on the button, the actionListener attached to the button calls its actionPerformed method to check the diagonals, columns and rows for any win.
        - If there is no win, then the game continues until someone wins or the match ends in a draw. The model gets updated with the information of the next player and the number of turns decreases by 1.
           accordingly the model informs the view to change the text on the GUI to show that its the next players turn.
        - If there is a win, the buttons get disabled and the board shows the message to show the player who has won.
        - If the match ends in a draw, the buttons get disabled and the text field says that the match ended in a draw situation.
    -The reset button functionality when pressed resets the entire board to start a new match. This method has been implemented in the controller class and it resets all the information in the model and in turn clears the view.

Design Choice:
Model:
- All the data pertaining to the game resides in the model.
- Model class interacts with the view to update it when there is a reset/win condition and also when the player turn changes.
Controller:
- Implemented the actionListener int the controller which accesses the buttons through the model class. The reason behind this choice was that the controller is not directly accessing the buttons and putting the actionListener in the view would violate the MVC principles as the view should just modify the display.
- Implemented the reset functionality in the controller as reset is a control function which modifies the model and hence the view.
View:
View only deals with the contents to be displayed on the board.
