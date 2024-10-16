package exercise04;

public abstract class Animal {
  private String name;
  private int age;

  public Animal(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public void addAge() {
    if (getAge() > 10) {
      age++;
    }
  }

  public String toString() {
    return String.format("%s name = %s, age = %d",
        getClass().getSimpleName(), name, age);
  }
}