package snakeLadder;

import java.util.Random;


public class SnakeAndLadder {
	static final int INITIAL_POSITION=0;
	static final int BOARD_SIZE = 100;
    private static final int NUM_SNAKES = 5;
    private static final int NUM_LADDERS = 5;
    private int playerPosition;
    private int[] snakes;
    private int[] ladders;
    
    
	/*
	 * @params:none
	 * @return:none
	 * @desc:default constructor 
	 */	
    public SnakeAndLadder() {
        this.playerPosition = 0;
        this.snakes = new int[NUM_SNAKES];
        this.ladders = new int[NUM_LADDERS];
    }
    
    
    
	/*
	 * @params:none
	 * @return:integer(random number)
	 * @desc:returns a random integer from 1 to 100
	 */	
    private int getRandomPosition() {
        Random random = new Random();
        return random.nextInt(BOARD_SIZE - 1) + 1; 
    }
    
    
    
    
	/*
	 * @params:none
	 * @return:none
	 * @desc:initializes randomly the board
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
	 * @return:none
	 * @desc:prints the initial position
	 */	 
    public static void main(String[] args) {
        SnakeAndLadder game = new SnakeAndLadder();
        System.out.println("Welcome to SNAKE AND LADDER!");
        System.out.println("Initial position of the player:"+INITIAL_POSITION);
   
        game.initializeBoard();
    }
}
