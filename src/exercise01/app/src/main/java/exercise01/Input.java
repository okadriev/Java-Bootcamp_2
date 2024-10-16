package exercise01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input implements AutoCloseable {
  private Scanner scanner;

  public Input() {
    scanner = new Scanner(System.in);
  }

  public void close() {
    scanner.close();
  }

  public List<Animal> getPets() throws Exception {
    int count = getCount();
    List<Animal> pets = new ArrayList<>();

    for (int i = 0; i < count; i++) {
      try {
        pets.add(getPet());
      } catch (Exception e) {
        System.err.println(e.getMessage());
      }
    }

    return pets;
  }

  private int getInt() {
    while (!scanner.hasNextInt()) {
      System.err.println("Couldn't parse a number. Please, try again");
      scanner.next();
    }
    return scanner.nextInt();
  }

  private String getString() {
    return scanner.next();
  }

  private double getDouble() {
    while (!scanner.hasNextDouble()) {
      System.err.println("Couldn't parse a number. Please, try again");
      scanner.next();
    }
    return scanner.nextDouble();
  }

  private double getWeight() throws Exception {
    double weight = getDouble();
    if (weight <= 0) {
      throw new Exception("Incorrect input. Mass <= 0");
    }
    return weight;
  }

  private String getName() {
    return getString();
  }

  private int getAge() throws Exception {
    int age = getInt();
    if (age <= 0) {
      throw new Exception("Incorrect input. Age <= 0");
    }
    return age;
  }

  private int getCount() throws Exception {
    int count = getInt();
    if (count <= 0) {
      throw new Exception("Incorrect input. Count <= 0");
    }
    return count;
  }

  private Animal getPet() throws Exception {
    String animalType = getString();
    Animal pet = null;

    if (animalType.equals("cat")) {
      pet = new Cat(getName(), getAge(), getWeight());
    } else if (animalType.equals("dog")) {
      pet = new Dog(getName(), getAge(), getWeight());
    } else {
      throw new Exception("Incorrect input. Unsupported pet type");
    }

    return pet;
  }
}