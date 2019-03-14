/*Student: Elias Aguilera (if only the name is shown. Please press the "+" sign on your left for full description of the Assignment)
 *Description of the program: This method will create a Word Search Puzzle.
 *Mondays Class
 *Date: December 3, 2018.
 */

import java.util.*;
public class WordSearchPuzzle {
	
static final int MAXIMUM_SIZE= 10;
static final int MINIMUM_SIZE= 5;	
static Scanner input = new Scanner (System.in);
static Random random = new Random();	

	//Main starts
	public static void main(String[] args) {
	//A parameter name is created to store names in a bi dimensional array
	char [][] name;	
	//call method to display the purpose of the program
	displayPurpose();
	
	int size = getSizeOfPuzzle();
	name = new char[size][size];
	//String is created to store the input of the user
    String [] getLetter= new String[size];
	//call method to fill randomly the blank spaces in the puzzle
	blankSpacesFill(name,size);
	//call the method that stores the letter of the user and save it random columns in the puzzle
	getLetters(name,size, getLetter);
	
	
	//call method to print the input names
	showNames(name, size);
	//call method that prints what words the user has to find
	lettersToFind (size, getLetter);
	
	} //end of main
	
//**************************************************************
//This method will display the purpose of the program
private static void displayPurpose () {
System.out.println("*******************************************");
System.out.println("This programm will generate a simple puzzle");
System.out.println("*******************************************");
System.out.println(" ");
}
//**************************************************************
// This method takes inputs from the user to set the size of the puzzle
private static int getSizeOfPuzzle () {
int sizeOfPuzzle;	

System.out.println("What is the size of the puzzle you would like to create? (>=5 and <= 10)");
sizeOfPuzzle = input.nextInt();

	do {
		
		if (sizeOfPuzzle < MINIMUM_SIZE || sizeOfPuzzle > MAXIMUM_SIZE) {
			//if the user introduces the wrong number. The follow message will be displayed
			System.out.println("Invalid size. Please only enter a size between 5 and 10");
			sizeOfPuzzle = input.nextInt();
		}
	//sizeOfPuzzle will not get out of the loop until user enters a number between the constants 5 and 10		
	}while (sizeOfPuzzle <MINIMUM_SIZE || sizeOfPuzzle >MAXIMUM_SIZE); 
	
	input.nextLine();
	System.out.printf("The size chosen is %d%n ", sizeOfPuzzle);//shows the user the number the selected number
	System.out.println(" ");
	return  sizeOfPuzzle;
	
	}// end of getSizePuzzle

//******************************************************	
//This method will get the names from the user and will display it in a letter puzzle in a random row position
private static void getLetters (char [][] name, int size, String [] getLetter ) {
   
int randomNumber;
String getLetters;

	for (int i = 0; i < size; i++ ) {
		
		do {
			System.out.printf("Please enter your word %d to add to the puzzle: ", (i+1));
			getLetters = input.nextLine().toUpperCase();//all the inputs of the user is transformed in capital letter
			
			//
			
			
			if (getLetters.length() > size || getLetters.length() ==  0)  {
			System.out.printf("Incorrect name. Names must have between 1 and %d letters. ", size);
			}
			
			
		}while (getLetters.length() > size || getLetters.length() ==  0 );
		//get letter is store in a parameter so it can be use later to display the words that the user has to find
		
	
		
		
		getLetter [i] = getLetters;
		//The variable "randomNumber" takes a number from zero to the difference between the size and the length of a letter. 
		//This variable is used later to place the letter in a random position in the puzzle 
		randomNumber = random.nextInt((size+1)-getLetters.length()); 
		
		//Using the the randomNUmber variable, letters are positioned in a random place in the puzzle
	for (int j = 0; j <getLetters.length(); j++  )	{
		name [i][j+randomNumber] = getLetters.charAt(j);
		
	}
	
	}// end of for

	}// end of getLetters
	
//********************************************************
//This method prints the letters in the console
private static void showNames (char [][] name,  int size) {
	
		System.out.println("                                    ");
		System.out.println("--------------------Puzzle-------------------- ");
		
		for (int i = 0; i < size; i++ ) {
		
		
		for (int j = 0; j < size; j++) {
			
			
			System.out.printf ("%c      ", name [i][j]);
		}//end of j
		System.out.println();
		}// end of i
	}// end of showNames
//*******************************************************************	
//This method fill the blank spaces of the puzzle with random letters
private static void blankSpacesFill(char[][] name, int size) {
			   	
String randomLetters = "ARGAEOJBIERBQWOEITDFJBNOIJARG";
int numberOfLetters = randomLetters.length();			   
			   
			   
			   
	
	 for(int i= 0; i < size; i++){
		         
     for(int j= 0; j < size; j++){
	 // this element replace the blank spaces with random letters        
	 if (name[i][j] == '\u0000') {
	 name[i][j] = randomLetters.charAt(random.nextInt(numberOfLetters));}
		            }//for j
		        }//for i

		    }//fillUnusedElements

//(********************************************************
//This method prints the letters that are needed to find
private static void lettersToFind(int size, String [] getLetter) {

	
System.out.println("  ");
System.out.println("--------------Words to Search---------------- ");
				
	for (int i = 0; i < size; i++ ) {
		System.out.println(getLetter [i]);		
	}//end of j
	
		   }//end of letters to find
	
//************************************************************	
}// end of class  	
	