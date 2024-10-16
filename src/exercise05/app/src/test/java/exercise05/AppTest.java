package exercise05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class AppTest {
  @Test
  void testAllDogs() {
    String input = "3  dog  Snowball  12  dog  Snowball2  10  dog  Snowball3  9";
    String expectedOutput = "Dog name = Snowball, age = 12\n" +
        "Dog name = Snowball2, age = 10\n" +
        "Dog name = Snowball3, age = 9\n";

    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    App.main(new String[] {});

    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  void testMixedPets() {
    String input = "3  dog  Snowball  12  cat  Kitty  10  dog  Balloon  9";
    String expectedOutput = "Dog name = Snowball, age = 12\n" +
        "Cat name = Kitty, age = 10\n" +
        "Dog name = Balloon, age = 9\n";

    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    App.main(new String[] {});

    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  void testIncorrectInputs() {
    String input = "3  hamster  cat  Kitty  -10  cat  Fura  9";

    String expectedOutput = "Cat name = Fura, age = 9\n";
    String expectedErrorOutput = "Incorrect input. Unsupported pet type\n" +
        "Incorrect input. Age <= 0\n";

    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ByteArrayOutputStream errorStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
    System.setErr(new PrintStream(errorStream));

    App.main(new String[] {});

    assertEquals(expectedOutput, outputStream.toString());
    assertEquals(expectedErrorOutput, errorStream.toString());
  }
}