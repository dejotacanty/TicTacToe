import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math.*;
import java.util.*;

//
//LAST ThING TO DO:
//After the game is finished, remove the southLabel and replace it with a 'Play Again?' button
public class TicGUI extends TicTacToe{
  
  
  JFrame window;
  JPanel gameBoard;
  JPanel controls;
  String difficulty;
  final int FRAME_WIDTH, FRAME_HEIGHT;
  
  static String p1;
  static String p2;
  
  //Pregame components
  JPanel pregamePanel;
  JPanel pregameSubPanel;
  JLabel pregameTextLabel;
  JLabel pregameButtonLabel;
  JTextField pregameTextField;
  JButton pregameButtonEasy;
  JButton pregameButtonHard;
  
  
  
  
  JPanel[] panelArray;
  JTextField[] textFieldArray;
  static JButton[] buttonArray;
  
  JPanel northPanel;
  JLabel northLabel;
  JPanel southPanel;
  JLabel southLabel;
  
  //TicTacToe Board Panels
  JPanel topLeftPanel;
  JPanel topMiddlePanel;
  JPanel topRightPanel;
  JPanel middleLeftPanel;
  JPanel middleMiddlePanel;
  JPanel middleRightPanel;
  JPanel bottomLeftPanel;
  JPanel bottomMiddlePanel;
  JPanel bottomRightPanel;
  

  JTextField topLeft;
  JTextField topMiddle;
  JTextField topRight;
  JTextField middleLeft;
  JTextField middleMiddle;
  JTextField middleRight;
  JTextField bottomLeft;
  JTextField bottomMiddle;
  JTextField bottomRight;
  
  JButton topLeftButton;
  JButton topMiddleButton;
  JButton topRightButton;
  JButton middleLeftButton;
  JButton middleMiddleButton;
  JButton middleRightButton;
  JButton bottomLeftButton;
  JButton bottomMiddleButton;
  JButton bottomRightButton;
  //End Board Panels
  
  
  
  //CONSTRUCTOR//
  public TicGUI(){
    
    p1 = "";
    p2 = "";
    
    window = new JFrame("Boi");
    
    FRAME_WIDTH = 300;
    FRAME_HEIGHT = 300;
    window.setLayout(new BorderLayout());
    
    panelArray = new JPanel[9];
    textFieldArray = new JTextField[9];
    buttonArray = new JButton[9];
    
    this.initializePanelElements();
    this.createElementArrays();
    this.initializePregameDisplay();
    
    this.buildBoard();
  }
  
  
  
  //Adds necessary components to build the Frame
  public void buildBoard(){
      
    window.setSize(FRAME_WIDTH,FRAME_HEIGHT);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
    
  }
  
  public void createElementArrays(){
    panelArray[0] = topLeftPanel;
    panelArray[1] = topMiddlePanel;
    panelArray[2] = topRightPanel;
    panelArray[3] = middleLeftPanel;
    panelArray[4] = middleMiddlePanel;
    panelArray[5] = middleRightPanel;
    panelArray[6] = bottomLeftPanel;
    panelArray[7] = bottomMiddlePanel;
    panelArray[8] = bottomRightPanel;
    
    textFieldArray[0] = topLeft;
    textFieldArray[1] = topMiddle;
    textFieldArray[2] = topRight;
    textFieldArray[3] = middleLeft;
    textFieldArray[4] = middleMiddle;
    textFieldArray[5] = middleRight;
    textFieldArray[6] = bottomLeft;
    textFieldArray[7] = bottomMiddle;
    textFieldArray[8] = bottomRight;
    
    buttonArray[0] = topLeftButton;
    buttonArray[1] = topMiddleButton;
    buttonArray[2] = topRightButton;
    buttonArray[3] = middleLeftButton;
    buttonArray[4] = middleMiddleButton;
    buttonArray[5] = middleRightButton;
    buttonArray[6] = bottomLeftButton;
    buttonArray[7] = bottomMiddleButton;
    buttonArray[8] = bottomRightButton;

  }
  
  public void initializePanelElements(){

    
    topLeftPanel = new JPanel();
    topMiddlePanel = new JPanel();
    topRightPanel = new JPanel();
    middleLeftPanel = new JPanel();
    middleMiddlePanel = new JPanel();
    middleRightPanel = new JPanel();
    bottomLeftPanel = new JPanel();
    bottomMiddlePanel = new JPanel();
    bottomRightPanel = new JPanel();
    
    topLeft = new JTextField(1);
    topMiddle = new JTextField(1);
    topRight = new JTextField(1);
    middleLeft = new JTextField(1);
    middleMiddle = new JTextField(1);
    middleRight = new JTextField(1);
    bottomLeft = new JTextField(1);
    bottomMiddle = new JTextField(1);
    bottomRight = new JTextField(1);
    
    topLeftButton = new JButton();
    topMiddleButton = new JButton();
    topRightButton = new JButton();
    middleLeftButton = new JButton();
    middleMiddleButton = new JButton();
    middleRightButton = new JButton();
    bottomLeftButton = new JButton();
    bottomMiddleButton = new JButton();
    bottomRightButton = new JButton();
  }
  
  public void initializePregameDisplay(){
    
    northPanel = new JPanel();
    northLabel = new JLabel("Doggo");
    northPanel.add(northLabel);
    
    southPanel = new JPanel();
    southLabel = new JLabel("Welcome to TicTacToe!");
    southPanel.add(southLabel);
    
    pregamePanel = new JPanel();
    pregameSubPanel = new JPanel();
    pregamePanel.setLayout(new GridLayout(4,1));
    pregameTextLabel = new JLabel("Do you want to play as X or O?");
    pregameTextField = new JTextField();
    pregameButtonLabel = new JLabel("Choose your difficulty");
    pregameButtonEasy = new JButton("Easy");
    pregameButtonHard = new JButton("Hard");
    
    pregameButtonEasy.addActionListener(new PregameListener());
    pregameButtonHard.addActionListener(new PregameListener());
    
    pregamePanel.add(pregameTextLabel);
    pregamePanel.add(pregameTextField);
    pregamePanel.add(pregameButtonLabel);
    pregameSubPanel.add(pregameButtonEasy);
    pregameSubPanel.add(pregameButtonHard);
    pregamePanel.add(pregameSubPanel);                       
    
    window.add(northPanel, BorderLayout.NORTH);
    window.add(pregamePanel, BorderLayout.CENTER);
    window.add(southPanel, BorderLayout.SOUTH);
  }
  
  //Adds display elements to the frame
  public void populateFrame(){
        
    gameBoard = new JPanel();
    gameBoard.setLayout(new GridLayout(3,3));
    controls = new JPanel();
    
    for(int i = 0; i< 9; i++){
      textFieldArray[i].setEditable(true);
      textFieldArray[i].setFont(textFieldArray[i].getFont().deriveFont(60f));
      textFieldArray[i].setHorizontalAlignment(JTextField.CENTER);
      
      buttonArray[i].setActionCommand(Integer.toString(i));
      buttonArray[i].addActionListener(new ButtonListener());
      panelArray[i].add(buttonArray[i]);
      gameBoard.add(buttonArray[i]);
    }
    

    window.add(gameBoard, BorderLayout.CENTER);
    window.repaint();
  }
  
  public static void main(String[] args){
   
    TicGUI ticTacToe = new TicGUI();
    
  }
  
  public int getFrameWidth(){
    return FRAME_WIDTH;
  }
  
  public int getFrameHeight(){
    return FRAME_HEIGHT;
  }
  
  //Make a layout of nine buttons that are visible
  //And nine lables that are invisible
  //When a button (board space) is clicked, the button becomes hidden
  //The button is set to the player's letter that clicked it, then the button becomes visible
  
  private class PregameListener implements ActionListener {
    
    public void actionPerformed(ActionEvent e ){
      
      String playerChoice = pregameTextField.getText();
      playerChoice = playerChoice.trim().toUpperCase();
      //System.out.println("PLayer Choice = " + playerChoice);
      if(playerChoice.length() == 1){
        switch(playerChoice){
          case "X":
            if(e.getActionCommand().equals("Easy")){
              difficulty = "easy";
            }else{
              difficulty = "hard";
            }
            p1 = "X";
            TicGUI.p2 = "O";
            break;
          
          case "O":
            if(e.getActionCommand().equals("Easy")){
              difficulty = "easy";
            }else{
              difficulty = "hard";
            }
            TicGUI.p1 = "O";
            TicGUI.p2 = "X";
            break;
          
        }
        
        
        window.remove(pregamePanel);
        TicGUI.this.northLabel.setText("Welcome to TicTacToe");
        window.repaint();
        TicGUI.this.populateFrame();
      }
    }
  }
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed(ActionEvent e){
      System.out.println("Check for win: " + TicGUI.this.checkForWin(p1));
      boolean humanPlayerWon = false;
      if(this.playerTurn(e)){
        this.gameWon(true);
        humanPlayerWon = true;
      }

        TicGUI.this.pause(); //Only for the suspense tbh
        
        if(humanPlayerWon == false && this.easyBotTurn()){
          this.gameWon(false);
        }
        TicGUI.this.printBoard();
        window.repaint();
        
      }
    
    public boolean playerTurn(ActionEvent e){
            
      System.out.println(e.getActionCommand());
      
      try{
        for(int i = 0;i < 9; i++){ 
          if(Integer.parseInt(e.getActionCommand()) == i){
           // System.out.println("int i euals " + i);
           //System.out.println("iplayer 1 equals " + p1);
            
           // System.out.println("player 2 equals " + TicGUI.p1);
            
            
            if(TicGUI.this.checkIfOccupied(Integer.toString(i)) == false){
              TicGUI.this.board[i] = p1;
              buttonArray[i].setText(p1);
              buttonArray[i].setEnabled(false);
            //  System.out.println("Num of action listeners for button " + i + "equals " + buttonArray[i].getActionListeners().length);
              //cGUI.this.southLabel.setText("Bot Player is thinking...");
              
              //TicGUI now extends from TicTacToe
              //You will have to partially rebuild the bot turns within this method (or make other methods)
              //Since you can't use the loops from the original class
              //actions must react from button presses, validation must occur here
            }
          }
        }
        }catch(Exception ex){
          ex.printStackTrace();
          System.exit(1);
        }
        
        return TicGUI.this.checkForWin(p1);
    }
    public boolean easyBotTurn(){
      
      Random rand = new Random();
      int randnum;
      boolean randnum_parameters;
      boolean check_if_occupied;
      
      do {
        randnum = rand.nextInt(9);
        randnum_parameters = TicGUI.this.board[randnum].equals(Integer.toString(randnum + 1)); 
        check_if_occupied = this.checkIfOccupied(board[randnum]);
        
       // System.out.println("Randnum parameters check: " + board[randnum] + "  : ToString   " + Integer.toString(randnum + 1));
      //  System.out.println("Randnum_parameters: " + randnum_parameters + "   Check_if_occupied: " + check_if_occupied);
      }while(check_if_occupied);
      
      board[randnum] = p2;
      
      buttonArray[randnum].setText(p2);
      buttonArray[randnum].setEnabled(false);
      TicGUI.this.southLabel.setText("Your turn");
      window.repaint();
      
      return TicGUI.this.checkForWin(p2); 
      
    }
    
    public boolean checkIfOccupied(String board_space){
      //Critcal method that checks if a space is occupied by either player
      
     // System.out.println("player 1  = " + p1 + "    player 2 = " + p2);
      return board_space.equals(p1) || board_space.equals(p2);
      
      
    }//end checkIfOccupied

    //True means player won, false means bot won
    public void gameWon(boolean val){
      if(val == true){
        TicGUI.this.northLabel.setText("You Win!");
        System.out.println("This works right?");
        window.repaint();
      }else{
        TicGUI.this.northLabel.setText("Bot Wins!");
      }
     System.out.println("This is the endgame, right?");
      for(int i = 0;i < 9;i++){
        TicGUI.buttonArray[i].setEnabled(false);
        
      }
      
      window.repaint();


    }
  }
    
  }