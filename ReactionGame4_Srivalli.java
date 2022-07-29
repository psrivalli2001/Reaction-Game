import java.util.Date;
import java.util.Scanner;

public class ReactionGame4_Srivalli {

    public static final void main(String[] args) {

        
        Scanner scanner = new Scanner(System.in);
        int MenuOption;                                      //declares a variable to store the menu option
        
        for(;;)                                                    //starts an infinite loop
        {
        System.out.println("		WELCOME TO REACTION GAME		 ");      
        System.out.println("Please Choose your Menu Option");                       //Ask the user to enter a choice
        System.out.println("<1>	New Game");
        System.out.println("<2>	End");
        MenuOption = scanner.nextInt();                                             //reads the user's choice
        if ( MenuOption == 2 ) {                                                              //when user opts for end game , the if conditioin executes
        	System.out.println("		Thank You		");
        	break;
        }
        else if ( MenuOption == 1 )                  //when user opts for a new game, the game starts with 5 rounds
        {

        int numberOfRounds = 5;

        double limitToBeCalledFast = 0.5;
        double limitToBeCalledSlow = 0.8;

        double averageReactionTime = 0;
        //scanner.nextLine();
        
        	for (int i = 0; i < numberOfRounds; i++) {                                   

            System.out.println("Round " + (i + 1));
            System.out.println("Be ready!");
            sleepFor(5);
            double start = getNowSeconds();
            System.out.println("Quick, hit the Enter key");
            scanner.nextLine();
            double reactionTime = getNowSeconds() - start;
            averageReactionTime = averageReactionTime + reactionTime;
            System.out.println("You took " + reactionTime + " seconds");

            if (reactionTime <= limitToBeCalledFast) {                                                              // the following statements check the ranges for very fast, fast and slow reactions
                System.out.println("Wow, you are super fast!\n\n");
            } else if (reactionTime > limitToBeCalledFast && reactionTime < limitToBeCalledSlow) {
                System.out.println("You are fast, but you should practice more!\n\n");
            } else {
                System.out.println("Are you sleeping? You are slower than a turtle!\n\n");
            }
        }

        averageReactionTime = averageReactionTime / numberOfRounds;                                                      // calculates the average reaction time taken in 5 rounds
        System.out.println("You played " + numberOfRounds + " rounds and your average reaction time is " + averageReactionTime + " seconds");         //displays the average time
        }
        else                                                                                                             //if the user opts for any other option which is not menioned, it displays wrong option
        	System.out.println("You have opted a wrong option. Please try again");
        	
     
    }
    }

    // method to make the execution sleep for required time in seconds

    private static void sleepFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //method to get the number of seconds at the present time
    
    private static double getNowSeconds() {
        return new Date().getTime() / 1000.0;
    }
}
