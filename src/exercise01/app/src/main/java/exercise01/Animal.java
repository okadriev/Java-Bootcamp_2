package exercise01;

public abstract class Animal {
  private String name;
  private int age;
  private double weight;

  public Animal(String name, int age, double weight) {
    this.name = name;
    this.age = age;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public double getWeight() {
    return weight;
  }

  public String toString() {
      return String.format("%s name = %s, age = %d, mass = %.2f, feed = %.2f",
          getClass().getSimpleName(), name, age, weight, getFeedInfoKg());
  }

  public double getFeedInfoKg() {
    return weight * 0.1;
  }
}
