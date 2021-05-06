package ex3;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static ex3.Finder.findZeroToOneHundred;

class ZeroToOneHundredFinderTest {

  @Test
  void shouldReturn20() {
    String text = "Sam has 200 apples. He gives Todd 20 and Mary 125.";
    assertThat(findZeroToOneHundred(text)).containsExactly(20);
  }

  @Test
  void shouldReturn5() {
    String text = "The weather is -5 C today, but will be +5 C tomorrow.";
    assertThat(findZeroToOneHundred(text)).containsExactly(5);
  }

  @Test
  void shouldReturn0() {
    String text = "Process finished with exit code 0";
    assertThat(findZeroToOneHundred(text)).containsExactly(0);
  }

  @Test
  void shouldReturn100() {
    String text = "Did you know that water boils at 100 degrees at standard atmospheric pressure?";
    assertThat(findZeroToOneHundred(text)).containsExactly(100);
  }

  @Test
  void shouldNotReturn15() {
    String text = "I'm using openjdk15 my project.";
    assertThat(findZeroToOneHundred(text)).isEmpty();
  }

  @Test
  void shouldReturn50and30() {
    String text = "There are 50 students in my class, out of which 30 attend the lectures.";
    assertThat(findZeroToOneHundred(text)).containsExactly(50, 30);
  }
}
