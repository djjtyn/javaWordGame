package com.mycompany.findwords;

/**
*Instantiable class Player which checks if the word the player entered is a match with a word in the validWords list
*This class also deals with managing the points awarded throughout the game
*@author David Tynan
*/

public class Player{

	//create instance variables
	private char[] letters;
	private String playerWord;
	private int wordPoints;
	private int totalPoints;
	private String[] validWords;
	private boolean isValid;

	//constructors
	//default constructor
	public Player(){}

	//override constructor: only takes letters array as value because the totalPoints is unknown and the wordPoints will always start at 0
	public Player(char[] letters){
		this.letters = letters;
	}

	//setters
	//sets the letters array to be used
	public void setLetters(char[] letters){
		this.letters = letters;
	}

	//sets the players chosen word
	public void setPlayerWord(String playerWord){
		this.playerWord = playerWord;
	}

	//sets the valid words
	public void setValidWords(){
		//create new ValidWords object and use its getter method to get the valid words which is assigned to Player instance variable
		ValidWords vw = new ValidWords();
		validWords = vw.getValidWords();
	}

	//play the game
	public void play(){
		//isValid will be set to false everytime this method is called initially
		isValid = false;
		//wordPoints will be set to 0 everytime this method is called initially
		wordPoints = 0;
		//declaration and initialisation of Stringbuffer object sb
		StringBuffer sb = new StringBuffer();
		//traverses the word given by the player letter by letter
		for(int i = 0;i<playerWord.length();i++){
			//assigns letter the traversal is on to char c
			char c = playerWord.charAt(i);
			//convert char c to lower case
			c = Character.toLowerCase(c);
			//traverses the letters randomly generated
			for(int j = 0; j<letters.length;j++){
				//if the letters in the word input by user matches a letter in the letters generated by the computer, add this letter to a StringBuffer and remove this letter from the letters array
				if(c == letters[j]){
					sb.append(c);
					letters[j] = 0;
					break;
				}
			}
		}
		//Convert the StringBuffer sb to a String
		String wordCreation = sb.toString();
		//traverse the array of valid words
		for(int i = 0; i<validWords.length;i++){
			if(wordCreation.equalsIgnoreCase(validWords[i])){
				//if there is a matching word for the wordCreation String the boolean isValid will be set to true
				isValid = true;
			}
		}
		//if there is a matching word in valid words give the player points
		if(isValid){
			System.out.println(wordCreation + " is a valid word!");
			//if the length is longer than 5 characters give 4 points for it
			if(playerWord.length()>5){
				wordPoints = 4;
			}else{
				wordPoints = 1;
			}
			//add the wordPoints to the Players total points
			totalPoints += wordPoints;
			//display how many points were awarded
			System.out.println("Points awarded for " + playerWord + ": " + wordPoints);
		}else{	//if the word isn't valid display message to user without giving them points
			System.out.println(playerWord + " is not a valid word");
			System.out.println("Points awarded for " + playerWord + ": " + wordPoints);
		}
	}

	//getters
	//get players total points is the only getter required
	public int getTotalPoints(){
		return totalPoints;
	}
}