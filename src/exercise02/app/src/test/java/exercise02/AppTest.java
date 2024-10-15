package exercise02;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class AppTest {
  @Test
  void testAllDogs() {
    String input = "4 dog Snowball 12 guinea Piggy 5 cat Snowball 9 hamster Wave 2";
    String expectedOutput = "GuineaPig name = Piggy, age = 5. I can chill for 12 hours\n" +
        "Hamster name = Wave, age = 2. I can chill for 8 hours\n" +
        "Dog name = Snowball, age = 12. I can hunt for robbers\n" +
        "Cat name = Snowball, age = 9. I can hunt for mice\n";

    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    App.main(new String[] {});

    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  void testMixedPets() {
    String input = "2 dog Snowball 12 cat Kitty 10";
    String expectedOutput = "Dog name = Snowball, age = 12. I can hunt for robbers\n" +
        "Cat name = Kitty, age = 10. I can hunt for mice\n";

    ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
    System.setIn(inputStream);

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    App.main(new String[] {});

    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  void testIncorrectInputs() {
    String input = "3 turtle cat Kitty -10 guinea Piggy 3";

    String expectedOutput = "GuineaPig name = Piggy, age = 3. I can chill for 12 hours\n";
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