package exercise02;

public class Hamster extends Animal implements Herbivore {
  public Hamster(String name, int age) {
    super(name, age);
  }

  public String chill() {
    return "I can chill for 8 hours";
  }

  @Override
  public String toString() {
    return super.toString() + chill();
  }
}