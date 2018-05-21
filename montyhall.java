/**
 * Simulation of the Monty Hall Paradox.
 * @author Shah
 */
public class MontyHallSimulation 
{      
    public static final int NUMBER_OF_GAMES = 100000;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {        
        /**** Two players. player[0] switches and player[1] does not switch */
        int [] players = new int[2];
        /****/
        
        for(int i=0; i < NUMBER_OF_GAMES; i++)
        {
            /**** Three doors, and one random door is the winning door */
            int [] doors = new int[3];
            int rand = randomNumber(0, 2);
            doors[rand] = 1;
            /*****/
            
            /**** The first door that the player chooses, but does not open */
            int choice0 = randomNumber(0, 2);
            /****/
            
            /**** Find the remaining non-winning door that Monty opens */
            int montyOpens = -1;
            if(choice0 == 0)
            {
                if(doors[1] == 0)
                    montyOpens = 1;
                else if(doors[2] == 0)
                    montyOpens = 2;
            }
            else if(choice0 == 1)
            {
                if(doors[0] == 0)
                    montyOpens = 0;
                else if(doors[2] == 0)
                    montyOpens = 2;
            }
            else if(choice0 == 2)
            {
                if(doors[1] == 0)
                    montyOpens = 1;
                else if(doors[0] == 0)
                    montyOpens = 0;
            }
            /****/
            
            /**** player[0] switches, player[1] does not switch */
            int finalChoice = -1;
            
            if(choice0 == 0)
            {
                if(montyOpens == 1)
                {
                    finalChoice = 2;
                }
                if(montyOpens == 2)
                {
                    finalChoice = 1;
                }
            }
            else if(choice0 == 1)
            {
                if(montyOpens == 0)
                {
                    finalChoice = 2;
                }
                if(montyOpens == 2)
                {
                    finalChoice = 0;
                }
            }
            else if(choice0 == 2)
            {
                if(montyOpens == 1)
                {
                    finalChoice = 0;
                }
                if(montyOpens == 0)
                {
                    finalChoice = 1;
                }
            }
            /****/
            
            /**** Increment the count of the winning player */
            if(doors[finalChoice] == 1)
            {
                /**** player[0] switches */
                players[0]++;
                /****/
            }
            else if(doors[choice0] == 1)
            {
                /**** player[1] does not switch */
                players[1]++;
                /****/
            }
            /****/
        }
        
        /**** Print the switching and non-switching player counts */
        System.out.println("Number Of Games: " + NUMBER_OF_GAMES);
        System.out.println("Switching Player won: " + players[0] + " games!");
        System.out.println("Non Switching Player won: " + players[1] + " games!");
        /****/
    }
    
    public static int randomNumber(int min, int max)
    {
        double rand = Math.random();
        return (int) (rand * (max - min + 1)) + min;
    }
    
}
