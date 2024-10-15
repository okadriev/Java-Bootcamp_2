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

  private String getString() {
    return scanner.next();
  }

  private String getAnimalName() throws Exception {
    String animal = getString();
    if (!animal.equalsIgnoreCase("cat") && !animal.equalsIgnoreCase("dog")) {
      throw new Exception("Incorrect input. Unsupported pet type");
    }
    return animal;
  }

  private int getInt() {
    while (!scanner.hasNextInt()) {
      System.err.println("Couldn't parse a number. Please, try again");
      scanner.next();
    }
    return scanner.nextInt();
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

  public List<Animal> getPets() throws Exception {
    try {
      int count = getCount();
      List<Animal> pets = new ArrayList<Animal>();

      for (int i = 0; i < count; i++) {
        try {
          String animal = getAnimalName();
          String name = getString();
          int age = getAge();
          double weight = getWeight();
          Animal pet = animal.equalsIgnoreCase("cat") ? new Cat(name, age, weight) : new Dog(name, age, weight);

          pets.add(pet);

        } catch (Exception e1) {
          System.err.println(e1.getMessage());
          continue;
        }
      }

      return pets;

    } catch (Exception e2) {
      throw e2;
    }
  }
}