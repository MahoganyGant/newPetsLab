package petsLab;

import java.util.ArrayList;
import java.util.Scanner;

public class Pet implements Comparable<Pet> {
    private String name;

    public Pet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String speak() { //base method for sound
        return "...";
    }

    public static ArrayList<Pet> gatherPetInfo() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pet> pets = new ArrayList<>();

        // Ask the user how many pets they have
        System.out.print("How many pets do you have? ");
        int numberOfPets = scanner.nextInt();
        scanner.nextLine();

        // Gather information about each pet
        for (int i = 0; i < numberOfPets; i++) {
            System.out.print("What kind of pet is pet #" + (i + 1) + " (dog/cat/bird)? ");
            String petType = scanner.nextLine();

            System.out.print("What is the name of pet #" + (i + 1) + "? ");
            String petName = scanner.nextLine();

            // Create the correct type of pet
            if (petType.equals("dog")) {
                pets.add(new Dog(petName));
            } else if (petType.equals("cat")) {
                pets.add(new Cat(petName));
            } else if (petType.equals("bird")) {
                pets.add(new Bird(petName));
            } else {
                System.out.println("Unknown pet type.");
                pets.add(new Pet(petName));
            }
        }
        printPetList(pets);
        scanner.close();

        return pets;
    }

    public static void printPetList(ArrayList<Pet> pets) {
        System.out.println("\nThese are your Pets!:");
        for (Pet pet : pets) { // for each pet in the pets array do the following
            System.out.println(pet.getName() + " says: " + pet.speak());
        }
        System.out.println("\n");
    }

    @Override
    public int compareTo(Pet o) {
        // Compare by name (sorts alphabetically) Part 1
        int nameComparison = this.name.compareTo(o.name);

        // If names are different, return the result
        if (nameComparison != 0) {
            return nameComparison;
        }

        // If names are the same, compare by class name (type) "breaking ties by class"
        String thisType = this.getClass().getSimpleName(); // gets name of current object
        String otherType = o.getClass().getSimpleName();
        return thisType.compareTo(otherType);
    }


    @Override
    public String toString() {
        return "\n" + "Pet Names + Types" + "\n" + "Name: " + this.getName() + " Type: " + this.getClass().getSimpleName() + "\n";
    }

}


