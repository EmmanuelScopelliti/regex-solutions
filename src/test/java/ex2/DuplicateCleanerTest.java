package ex2;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static ex2.Cleaner.cleanDuplicates;

class DuplicateCleanerTest {

  @Test
  void shouldRemoveDuplicate() {
    String text = "What is is my purpose?";
    assertThat(cleanDuplicates(text)).isEqualTo("What is my purpose?");
  }

  @Test
  void shouldRemoveTriplicates() {
    String text = "What is is is my purpose?";
    assertThat(cleanDuplicates(text)).isEqualTo("What is my purpose?");
  }

  @Test
  void shouldRemoveQuadruplicates() {
    String text = "What is is is is my purpose?";
    assertThat(cleanDuplicates(text)).isEqualTo("What is my purpose?");
  }

  @Test
  void shouldNotRemoveDuplicateLetters() {
    String text = "You pass butter.";
    assertThat(cleanDuplicates(text)).isEqualTo("You pass butter.");
  }

  @Test
  void shouldNotRemoveOnDifferentCapitalization() {
    String text = "You pass Pass butter.";
    assertThat(cleanDuplicates(text)).isEqualTo("You pass Pass butter.");
  }

  @Test
  void shouldNotRemoveDuplicateSequences() {
    String text = "Oh my godgod...";
    assertThat(cleanDuplicates(text)).isEqualTo("Oh my godgod...");
  }

  @Test
  void shouldNotRemoveDuplicatesSeparatedBySymbol() {
    String text = "Oh my god,god...";
    assertThat(cleanDuplicates(text)).isEqualTo("Oh my god,god...");
  }

  @Test
  void shouldNotRemoveOnPartialMatchEnd() {
    String text = "Oh my goodgod god...";
    assertThat(cleanDuplicates(text)).isEqualTo("Oh my goodgod god...");
  }

  @Test
  void shouldNotRemoveOnPartialMatchStart() {
    String text = "Oh my god goddy...";
    assertThat(cleanDuplicates(text)).isEqualTo("Oh my god goddy...");
  }

  @Test
  void shouldRemoveDuplicatesSeparatedByNewLine() {
    String text = "Oh my god\ngod...";
    assertThat(cleanDuplicates(text)).isEqualTo("Oh my god...");
  }

  @Test
  void shouldRemoveDuplicatesSeparatedByTabs() {
    String text = "Oh my god\tgod...";
    assertThat(cleanDuplicates(text)).isEqualTo("Oh my god...");
  }

  @Test
  void shouldRemoveDuplicatesAtTheEnd() {
    String text = "Yeah, welcome to the club, pal pal pal pal.";
    assertThat(cleanDuplicates(text)).isEqualTo("Yeah, welcome to the club, pal.");
  }

  @Test
  void shouldRemoveDuplicatesAtTheBeginning() {
    String text = "Yeah Yeah, welcome to the club, pal.";
    assertThat(cleanDuplicates(text)).isEqualTo("Yeah, welcome to the club, pal.");
  }

}