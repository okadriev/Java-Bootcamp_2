package exercise01;

public class Cat extends Animal {
  public Cat(String name, int age, double weight) {
    super(name, age, weight);
  }

  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  public double getFeedInfoKg() {
    return getWeight() * 0.1;
  }
}