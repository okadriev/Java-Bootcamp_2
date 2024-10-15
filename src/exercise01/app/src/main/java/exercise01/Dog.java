package exercise01;

public class Dog extends Animal {
  public Dog(String name, int age, double weight) {
    super(name, age, weight);
  }

  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  public double getFeedInfoKg() {
    return getWeight() * 0.3;
  }
}