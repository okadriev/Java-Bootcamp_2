package exercise04;

import java.util.List;
import java.util.Scanner;

import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.Objects;

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

  private String getName() {
    return getString();
  }

  private String getAnimalType() throws Exception {
    String animal = getString();
    if (!animal.contains("cat") && !animal.contains("dog")) {
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

  public List<Animal> getPets() throws Exception {
    try {
      int count = getCount();
      return IntStream.range(0, count).mapToObj(i -> {
        try {
          return initPet(getAnimalType(), getName(), getAge());
        } catch (Exception e) {
          System.err.println(e.getMessage());
          return null;
        }
      }).filter(Objects::nonNull).collect(Collectors.toList());
    } catch (Exception e) {
      throw e;
    }
  }

  private Animal initPet(String animal, String name, int age) {
    Animal pet = null;
    if (animal.contains("cat")) {
      pet = new Cat(name, age);
    } else if (animal.contains("dog")) {
      pet = new Dog(name, age);
    }
    return pet;
  }
}