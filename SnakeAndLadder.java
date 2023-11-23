package snakeLadder;

import java.util.Random;


public class SnakeAndLadder {
	    private static final int INITIAL_POSITION=0;
	    private static final int BOARD_SIZE = 100;
	    private static final int NUM_SNAKES = 5;
	    private static final int NUM_LADDERS = 5;

	    private int playerPosition;

	    private int[] snakes;
	    private int[] ladders;

	    public SnakeAndLadder() {
	        this.playerPosition = 0;
	        this.snakes = new int[NUM_SNAKES];
	        this.ladders = new int[NUM_LADDERS];
	        initializeBoard();
	    }
	    
	    
		/*
		 * @params:none
		 * @return:none
		 * @desc:prints the initial position
		 */	
	    private void initializeBoard() {
	        for (int i = 0; i < NUM_SNAKES; i++) {
	            snakes[i] = getRandomPosition();
	        }

	        for (int i = 0; i < NUM_LADDERS; i++) {
	            ladders[i] = getRandomPosition();
	        }
	    }
        
	    
	    /*
		 * @params:none
		 * @return:integer
		 * @desc:random position for player
		 */
	    private int getRandomPosition() {
	        Random random = new Random();
	        return random.nextInt(BOARD_SIZE - 1) + 1; // Avoid placing snakes and ladders on position 0
	    }
        
	    
		/*
		 * @params:none
		 * @return:integer
		 * @desc:gives a random dice number from 1 to 6
		 */
	    private int rollDice() {
	        Random random = new Random();
	        return random.nextInt(6) + 1;
	    }
        
	    
		/*
		 * @params:none
		 * @return:integer
		 * @desc:gives a option 0 for No Play, 1 for Ladder, 2 for Snake
		 */
	    private int getOption() {
	        Random random = new Random();
	        return random.nextInt(3); 
	    }
	    
	    
	    /*
		 * @params:none
		 * @return:none
		 * @desc:moves the player  0 for No Play, 1 for Ladder, 2 for Snake
		 */
	    private void movePlayer(int steps, int option) {
	        int newPosition = playerPosition;

	        switch (option) {
	            case 0:
	                System.out.println("No Play! Player stays in the same position.");
	                break;
	            case 1:
	                newPosition += steps;
	                System.out.println("Yay! Ladder! Player moves ahead by " + steps + " positions.");
	                break;
	            case 2:
	                newPosition -= steps;
	                System.out.println("Oops! Snake! Player moves behind by " + steps + " positions.");
	                break;
	        }

	        // Check for snakes and ladders
	        for (int snake : snakes) {
	            if (newPosition == snake) {
	                System.out.println("Oops! Snake at position " + snake + ". Go back.");
	                newPosition -= 10; // Go back by 10 positions
	            }
	        }

	        for (int ladder : ladders) {
	            if (newPosition == ladder) {
	                System.out.println("Yay! Ladder at position " + ladder + ". Go forward.");
	                newPosition += 10; // Go forward by 10 positions
	            }
	        }

	        if (newPosition >= 0 && newPosition <= BOARD_SIZE) {
	            playerPosition = newPosition;
	        }
	    }

 
	    
		/*
		 * @params:none
		 * @return:boolean
		 * @desc:final function which tells us when the player has won
		 */	
	    private boolean isGameWon() {
	        return playerPosition == BOARD_SIZE;
	    }
        
	    
	    
		/*
		 * @params:none
		 * @return:none
		 * @desc:player playing the game
		 */	
	    public void playGame() {
	        int turns = 0;

	        while (!isGameWon()) {
	            int diceResult = rollDice();
	            System.out.println("Rolling the dice... You rolled a " + diceResult);

	            int option = getOption();
	            movePlayer(diceResult, option);

	            System.out.println("Current position: " + playerPosition);

	            turns++;
	        }
	        System.out.println("Congratulations! You won in " + turns + " turns.");
	    }
	    
		/*
		 * @params:none
		 * @return:integer
		 * @desc:returns the current position of the player
		 */	
	    public int getPlayerPosition() {
	        return playerPosition;
	    }
	    
	    
		/*
		 * @params:none
		 * @return:none
		 * @desc:prints the player move
		 */	
	    public static void main(String[] args) {
	        SnakeAndLadder game = new SnakeAndLadder();
	        System.out.println("Welcome to Snake and Ladder Game!");
	        game.playGame();
	    }
	    
	}
