/**
*GameApp Class
*An application that makes use of the ValidWords, LetterGenerator, Player and Scanner classes
*Allows a user to type in a word which is then used for a game which checks to see if the word matches with a word in the ValidWords class
*The game can consist of either one or multiple rounds and the round number will be shown for each round played
*This class determines who the winner of the game is and displays the results to the users
*@author David Tynan
*/

import java.util.Scanner;	//import Scanner class

public class GameApp{
	public static void main(String[]args){

		//declare and initialise variables and objects
		String playerOneWord, playerTwoWord;
		Player playerOne = new Player();
		Player playerTwo = new Player();
		char[] letters = new char[12];
		char[] playerTwoLetters = new char[12];
		Scanner sc = new Scanner(System.in);
		boolean uniquePlayerWord, playAgain;
		int round = 1;

		//Game introduction with instructions and details on points award scheme
		System.out.println("WELCOME TO THE FIND COMPUTER WORDS GAME!!");
		System.out.println();
		System.out.println("**********HOW TO PLAY**********");
		System.out.println("Players have to CREATE computer related words using the letters they are given at the start of each round!");
		System.out.println("Each player is issued the same letters to use per round");
		System.out.println("Players can only use each letter once unless the letter appears multiple times in the letters provided.");
		System.out.println("If the word entered matches a word in our list of valid words the player that chose the word will be awarded POINTS!");
		System.out.println("For words LONGER than 5 characters in length, the player will receive 4 points!");
		System.out.println("For words LESS than or EQUAL to 5 characters in length, the player will receive 1 point!");
		System.out.println("If players want to play another round after the round finishes just type in yes when the program asks at the end of the round!");
		System.out.println("At the end of the game the game scores will be shown and the winner announced!");
		System.out.println();

		//this do/while loop will keep repeating until the playAgain boolean is set to false
		do{
			//create LetterGenerator object lg
			LetterGenerator lg = new LetterGenerator();
			//generate the random letters to be used in the game
			lg.generateGameLetters();
			//assign the letters randomly generated to local char array letters
			letters = lg.getSelectedLetters();
			//make a copy of the letters array for playerTwo due to the original array being mutated
			playerTwoLetters = letters.clone();
			//show the players their letters to use for the round
			System.out.println("Your letters for round " + round + " are:");
			System.out.println(letters);
			System.out.println();

			//send the letters to the Player instances using setters
			playerOne.setLetters(letters);
			playerTwo.setLetters(playerTwoLetters);

			//set the games valid words in the Player instances using custom setter method
			playerOne.setValidWords();
			playerTwo.setValidWords();

			//PLAYER ONE
			//get a word from playerOne using the Scanner and assign to playerOneWord variable
			System.out.print("PlayerOne, what is your word?: ");
			playerOneWord = sc.next();

			//send word attained with scanner to PlayerOne instance
			playerOne.setPlayerWord(playerOneWord);

			//method for playing the game is called
			playerOne.play();

			//get playerOne total points and display on the screen
			int playerOneTotalPoints = playerOne.getTotalPoints();
			System.out.println("PlayerOne Total Points: " + playerOneTotalPoints);
			System.out.println();

			//PLAYER TWO
			//get playerTwo total points and assign to local variable playerTwoTotalPoints
			int playerTwoTotalPoints = playerTwo.getTotalPoints();
			//get a word from playerTwo using the Scanner and assign to playerTwoWord variable. Repeat if playerTwo chooses same word as playerOne
			do{
				System.out.print("PlayerTwo, what is your word?: ");
				playerTwoWord = sc.next();
				//If the two players choose the same word set the boolean uniquePlayerWord to false
				if(playerOneWord.equals(playerTwoWord)){
					System.out.println("PlayerOne has also chosen " + playerTwoWord + ". You cannot choose the same word. Please select a different word");
					uniquePlayerWord = false;
				}else{	//if the two players choose different words set the boolean uniquePlayerWord to true
					uniquePlayerWord = true;
				}
			}while(uniquePlayerWord == false);

			//if playerTwo chooses a unique word send the word to the PlayerTwo instance and call method to play the game
			if(uniquePlayerWord == true){
				playerTwo.setPlayerWord(playerTwoWord);
				playerTwo.play();
				//get playerTwo total points and display on the screen
				playerTwoTotalPoints = playerTwo.getTotalPoints();
				System.out.println("PlayerTwo Total Points: " + playerTwoTotalPoints);
			}

			System.out.println();

			//initialise anotherMatch variable to store users response when asked if they want another round
			String anotherMatch;
			//ask the player if they want another round.Repeat if value other than yes or no is input
			do{
				System.out.println("Do you want another round?[yes/no]");
				anotherMatch = sc.next();
				//convert users response to lower case
				anotherMatch = anotherMatch.toLowerCase();
				System.out.println();
			}while(!anotherMatch.equals("yes") && !anotherMatch.equals("no"));
			//if the player types yes
			if(anotherMatch.equalsIgnoreCase("yes")){
				//set playAgain boolean to true and increase the round number by one
				playAgain = true;
				round++;
			}else{	//if the player types no show the game results
				System.out.println("**********GAME RESULTS**********");
				//winner variable to be used to store who has won the game
				String winner;
				//playerOne wins if playerOne has more points than playerTwo
				if(playerOneTotalPoints > playerTwoTotalPoints){
					winner = "The winner of the game is PlayerOne!";
				//playerTwo wins if playerTwo has more points than playerOne
				}else if(playerTwoTotalPoints > playerOneTotalPoints){
					winner = "The winner of the game is PlayerTwo!";
				//if both players have the same points the game is a draw
				}else{
					winner = "Both players have equal scores. This game is a draw!";
				}
				//output to show who winner is as well as total points earned for both players
				System.out.println(winner);
				System.out.println("Total Points earned for PlayerOne: " + playerOneTotalPoints);
				System.out.println("Total Points earned for PlayerTwo: " + playerTwoTotalPoints);
				System.out.println("Thanks for playing!");
				//playAgain boolean set to false to break out of do/while loop
				playAgain = false;
			}
		}while(playAgain == true);
	}
}