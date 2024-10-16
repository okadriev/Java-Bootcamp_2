package exercise04;

public class PetWalker {
  private long startTime;

  public PetWalker() {
    this.startTime = System.currentTimeMillis();
  }

  public void walkPet(Animal pet) {
    double walkStart = (System.currentTimeMillis() - startTime) / 1000.0;
    double walkEnd = pet.goToWalk() + walkStart;
    System.out.printf("%s, start time = %.2f, end time = %.2f%n", pet, walkStart, walkEnd);
  }
}