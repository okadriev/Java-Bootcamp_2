package exercise02;

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

  private String getAnimalType() throws Exception {
    String animal = getString();
    if (!animal.contains("cat") && !animal.contains("dog") && !animal.contains("guinea") && !animal.contains("hamster")) {
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

  // private double getDouble() {
  // while (!scanner.hasNextDouble()) {
  // System.err.println("Couldn't parse a number. Please, try again");
  // scanner.next();
  // }
  // return scanner.nextDouble();
  // }

  // private double getWeight() throws Exception {
  // double weight = getDouble();
  // if (weight <= 0) {
  // throw new Exception("Incorrect input. Mass <= 0");
  // }
  // return weight;
  // }

  public List<Animal> getPets() throws Exception {
    try {
      int count = getCount();
      List<Animal> pets = new ArrayList<Animal>();

      for (int i = 0; i < count; i++) {
        try {
          String animal = getAnimalType();
          String name = getString();
          int age = getAge();
          pets.add(initPet(animal, name, age));

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

  private Animal initPet(String animal, String name, int age) {
    Animal pet = null;
    if (animal.contains("cat")) {
      pet = new Cat(name, age);
    } else if (animal.contains("dog")) {
      pet = new Dog(name, age);
    } else if (animal.contains("guinea")) {
      pet = new GuineaPig(name, age);
    } else if (animal.contains("hamster")) {
      pet = new Hamster(name, age);
    }

    return pet;
  }
}