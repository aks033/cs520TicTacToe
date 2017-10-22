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
		resetGame():


Flow:
Design Choice:
