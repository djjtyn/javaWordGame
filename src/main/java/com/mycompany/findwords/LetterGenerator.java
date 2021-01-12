/**
*Instantiable class LetterGenerator which generates an array of randomly selected letters and a getter to return the array
*@author David Tynan
*/

import java.util.Random;	//import Random class

public class LetterGenerator{

	//declare and initialize arrays
	//LETTERS char array is final because the letters in the alphabet will never change
	final private char[] LETTERS = new char[]{
		'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'
	};

	//selectedLetters char array: values will be assigned letter chars when traversed and filled in generateGameLetters method
	private char[] selectedLetters = new char[12];

	//default constructor
	public LetterGenerator(){}

	//override constructors and setters are not needed for this class because the LETTERS array is final and the selectedLetters values are randomly selected by the computer

	//method to generate the letters
	public void generateGameLetters(){
		//initialize Random instance
		Random myRandom = new Random();
		int randomNumber;
		//traverse through letters array
		for(int i = 0; i<selectedLetters.length;i++){
			//for each iteration assign random number between 0 and 25 to randomNumber variable
			randomNumber = myRandom.nextInt(26);
			//use the random number generated as the array index for LETTERS array and assign the value to selectedLetters[i]
			selectedLetters[i] = LETTERS[randomNumber];
		}
	}

	//getter to return the randomly generated letters
	public char[] getSelectedLetters(){
		return selectedLetters;
	}
}