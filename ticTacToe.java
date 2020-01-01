import java.util.*;


public class TicTacToe{

String[] board;
String p1;
String p2;

public TicTacToe(){
board = new String[]{"1","2","3","4","5","6","7","8","9"};
System.out.println("Welcome to Tic-Tac-Toe!");
System.out.print("Choose your fighter! X or O: ");
boolean truth = true;
while(truth){
Scanner xoro = new Scanner("System.in");
p1 = xoro.nextLine();
if(p1.equals("X") || p1.equals("O")){

truth = false;
}	
}

if(p1.equals("X")){
	p2 = "0";
}else{
	p2 = "X";
}

truth = true;
System.out.println("Choose your difficuly!");
System.out.print("Easy or Hard?");
while(truth){
Scanner eorh = new Scanner("System.in");

if(eorh.nextLine().toLowerCase().equals("easy")){
if(this.easyMode() ==true){
	System.out.println("YOU WON!!! Congratulations!");
}else{
	System.out.println("You lost to the easy bot ;-; how??");
}
truth = false;
}else{
if(this.hardMode() ==true){
	System.out.println("YOU WON!!! Congratulations!");
}else{
	System.out.println("You lost :(");
}
}
}
}//end constructor


public void printBoard(){
	System.out.println("+ - + - + - +");
	System.out.println("| "+board[0]+" | "+board[1]+" | "+board[2]+" |");
	System.out.println("+ - + - + - +");
	System.out.println("| "+board[3]+" | "+board[4]+" | "+board[5]+" |");
	System.out.println("+ - + - + - +");
	System.out.println("| "+board[6]+" | "+board[7]+" | "+board[8]+" |");
	System.out.println("+ - + - + - +");
}//end printBoard

public boolean easyMode(){
	Random rand = new Random();
	int first = rand.nextInt();
	int turns = 0;
	while(turns<4){
		this.printBoard();
	if(first== 1){
		this.easyTurn();
		if(turns <1)
			this.checkForWin(p1);
		this.botEasyTurn();
		if(turns < 1)
			this.checkForWin(p2);
	}else{
		this.botEasyTurn();
		if(turns<1)
			this.checkForWin(p2);
		this.easyTurn();
		if(turns <1)
			this.checkForWin(p1);
	}
	}

	
}//end easyMode
public void easyTurn(){
	int input;
	System.out.println("Choose a space 1 - 9");
	while(input >9 && input < 1){
		Scanner space = new Scanner("System.in");
		input = space.nextInt();
		if(input>1 && input<9 && !(board[input - 1].equals(p1))&&!board[input-1].equals(p2)){
			board[input - 1]=p1;
		}	
	}
}//end easyTurn

public void botEasyTurn(){
Random rand = new Random();
int randnum = rand.nextInt(8);
while(board[input - 1].equals(randnum) && board[input - 1].equals(randnum)){
	randnum = rand.nextInt(8);
}
board[randnum] = p2; 
}//end botEasyTurn

public boolean checkForWin(String p){
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

}//end checkForWin
}//end Class
