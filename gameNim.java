import java.util.Scanner;
import java.util.Random;
public class gameNim
{	
	public static void main(String[] args)
	{

	Random randomGenerator = new Random();
	System.out.println("\t\t\t\tWelcome to Marblez ");
	System.out.println("Marblez is a game where the goal is to leave your opponent with the last marble. \n \t\t\t\tGood luck!");
	System.out.println("\t\t\tCopyright © Marblez - Danny Rivera");

	int coinFlip = randomGenerator.nextInt(2)+1;		//coinFlip determines who goes first. 
		if (coinFlip == 1)
			System.out.println("The computer goes first.");
		if (coinFlip == 2)
			System.out.println("You go first."); 
 
	int randomMarble = randomGenerator.nextInt(91) + 10;  // gives random number between 10 - 100 marbles

	Scanner input = new Scanner(System.in);
	System.out.println("There are " + randomMarble + " marbles in the pile."); //randomMarble is the random numbers of marbles given.
	
	int usersMarble = 0;
	int marblesSubtracted = randomMarble - usersMarble; 	//determines counter for the while loop

	if (coinFlip == 2) // the user goes first and then computer and user take turns on the while loop
			{
			System.out.println("How many do you wish to pick: ");
			usersMarble = input.nextInt(); 		//users choice of choosing amount of marbles.
			while (usersMarble > randomMarble/2 || usersMarble <= 0)  // used for error checkings.
				{
				System.out.println("You cannot take more than " + randomMarble/2 + " marbles.");
				System.out.println("Please pick again: ");
				usersMarble = input.nextInt();
				}
			marblesSubtracted = randomMarble - usersMarble;
			System.out.println("There are " + marblesSubtracted + " marbles in the pile.");
			}

	while (coinFlip == 2 || coinFlip == 1)
		{
		int computerMarbles = (int) (Math.log(marblesSubtracted+1)/Math.log(2));
		computerMarbles = (int) (marblesSubtracted - (Math.pow(2,computerMarbles)-1));
			if (computerMarbles == 0)
				computerMarbles = randomGenerator.nextInt(marblesSubtracted/2)+1;
		System.out.println("The computer picks " + computerMarbles + " marbles.");
		int marblesTaken = marblesSubtracted - computerMarbles;
			if (marblesTaken == 1) //to finish the program when marbles = 1
				{
					System.out.println("There is " + marblesTaken + " marble in the pile.");
					System.out.println("How many do you wish to pick: ");
					int lastMarbleForUser = input.nextInt();
					while(lastMarbleForUser<1 || lastMarbleForUser >1)
						{
						System.out.println("Invalid numbers. Cheating is not tolerated!");
						lastMarbleForUser = input.nextInt();
						}
					System.out.println("You Lose!! Computer wins!!");
					break;
				}
		System.out.println("There are " + marblesTaken + " marbles.");
		System.out.println("How many do you wish to pick: ");
		int usersMarbleTaken = input.nextInt();
			while(usersMarbleTaken > marblesTaken/2 || usersMarbleTaken <= 0)
				{
				System.out.println("You cannot take more than " + marblesTaken/2 + " marbles.");
				System.out.println("Please pick again.");
				usersMarbleTaken = input.nextInt();
				}
		marblesSubtracted = marblesTaken - usersMarbleTaken;
			if (marblesSubtracted == 1) //to finish the program when marbles = 1
				{
				System.out.println("There is " + marblesSubtracted + " marble in the pile.");
				computerMarbles = (int) (Math.log(marblesSubtracted+1)/Math.log(2));
				System.out.println("The computer takes " + computerMarbles + " marble.");
				System.out.println("Congrats!! You win!!!");
				break;
				}
		System.out.println("There are " + marblesSubtracted + " marbles in the pile.");
		}
		System.out.println("\tGame Over!");
	}
}