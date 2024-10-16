package exercise05;

import java.util.List;

public class AnimalIterator implements BaseIterator<Animal> {
  private List<Animal> pets;
  private int index;

  public AnimalIterator (List<Animal> pets) {
    this.pets = pets;
    this.index = 0;
  }

  @Override
  public boolean hasNext() {
    return index < pets.size();
  }

  @Override
  public Animal next() {
    return pets.get(index++);
  } 

  @Override
  public void reset() {
    index = 0;
  }
}
