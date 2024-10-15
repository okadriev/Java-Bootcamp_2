package exercise00;

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

  public String getString() {
    return scanner.next();
  }

  public String getAnimalName() throws Exception {
    String animal = getString();
    if (!animal.equalsIgnoreCase("cat") && !animal.equalsIgnoreCase("dog")) {
      throw new Exception("Incorrect input. Unsupported pet type");
    }
    return animal;
  }

  public int getInt() {
    while (!scanner.hasNextInt()) {
      System.err.println("Couldn't parse a number. Please, try again");
      scanner.next();
    }
    return scanner.nextInt();
  }

  public int getAge() throws Exception {
    int age = getInt();

    if (age <= 0) {
      throw new Exception("Incorrect input. Age <= 0");
    }

    return age;
  }

  public int getCount() throws Exception {
    int count = getInt();

    if (count <= 0) {
      throw new Exception("Incorrect input. Count <= 0");
    }

    return count;
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
          Animal pet = animal.equalsIgnoreCase("cat") ? new Cat(name, age) : new Dog(name, age);
          
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
