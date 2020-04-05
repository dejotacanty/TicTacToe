
class TicTacToe


def self.generate_board
	(1..9).to_a
end

def self.print_board(elements)
	layer = "+" + " - +"*3
	puts layer
	print "|"
	(0..2).each{|i| print " #{elements[i]} |"} 
	puts ""
	puts layer
	print "|"
	(3..5).each{|i| print " #{elements[i]} |"} 
	puts ""
	puts layer
	print "|"
	(6..8).each{|i| print " #{elements[i]} |"} 
	puts ""
	puts layer
end

def self.contains_digit(hash)
	@truth = false	
	for i in (1..9)
		if (1..9).include? hash[i]
			@truth = true
		end
	end
	@truth
end

def self.player_turn(active_player,board)
	TicTacToe.print_board(board)
	puts "Choose a space!"
	@input = 10

	until ((1..9).include? @input) && (board.include? @input) do
	       	@input = (gets.chomp.to_i)
     end 
	
	board[@input - 1] = active_player.player	
end



def self.comp_turn(computer_player,board)
	until board.include? @comp_space do
	       	@comp_space = rand(1..9)
       	end
	board[@comp_space - 1] = computer_player.player
end



def self.find_potential_win(player, board)
	i = 0
	soace_arr = Array.new
	win_space
	board.each do |value|
		i+=1
		if value == player.player
			space_arr << value
		end
	end

	space_arr[0] = hgh:wq



	
end


def self.hard_comp(human,comp,board)
	first_player = rand(1..2)
	if first_player == 1 #human
		puts "#{human.player} goes first!"
		Store.player_turn(human,board)
		#comp turn
		if board[4] == human.player
			board[0] = comp.player
		else
			board[4] = comp.player
		end
		#end turn 2
	end


end

def self.end_game(winner,board)
	puts ""
	puts ""
	puts ""
	puts ""
	TicTacToe.print_board(board)
	puts "Play Again?[Yn]"
	x = gets.chomp.upcase!
		until "YN".include? x[0] do
		x = gets.chomp.upcase!
	end
	if x
		TicTacToe.new
	else
		abort("The winner is #{winner}") 
	end
end

def self.check_for_win(p,board)

	 @win = false
	 if board[0] == p && board[1] == p && board[2] == p
		@win = true
	end
	if(board[3] == p && board[4] == p && board[5] == p)
		@win = true
	end
	if(board[6] == p && board[7] == p && board[8] == p)
		@win = true
	end
	if(board[0] == p && board[3] == p && board[6] == p)
		@win = true
	end
	if(board[1] == p && board[4] == p && board[7] == p)
		@win = true
	end
	if(board[2] == p && board[5] == p && board[8] == p)
		@win = true
	end
	if(board[0] == p && board[4] == p && board[8] == p)
		@win = true
	end
	if(board[2] == p && board[4] == p && board[6] == p)
		@win = true
	end
	@win
end

def self.fill_board(human,computer,board)
	first_player = rand(1..2)
	if first_player == 2
		TicTacToe.player_turn(human,board)
	else
		TicTacToe.comp_turn(computer,board)
	end
	puts TicTacToe.contains_digit(board)
	i = 0
	if first_player == 2
		
		while i < 4
			TicTacToe.comp_turn(computer,board)
			TicTacToe.end_game(computer.player,board) if TicTacToe.check_for_win(computer.player,board) == true 

			TicTacToe.player_turn(human,board)
			TicTacToe.end_game(human.player,board) if TicTacToe.check_for_win(human.player,board) == true 
			puts TicTacToe.check_for_win(computer.player,board)
			i += 1
		end
	else
		while i < 4 
			TicTacToe.player_turn(human,board)
			TicTacToe.end_game(human.player,board) if TicTacToe.check_for_win(human.player,board) == true 

			TicTacToe.comp_turn(computer,board)
			TicTacToe.end_game(computer.player,board) if TicTacToe.check_for_win(computer.player,board) == true  

			i += 1
		end
	end
	board
end

def initialize
	
	person = Player.new("X")
	test_board = ["X", 2, "X", 4,5,6,7,8,9]
	TicTacToe.find_potential_win(person,test_board)
=begin
	board = TicTacToe.generate_board
	TicTacToe.print_board(board)
	puts "Choose X or O!"

	until @player == "X" || @player == "O" do 
		@player = gets.chomp.upcase! 
	end

	@player1 = Player.new(@player)

	if @player1.player == "X"
		@player2 = Player.new("O")
	else
		@player2 = Player.new("X")
	end
	
	TicTacToe.print_board(TicTacToe.fill_board(@player1,@player2,board))	
=end
end
end


class Player
	@player
	attr_writer :player
	attr_reader :player

	def initialize(xoro)
		@player = xoro
	end
end
TicTacToe.new
#puts "This is TicTacToe #{TicTacToe.new}"i
#@X = "Y"
#while "YN".include? @X do
#	@X =TicTacToe.new
#end
