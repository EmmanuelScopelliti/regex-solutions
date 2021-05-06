package ex3;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static ex3.Finder.findAlternatingBits;

class AlternatingBitsFinderTest {

  private void shouldFindExactly(String text, String... values) {
    assertThat(findAlternatingBits(text)).containsExactly((Object[]) values);
  }

  @Test
  void shouldFind0And0() {
    String text = "0 is 0";
    shouldFindExactly(text, "0", "0");
  }

  @Test
  void shouldFind1And1() {
    String text = "and 1 is 1.";
    shouldFindExactly(text, "1", "1");
  }

  @Test
  void shouldFindOnly10() {
    String text = "But 10 is 2";
    shouldFindExactly(text, "10");
  }

  @Test
  void shouldNotFind11() {
    String text = "and 11 is 3.";
    assertThat(findAlternatingBits(text)).isEmpty();
  }

  @Test
  void shouldFindOnly101() {
    String text = "The next ones are 100, 101, and 111, which are 4, 5, and 6.";
    shouldFindExactly(text, "101");
  }

  @Test
  void shouldFindOnly1010() {
    String text = "The four-digit values are 1000, 1001, 1010, 1011, 1100, 1101, 1110, and 1111!";
    shouldFindExactly(text, "1010");
  }

  @Test
  void shouldFindOnly0101() {
    String text =
        "Considering those starting with 0, we have 0000, 0001, 0010, 0011, 0100, 0101, 0110, and 0111!";
    shouldFindExactly(text, "0", "0101");
  }

  @Test
  void shouldFindOnly1010101010() {
    String text = "Some long values are 1010101010 and 1010101010101011, which are 682 and 43691.";
    shouldFindExactly(text, "1010101010");
  }
}
