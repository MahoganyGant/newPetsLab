package petsLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // needed a way to store the list being created from gatherPetInfo method for further use
        ArrayList<Pet> pets = Pet.gatherPetInfo();

        System.out.println(pets); //see order of pets before sorting

        Collections.sort(pets);

        System.out.println(pets); //see order of pets after sorting

        Collections.sort(pets, new newComparator());

        System.out.println(pets);
    }
}
