/**
 *This program uses the Animal class to create 5 animal objects.
 * A while loop will keep the animals moving until at least 15
 * fights have occurred. A fight is simple when two animals are touching.
 *
 * @author Lucas D. Dahl
 * @version 9/22/20
 *
 */
public class AnimalEncounter {

    /**
     *This is the main method that will have 5 animals move until
     * 15 fights occur.
     *
     * @param args is the parameters.
     */
    public static void main(String[] args) {

        // Properties
        int rounds = 0, fights = 0;
        Animal[] animalArray = new Animal[5];

        // Setup all the animals
        animalArray[0] = new Animal("Hippo", -20, -20);
        animalArray[1] = new Animal("Platypus", -15, 12);
        animalArray[2] = new Animal("Turtle", -20, -20);
        animalArray[3] = new Animal("Ocelot", 14, -8);
        animalArray[4] = new Animal();

        // Loop until there has been 15 fights.
        while(fights < 15) {

            // Move all the animals
            for(int i = 0; i < animalArray.length; i++) {
                animalArray[i].move();
            }

            // Check to see if any of teh animals are touching
            for(int i = 0; i < animalArray.length; i++) {

                for(int j = 0; j < animalArray.length; j++) {

                    if(animalArray[i] != animalArray[j]) {

                        if(animalArray[i].getX() == animalArray[j].getX() && animalArray[i].getY() == animalArray[j].getY()) {

                            System.out.print("FIGHT");
                            System.out.println(", there is a fight between " + animalArray[i].getName() + " and " + animalArray[j].getName() + "." );

                            fights ++;

                        }
                    }
                }
            }

            // Print the names and coordinates of the animals.
            System.out.println();
            System.out.println("The animals are located at the following coordinates:");

            for(int i = 0; i < animalArray.length; i++) {
                System.out.println(animalArray[i].toString());
            }


            // Increment the round
            rounds ++;

            // Mark the end of the round.
            System.out.println("##########################################");
            System.out.println();

        }

        System.out.println(fights + " occurred in " + rounds + " rounds.");

    }
}
