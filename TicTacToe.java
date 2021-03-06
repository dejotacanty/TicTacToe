import java.util.*;

//This command line Tic-Tac-Toe game was written by DJ Canty
//
//In 11 grade I made the first draft of this code for my intro to Java class
//We were required to just make a 2 player Tic-Tac-Toe game
//I had previous knowledge with the language and created a easy and hard bot, as you'll see below
//The hard bot was unbeatable, which I was very proud of
//After I graduated highschool the code was lost 
//
//This is the recreated and improved code
//Remade 3 years later
//Completed, compiled, tested, and fully documented on Jan 1st, 2020
//You could say I started the decade off on the right note!
//
//Any feedback is appreciated

public class TicTacToe{

String[] board;
String p1;
String p2;
int lastHumanMove;

public TicTacToe(){
	//The constructor is the shell behind the whole game
	//
	//Sets lastHumanMove and Populates the game board
	lastHumanMove = -1;
	board = new String[]{"1","2","3","4","5","6","7","8","9"};
	
	System.out.println("Welcome to Tic-Tac-Toe!");
	//System.out.print("Choose your fighter! X or O: ");
	boolean truth = true;

	//human input to choose player letter
	do {
		System.out.println();
		System.out.print("Choose your fighter! X or O: ");


		Scanner xoro = new Scanner(System.in);
		p1 = xoro.nextLine();
		p1 = p1.toUpperCase();
		System.out.println("You Chose: " + p1);
	
		this.pause();

	}while(!p1.trim().equals("X") && !p1.trim().equals("O"));
	//Sets bot player
	if(p1.equals("X")){
		p2 = "0";
	}else{
		p2 = "X";
	}
	
	String easy_or_hard_input = new String();

	//User input to choose game mode
	do{

		System.out.println("Choose your difficuly:");
		System.out.print("Easy or Hard? ");
	
		Scanner eorh = new Scanner(System.in);
		easy_or_hard_input = eorh.nextLine();
		easy_or_hard_input = easy_or_hard_input.trim().toLowerCase();

	}while(!easy_or_hard_input.equals("easy") && !easy_or_hard_input.equals("hard"));

	//Begins the game on selected difficulty
	//and displays whether the human player wins, loses, or draws
	//
	//Easy Mode:
	if(easy_or_hard_input.equals("easy")){
		switch(this.easyMode()){
			case 1:
				this.printBoard();
				System.out.println("You win!!!");
				break;
			case 2:
				this.printBoard();
				System.out.println("You lost to the easy bot ;-; how??");
				break;
			default:
				this.printBoard();
				System.out.println("It's a draw!");
		}
	
	}else{
		//Hard Mode:
		switch(this.hardMode()){
			case 1:
				this.printBoard();
				System.out.println("You win!!!");
				break;	
			case 2:
				this.printBoard();
				System.out.println("You lost :(");
				break;
			default:
				this.printBoard();
				System.out.println("It's a draw!");
		}
	}

}//end constructor

public static void main(String[] args){

	TicTacToe billybobjoe = new TicTacToe();

}

///////////////////////////////////////////////////////////
///////////////BEGIN EASY MODE METHODS/////////////////////
///////////////////////////////////////////////////////////

public int easyMode(){
	//Handles the easy mode turn order	
	Random rand = new Random();
	int first = rand.nextInt();
	boolean has_a_player_won = false;

	if(first % 2 ==1){
		System.out.println("Bot goes first!");
		has_a_player_won = this.botEasyTurn();
	}else{
		System.out.println("You go first!");
		has_a_player_won = this.easyTurn();
	}
	
	this.pause();
		
	for(int i=0;i<4;i++){
		
		if(!has_a_player_won){	
			if((first % 2) == 1 ){
				has_a_player_won = this.easyTurn();
			if(!has_a_player_won)
				has_a_player_won = this.botEasyTurn();	
			}else{
				has_a_player_won = this.botEasyTurn();					if(!has_a_player_won)
				has_a_player_won = this.easyTurn();
			}
		}
	}


	return this.winCondition();

}//end easyMode

public boolean easyTurn(){
	//Human input on Easy mode
	int input = 0;
	boolean board_updated = true;

	this.printBoard();
	do{
		System.out.println("Choose a space 1 - 9");
		Scanner space = new Scanner(System.in);
		input = this.getIntInput(space);


		if(input > 0 && input < 10){
			if(this.checkIfOccupied(board[input - 1]) == false){
				board[input - 1]=p1;
//				this.setLastHumanMove(input - 1); //Hard Mode Use Only
				board_updated = true;
			}else{
				board_updated = false;
			}
		}
	}while(!board_updated);

	return this.checkForWin(p1);
}//end easyTurn

public boolean botEasyTurn(){
	//Handles the bot's turn on easy mode, its just a RNG
	Random rand = new Random();
	int randnum;
	boolean randnum_parameters;
	boolean check_if_occupied;
	do {
			randnum = rand.nextInt(9);
			randnum_parameters = board[randnum].equals(Integer.toString(randnum + 1)); 
			check_if_occupied = this.checkIfOccupied(board[randnum]);

			//System.out.println("Randnum parameters check: " + board[randnum] + "  : ToString   " + Integer.toString(randnum + 1));
			//System.out.println("Randnum_parameters: " + randnum_parameters + "   Check_if_occupied: " + check_if_occupied);
	}
	while(check_if_occupied);
	
	board[randnum] = p2;

	return this.checkForWin(p2);	
}//end botEasyTurn

/////////////////////////////////////////////////////////////////
//////**********END EASY MODE METHODS**********//////////////////
/////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////
/////////////BEGIN HARD MODE METHODS/////////////////////////////
/////////////////////////////////////////////////////////////////

public int hardMode(){
	//Handles starting the game on Hard Mode
	//
	//RNG to choose first player
	Random rand = new Random();
	int first = rand.nextInt();

	if(first<0)
		first *= -1;

	boolean has_a_player_won = false;

	this.pause();
	
	int turn_counter = 0;
	/*testing first = 1;*/

	//First turn is taken outside of the loop so that the loop can run an even amount of times
	if(first % 2 ==1){
		System.out.println("Bot goes first!");
		turn_counter += 1;
		has_a_player_won = this.botHardTurn(turn_counter, true);
	}else{
		System.out.println("You go first!");
		has_a_player_won = this.easyTurn();
	}

	//loops through the next 4 turns
	for(int i = 0;i<4;i++){
			
	turn_counter += 1;
	if(!has_a_player_won){
			if((first % 2) == 1 ){
				has_a_player_won = this.hardTurn();
				if(!has_a_player_won)
					has_a_player_won = this.botHardTurn(turn_counter, true);		
			}else{
				has_a_player_won = this.botHardTurn(turn_counter, false);			
				if(!has_a_player_won)
					has_a_player_won = this.hardTurn();
			}
		}
	}


	return this.winCondition();

}//end hardMode


public boolean hardTurn(){
	//Human input on Hard Mode
	int input = 0;
	
	this.printBoard();

	do{
		do{
			//handles input checking
			Scanner hard_scan = new Scanner(System.in);
			System.out.println("Choose a space 1 - 9");
			input = this.getIntInput(hard_scan);

		}while(input > 9 || input < 1);
	
	}while(this.checkIfOccupied(board[input -1])); 

	board[input -1] = p1;

	return this.checkForWin(p1);
}


public boolean botHardTurn(int turn, boolean first_player){

	ArrayList<Integer> ignore_arr = new ArrayList<Integer>();
	int move_space = -1;
	switch(turn){
		case 1:
			if (first_player == true){
				board[4] = p2;	
			}else if(first_player == false){
				System.out.println("is 5 occupied?: "+this.checkIfOccupied(board[4]));
				if(this.checkIfOccupied(board[4])){
					board[0] = p2;
				}else{
					board[4] = p2;
				}
			}
			break;
			//end turn 1
		case 2:
			if(first_player == true){
				if(this.cornerSpotTaken()){
					if(this.checkIfOccupied(board[0])){
						board[2] = p2;
					}else{
						board[0] = p2;
					}
					
					
				}/*end if*/else{
					if(this.checkIfOccupied(board[5]) == false){
						board[5] = p2;
				}else if(this.checkIfOccupied(board[1]) == false){
					board[1] = p2;
				}else{
					this.makeMove(-1);
				}
				}//end if
			}else if(first_player == false){

				if(board[4].equals(p2)){
					//if bot occupies center
					if(this.calcMove(p1,p2) != -1){
						this.makeMove(this.calcMove(p1,p2));	
					}else{
						this.makeMove(-1);
					}
				}else{//if bot does not occupy center
					if(this.checkForWinNextTurn(p1,new ArrayList<Integer>())==-1){	
						if(this.checkIfOccupied(board[1]) || this.checkIfOccupied(board[7])){
							board[3] = p2;
						}else{
							board[1] = p2;
						}	
					}else{
						this.makeMove(this.calcMove(p1,p2));
					}
				}	
			}//end turn 2
			break;

		case 3:
			if(first_player == true){
				if(this.calcMove(p2, p2) != -1){
					this.makeMove(this.calcMove(p2,p2));
				}else if(this.calcMove(p1,p2) != -1){
					this.makeMove(this.calcMove(p1,p2));	
				}else if(this.checkIfOccupied(board[2]) == false){
					board[2] = p2;					
				}else{
					this.makeMove(-1);
				}
			}else if(first_player == false){
				if(this.calcMove(p2, p2) != -1){
					this.makeMove(this.calcMove(p2,p2));
				}else if(this.calcMove(p1,p2) != -1){
					this.makeMove(this.calcMove(p1,p2));	
				}else{
					this.makeMove(-1);
				}
			}
			break;

		default:
	
			if(this.calcMove(p2, p2) != -1){
				this.makeMove(this.calcMove(p2,p2));
			}else if(this.calcMove(p1, p2) != -1){
				this.makeMove(this.calcMove(p1,p2));
			}else{
				this.makeMove(-1);	
			}
		}//end switch

	return this.checkForWin(p2);
}

/////////////////////////////////////////////////////////////////
/////+++++++++++BEGIN HELPER METHODS+++++++++++//////////////////
/////////////////////////////////////////////////////////////////
public void setLastHumanMove(int move){
	//Setter for lastHumanMove
	lastHumanMove = move;
}

public void printBoard(){
	//Prints the game board, hardcoded
	System.out.println();
	System.out.println("+ - + - + - +");
	System.out.println("| "+board[0]+" | "+board[1]+" | "+board[2]+" |");
	System.out.println("+ - + - + - +");
	System.out.println("| "+board[3]+" | "+board[4]+" | "+board[5]+" |");
	System.out.println("+ - + - + - +");
	System.out.println("| "+board[6]+" | "+board[7]+" | "+board[8]+" |");
	System.out.println("+ - + - + - +");
	System.out.println();
}//end printBoard

public int getIntInput(Scanner scan){
	//condensed scanner input for human player turns
	int input = 0;

	try{
		do{
			input = scan.nextInt();
		}
		while(input < 1 || input > 9);

	}catch(Exception e){
		//input = this.getIntInput(scan);
		System.out.println("");
	}
	
	return input;
}



public void makeMove(int space){
	//Takes a valid space as input
	//Error checking must be done before calling this method
	//sets the bot player on given space
	//if input is -1, a random space will be validated and chosen
	if(space == -1){

		boolean bubba = this.botEasyTurn();

	}else{
		board[space] = p2;
	}

}

public int calcMove(String player_to_look_for, String player_to_move){
	//This method calculates a move based off of given player positions
	//This method is only used by the bot, not the player
	
	//This method will look for any two consecutive, occupied spaces that match player_to_look_for
	//then if the wildcard space in the pattern is unoccupied, the method will return that space
	//if the space is occupied, -1 will be returned instead
	int move_space = -1;
	ArrayList<Integer> ignore_arr = new ArrayList<Integer>();
	boolean brk = true;
	do{
		if(ignore_arr.size()>9)
			ignore_arr.clear();
	System.out.println("CalcMove");	
		move_space = this.checkForWinNextTurn(player_to_look_for, ignore_arr);
		
		ignore_arr.add(move_space);
		if(move_space == -1)
			brk = false;

	}while(brk && this.checkIfOccupied(board[move_space]));
		ignore_arr.clear();
	return move_space;
}//end calcMove


public int lastHumanMove(){
	//Getter for lastHumanMove
	return lastHumanMove;
}

public boolean cornerSpotTaken(){
	//This method is used by the hard mode bot on turn 2 tomove optimally
	//returns true if all corners are unoccupied
	//returns false if any corners are occupied
	int[] corner_spots = new int[]{0,2,6,8};
	boolean spot_taken = false;

	for(int i = 0;i<4;i++){
		if(board[corner_spots[i]].equals(p1))
			spot_taken = true;
	}
	return spot_taken;
}//End cornerSpotTaken

public int winCondition(){
	//0 = draw, 1 = human won, 2 = bot won	
	//
	//Returns the Win status of the match to the constructor
	int win_mode = 0; 
	if(this.checkForWin(p1)){
		win_mode = 1;
	}else if(this.checkForWin(p2)){
		win_mode = 2;
	}

	return win_mode;
}//end WinCondition


public boolean checkForWin(String p){
	//Hardcoded method to check for any and all possible winning patterns
	//returns true if a matching pattern is found
	//
	boolean win = false;
	if(board[0].equals(p) && board[1].equals(p) && board[2].equals(p)){
		win = true;
	}//top row
	if(board[3].equals(p) && board[4].equals(p) && board[5].equals(p)){
		win = true;
	}//middle row
	if(board[6].equals(p) && board[7].equals(p) && board[8].equals(p)){
		win = true;
	}//bottom row
	if(board[0].equals(p) && board[3].equals(p) && board[6].equals(p)){
		win = true;
	}//left column
	if(board[1].equals(p) && board[4].equals(p) && board[7].equals(p)){
		win = true;
	}//middle column
	if(board[2].equals(p) && board[5].equals(p) && board[8].equals(p)){
		win = true;
	}//right column
	if(board[0].equals(p) && board[4].equals(p) && board[8].equals(p)){
		win = true;
	}//top left diagonal
	if(board[2].equals(p) && board[4].equals(p) && board[6].equals(p)){
		win = true;
	}//top right diagonal

	return win;
}//end checkForWin

public int ignoreIterator(ArrayList<Integer> ignore_arr, int num_to_test){
	//This method is used by checkForWinNextTurn to avoid returning redundant values so that this method can be run multiple times to account for occupied spaces
	//Its inputs are an arraylist of values to ignore, and a potential move to compare against thos values
	//if the num_to_test is found in the ignore array, the method returns -1, signaling checkForWinNextTurn to keep calculating
	//If the num_to_test is not found in the array, it is returned
	int num_to_return = -2;
	if(this.checkIfOccupied(board[num_to_test]))
		ignore_arr.add(num_to_test);

	for(int i = 0;i<ignore_arr.size();i++){
		
		if(ignore_arr.get(i) == num_to_test){
			num_to_return = -1;
		}

	}

	if (num_to_return == -2){
		num_to_return = num_to_test;
	}
	return num_to_return;
}//end ignoreIterator

public int checkForWinNextTurn(String p, ArrayList<Integer> ignore){
//This method makes me cringe...
//Is there some way to calculate these values?
//mathematical relationships do exist
//
//This method has all the hardcoded 2 space patterns that could lead to a win by the given player
//It takes a player and an arraylist of ignored values as input, the arraylist can be empty
//Since the last correct move is always returned & there can be multiple outcomes, ignore is used to skip over occupied spaces that do return a move
	int space_to_block = -1;

	if(board[0].equals(p) && board[1].equals(p))
		space_to_block = this.ignoreIterator(ignore, 2);

	if(board[0].equals(p) && board[2].equals(p))
		space_to_block = this.ignoreIterator(ignore, 1);

	if(board[1].equals(p) && board[2].equals(p))
		space_to_block = this.ignoreIterator(ignore, 0);
	
	if(board[3].equals(p) && board[4].equals(p))
		space_to_block = this.ignoreIterator(ignore, 5);

	if(board[3].equals(p) && board[5].equals(p))
		space_to_block = this.ignoreIterator(ignore, 4);

	if(board[4].equals(p) && board[5].equals(p))
		space_to_block = this.ignoreIterator(ignore, 3);

	if(board[6].equals(p) && board[7].equals(p))
		space_to_block = this.ignoreIterator(ignore, 8);

	if(board[6].equals(p) && board[8].equals(p))
		space_to_block = this.ignoreIterator(ignore, 7);

	if(board[7].equals(p) && board[8].equals(p))
		space_to_block = this.ignoreIterator(ignore, 6);

	if(board[0].equals(p) && board[3].equals(p))
		space_to_block = this.ignoreIterator(ignore, 6);

	if(board[0].equals(p) && board[6].equals(p))
		space_to_block = this.ignoreIterator(ignore, 3);

	if(board[3].equals(p) && board[6].equals(p))
		space_to_block = this.ignoreIterator(ignore, 0);

	if(board[1].equals(p) && board[4].equals(p))
		space_to_block = this.ignoreIterator(ignore, 7);

	if(board[1].equals(p) && board[7].equals(p))					space_to_block = this.ignoreIterator(ignore, 4);

	if(board[4].equals(p) && board[7].equals(p))
		space_to_block = this.ignoreIterator(ignore, 1);

	if(board[2].equals(p) && board[5].equals(p))
		space_to_block = this.ignoreIterator(ignore, 8);

	if(board[2].equals(p) && board[8].equals(p))
		space_to_block = this.ignoreIterator(ignore, 5);

	if(board[5].equals(p) && board[8].equals(p))
		space_to_block = this.ignoreIterator(ignore, 2);

	if(board[0].equals(p) && board[4].equals(p))
		space_to_block = this.ignoreIterator(ignore, 8);

	if(board[0].equals(p) && board[8].equals(p))
		space_to_block = this.ignoreIterator(ignore, 4);

	if(board[4].equals(p) && board[8].equals(p))
		space_to_block = this.ignoreIterator(ignore, 0);

	if(board[2].equals(p) && board[4].equals(p))
		space_to_block = this.ignoreIterator(ignore, 6);

	if(board[2].equals(p) && board[6].equals(p))
		space_to_block = this.ignoreIterator(ignore, 4);

	if(board[4].equals(p) && board[6].equals(p))
		space_to_block = this.ignoreIterator(ignore, 2);


	return space_to_block;
}//end checkForWinNextTurn


public boolean checkIfOccupied(String board_space){
	//Critcal method that checks if a space is occupied by either player
	return board_space.equals(p1) || board_space.equals(p2);

}//end checkIfOccupied


public void pause(){
	//simply to avoid repeating this code several times
	try{
	Thread.sleep(1000);	
	}catch(Exception e){}
}//end pause
}//end TicTacToe class
