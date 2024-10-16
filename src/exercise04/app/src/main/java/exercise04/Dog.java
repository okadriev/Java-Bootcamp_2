package exercise04;

import java.util.concurrent.TimeUnit;

public class Dog extends Animal {
  public Dog(String name, int age) {
    super(name, age);
  }

  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  public double goToWalk() {
    double walkTime = getAge() * 0.5;

    try {
      TimeUnit.SECONDS.sleep(Math.round(walkTime));
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    return walkTime;
  }
}