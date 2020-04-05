
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

def self.player_turn(space,active_player)

	if (1..9).include? board[space] 
		board[space] = active_player.player
	end
end

def self.fill_board(human,computer,board)
	first_player = rand(1..2) #1 is human, 2 is computer
	while contains_digit(board) == true
		if first_player == 1 || first_player == 2
			print_board(board)
			puts "Choose a space!"
			do @input = gets.chomp.to_i - 1 until ((0..8).include? @input) && (board.include? @input) end
			 player_turn(@input ,@player1)
		#AI turn
			 do @comp_space = rand(0..8) until board.include? @comp_space end
			 player_turn(@comp_space,@player2)
		end
	end
	board = generate_board
	print_board(board)
	puts "Choose X or O!"
	@player1 = Player.new("X")

	if @player1.player == "X"
		@player2 = Player.new("O")
	else
		@player2 = Player.new("X")
	end
	@input = 0
	first_player = rand(1..2)	
	while contains_digit(board) == true
		if first_player == 1 #Human
			print_board(board)
			puts "Choose a space!"
			player_turn( gets.chomp.to_i - 1,@player1)
			
		

		
	end
		
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


