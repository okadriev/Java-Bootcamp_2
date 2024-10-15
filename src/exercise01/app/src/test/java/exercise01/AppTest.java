package exercise01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class AppTest {
  @Test
  void testAllDogs() {
    String input = "3\ndog\nSnowball\n12\n5.0\ndog\nSnowball2\n10\n10.0\ndog\nSnowball3\n9\n9.0\n";
    String expectedOutput = "Dog name = Snowball, age = 12, mass = 5.00, feed = 1.50\n" +
        "Dog name = Snowball2, age = 10, mass = 10.00, feed = 3.00\n" +
        "Dog name = Snowball3, age = 9, mass = 9.00, feed = 2.70\n";

    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    App.main(new String[] {});

    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  void testMixedPets() {
    String input = "3\n" +
        "dog\nSnowball\n12\n5.0\n" +
        "cat\nKitty\n10\n10.0\n" +
        "dog\nBalloon\n9\n9.0\n";
    String expectedOutput = "Dog name = Snowball, age = 12, mass = 5.00, feed = 1.50\n" +
        "Cat name = Kitty, age = 10, mass = 10.00, feed = 1.00\n" +
        "Dog name = Balloon, age = 9, mass = 9.00, feed = 2.70\n";

    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    App.main(new String[] {});

    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  void testIncorrectInputs() {
    String input = "4\nhamster\ncat\nKitty\n-10\ndog\nBalloon\n9\n-9\ncat\nFura\n9\n12.5\n";

    String expectedOutput = "Cat name = Fura, age = 9, mass = 12.50, feed = 1.25\n";
    String expectedErrorOutput = "Incorrect input. Unsupported pet type\n" +
        "Incorrect input. Age <= 0\n" +
        "Incorrect input. Mass <= 0\n";

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