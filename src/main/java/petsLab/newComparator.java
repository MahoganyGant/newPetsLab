package petsLab;

import java.util.Comparator;

public class newComparator implements Comparator<Pet> {

    @Override
    public int compare(Pet o1, Pet o2) { //"breaking ties by name instead"
        // Compare by class name (type)
        String type1 = o1.getClass().getSimpleName();
        String type2 = o2.getClass().getSimpleName();
        int typeComparison = type1.compareTo(type2);

        // If types are different, return the result
        if (typeComparison != 0) {
            return typeComparison;
        }

        // If types are the same, compare by name
        return o1.getName().compareTo(o2.getName());
    }
}
