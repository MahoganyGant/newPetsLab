package petsLab;

public class Dog extends Pet {

public Dog(String name){
    super(name);
}

    @Override
    public String speak() { //establishing the sound for each pet
        return "Woof!";
    }

}
