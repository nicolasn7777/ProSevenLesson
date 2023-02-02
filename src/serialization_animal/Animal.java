package serialization_animal;

import java.io.*;

public class Animal implements Serializable{
    private int age;
    private String name;
    private String breed;

    public Animal() {
    }

    public Animal(int age, String name, String breed) {
        this.age = age;
        this.name = name;
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
    public static void main(String[] args) throws IOException {
        Animal dog = new Animal(10, "Fluffy", "bulldog");

        File file = new File("D:\\programs\\IDE\\projects IDE\\ProSevenLesson\\src\\serialization_animal\\animal.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(dog);
        oos.flush();
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Animal newAnimal = null;
        try {
            newAnimal = (Animal) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ois.close();

        System.out.println(newAnimal);
    }
}
