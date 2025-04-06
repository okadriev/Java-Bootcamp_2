package exercise02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input implements AutoCloseable {
  private Scanner scanner;

  private enum PetType {
    CAT,
    DOG,
    GUINEA,
    HAMSTER
  }

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
    PetType petType = null;
    try {
      petType = PetType.valueOf(getString().toUpperCase());
    } catch (IllegalArgumentException e) {
      throw new Exception("Incorrect input. Unsupported pet type");
    }

    String name = getName();
    int age = getAge();
    Animal pet = null;
    switch (petType) {
      case CAT:
        pet = new Cat(name, age);
        break;
      case DOG:
        pet = new Dog(name, age);
        break;
      case GUINEA:
        pet = new GuineaPig(name, age);
        break;
      case HAMSTER:
        pet = new Hamster(name, age);
        break;
    }

    return pet;
  }
}