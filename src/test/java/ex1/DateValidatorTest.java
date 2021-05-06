package ex1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static ex1.Validator.validateDate;

class DateValidatorTest {
  private void shouldAccept(String s) {
    assertThat(validateDate(s)).isTrue();
  }

  private void shouldReject(String s) {
    assertThat(validateDate(s)).isFalse();
  }

  @Test
  @DisplayName("Should validate 01/04/2020")
  void shouldAccept01042020() {
    shouldAccept("01/04/2020");
  }

  @Test
  @DisplayName("Should validate 20/01/2019")
  void shouldAccept20012019() {
    shouldAccept("20/01/2019");
  }

  @Test
  @DisplayName("Should validate 25/12/1950")
  void shouldAccept25121950() {
    shouldAccept("25/12/1950");
  }

  @Test
  @DisplayName("Should validate 30/07/2021")
  void shouldAccept30072021() {
    shouldAccept("30/07/2021");
  }

  @Test
  @DisplayName("Should validate 31/08/1919")
  void shouldAccept31081919() {
    shouldAccept("31/08/1919");
  }

  @Test
  @DisplayName("Should validate 09/01/1729")
  void shouldAccept01011729() {
    shouldAccept("01/01/1729");
  }

  @Test
  @DisplayName("Should validate 10/05/2000")
  void shouldAccept10052020() {
    shouldAccept("10/05/2000");
  }

  @Test
  @DisplayName("Should validate 15/10/2049")
  void shouldAccept15102049() {
    shouldAccept("15/10/2049");
  }

  @Test
  @DisplayName("Should validate 22/11/3333")
  void shouldAccept22113333() {
    shouldAccept("22/11/3333");
  }

  @Test
  @DisplayName("Should not validate empty string")
  void shouldNotValidateEmptyString() {
    shouldReject("");
  }


  @Test
  @DisplayName("Should not validate null")
  void shouldNotValidateNull() {
    shouldReject(null);
  }

  @Test
  @DisplayName("Should not validate 1/4/00")
  void shouldReject1400() {
    shouldReject("1/4/00");
  }

  @Test
  @DisplayName("Should not validate 01/00/1900")
  void shouldReject01001900() {
    shouldReject("01/00/1900");
  }

  @Test
  @DisplayName("Should not validate 00/04/1900")
  void shouldReject00041900() {
    shouldReject("");
  }

  @Test
  @DisplayName("Should not validate 01/04/19000")
  void shouldReject010419000() {
    shouldReject("01/04/19000");
  }

  @Test
  @DisplayName("Should not validate 01/13/1900")
  void shouldReject01131900() {
    shouldReject("01/13/1900");
  }

  @Test
  @DisplayName("Should not validate 33/04/1900")
  void shouldReject33041900() {
    shouldReject("33/04/1900");
  }

  @Test
  @DisplayName("Should not validate 01/04/")
  void shouldReject0104_() {
    shouldReject("01/04/");
  }

  @Test
  @DisplayName("Should not validate 01//1900")
  void shouldReject01__1900() {
    shouldReject("01//1900");
  }

  @Test
  @DisplayName("Should not validate /04/1900")
  void shouldReject__041900() {
    shouldReject("/04/1900");
  }

  @Test
  @DisplayName("Should not validate ///")
  void shouldReject____() {
    shouldReject("///");
  }

  @Test
  @DisplayName("Should not validate 10/04/00")
  void shouldReject100400() {
    shouldReject("");
  }

  @Test
  @DisplayName("Should not validate 10/4/1900")
  void shouldReject1041900() {
    shouldReject("10/4/1900");
  }

  @Test
  @DisplayName("Should not validate 1/04/1900")
  void shouldReject() {
    shouldReject("1/04/1900");
  }

  @Test
  @DisplayName("Should not validate \" 01/04/1900\"")
  void shouldReject_01041900() {
    shouldReject(" 01/04/1900");
  }

  @Test
  @DisplayName("Should not validate \"This is the date: 01/04/1900\"")
  void shouldNotValidatePrefixedDate() {
    shouldReject("This is the date: 01/04/1900");
  }

  @Test
  @DisplayName("Should not validate 01.04.1900")
  void shouldReject01dot04dot1900() {
    shouldReject("01.04.1900");
  }

  @Test
  @DisplayName("Should not validate 01-04-1900")
  void shouldReject01dash04dash1900() {
    shouldReject("01-04-1900");
  }

}
