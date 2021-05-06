package ex1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static ex1.Validator.validateAddress;

class AddressValidatorTest {

  private void shouldAccept(String s) {
    assertThat(validateAddress(s)).isTrue();
  }
  
  private void shouldReject(String s) {
    assertThat(validateAddress(s)).isFalse();
  }

  @Test
  @DisplayName("Should validate Piazza Università, 1, 39100 Bolzano BZ")
  void shouldAcceptPiazzaUniversita() {
    shouldAccept("Piazza Università, 1, 39100 Bolzano BZ");
  }

  @Test
  @DisplayName("Should validate Piazza Domenicani, 3, 39100 Bozen-Bolzano BZ")
  void shouldAcceptPiazzaDomenicani() {
    shouldAccept("Piazza Domenicani, 3, 39100 Bozen-Bolzano BZ");
  }

  @Test
  @DisplayName("Should validate Via Alessandro Volta, 13, 39100 Bolzano BZ")
  void shouldAcceptViaVolta() {
    shouldAccept("Via Alessandro Volta, 13, 39100 Bolzano BZ");
  }

  @Test
  @DisplayName("Should validate Via Calepina, 14, 38122 Trento TN")
  void shouldAcceptViaCalepina() {
    shouldAccept("Via Calepina, 14, 38122 Trento TN");
  }

  @Test
  @DisplayName("Should validate Via Calepina 14, 38122 Trento TN")
  void shouldAcceptViaCalepinaWithoutFirstComma() {
    shouldAccept("Via Calepina 14, 38122 Trento TN");
  }

  @Test
  @DisplayName("Should validate Via Calepina, 14 38122 Trento TN")
  void shouldAcceptViaCalepinaWithoutSecondComma() {
    shouldAccept("Via Calepina, 14 38122 Trento TN");
  }

  @Test
  @DisplayName("Should validate Via Calepina 14 38122 Trento TN")
  void shouldAcceptViaCalepinaWithoutCommas() {
    shouldAccept("Via Calepina 14 38122 Trento TN");
  }

  @Test
  @DisplayName("Should validate Viale Verona, 187, 38123 Trento TN")
  void shouldAcceptVialeVerona() {
    shouldAccept("Viale Verona, 187, 38123 Trento TN");
  }

  @Test
  @DisplayName("Should validate Corso 3 Novembre 1918, 130, 38122 Trento TN")
  void shouldAcceptCorsoTreNovembre() {
    shouldAccept("Corso 3 Novembre 1918, 130, 38122 Trento TN");
  }

  @Test
  @DisplayName("Should validate Piazza del Colosseo, 1, 00184 Roma RM")
  void shouldAcceptPiazzaDelColosseo() {
    shouldAccept("Piazza del Colosseo, 1, 00184 Roma RM");
  }

  @Test
  @DisplayName("Should validate Piazza di Santa Maria delle Grazie, 2, 20123 Milano MI")
  void shouldAcceptPiazzaDiSanta() {
    shouldAccept("Piazza di Santa Maria delle Grazie, 2, 20123 Milano MI");
  }

  @Test
  @DisplayName("Should validate Via Bolzano, 1a, 38121 Trento TN")
  void shouldAcceptViaBolzano() {
    shouldAccept("Via Bolzano, 1a, 38121 Trento TN");
  }

  @Test
  @DisplayName("Should not validate Calepina, 14, 38122 Trento TN")
  void shouldRejectWithoutAddressType() {
    shouldReject("Calepina, 14, 38122 Trento TN");
  }

  @Test
  @DisplayName("Should not validate Via, 14, 38122 Trento TN")
  void shouldRejectWithoutStreetName() {
    shouldReject("Via, 14, 38122 Trento TN");
  }

  @Test
  @DisplayName("Should not validate Via Calepina, 38122 Trento TN")
  void shouldRejectWithoutStreetNumber() {
    shouldReject("Via Calepina, 38122 Trento TN");
  }

  @Test
  @DisplayName("Should not validate Via Calepina, 14, Trento TN")
  void shouldRejectWithoutPostalCode() {
    shouldReject("Via Calepina, 14, Trento TN");
  }

  @Test
  @DisplayName("Should not validate Via Calepina, 14, 38122 TN")
  void shouldRejectWithoutCityName() {
    shouldReject("Via Calepina, 14, 38122 TN");
  }

  @Test
  @DisplayName("Should not validate Via Calepina, 14, 38122 Trento")
  void shouldRejectWithoutProvince() {
    shouldReject("Via Calepina, 14, 38122 Trento");
  }

  @Test
  @DisplayName("Should not validate , 14, 38122 Trento TN")
  void shouldRejectEmptyStreet() {
    shouldReject(", 14, 38122 Trento TN");
  }

  @Test
  @DisplayName("Should not validate Via Calepina, , 38122 Trento TN")
  void shouldRejectEmptyStreetNumber() {
    shouldReject("Via Calepina, , 38122 Trento TN");
  }

  @Test
  @DisplayName("Should not validate Via Calepina, 14,  Trento TN")
  void shouldRejectEmptyPostalCode() {
    shouldReject("Via Calepina, 14,  Trento TN");
  }

  @Test
  @DisplayName("Should not validate Via Calepina, 14, 38122  TN")
  void shouldRejectEmptyCity() {
    shouldReject("Via Calepina, 14, 38122  TN");
  }

  @Test
  @DisplayName("Should not validate Via Calepina, 14, 38122 Trento ")
  void shouldRejectEmptyProvince() {
    shouldReject("Via Calepina, 14, 38122 Trento ");
  }

  @Test
  @DisplayName("Should not validate Street Calepina, 14, 38122 Trento TN")
  void shouldRejectEnglishAddressType() {
    shouldReject("Street Calepina, 14, 38122 Trento TN");
  }

  @Test
  @DisplayName("Should not validate V. Calepina, 14, 38122 Trento TN")
  void shouldRejectAbbreviatedAddressType() {
    shouldReject("V. Calepina, 14, 38122 Trento TN");
  }

  @Test
  @DisplayName("Should not validate via Calepina, 14, 38122 Trento TN")
  void shouldRejectLowercaseAddressType() {
    shouldReject("via Calepina, 14, 38122 Trento TN");
  }

  @Test
  @DisplayName("Should not validate Via Calepina, 14, 381222 Trento TN")
  void shouldRejectSixDigitPostalCode() {
    shouldReject("Via Calepina, 14, 381222 Trento TN");
  }

  @Test
  @DisplayName("Should not validate Via Calepina, 14, 3812 Trento TN")
  void shouldRejectFourDigitPostalCode() {
    shouldReject("Via Calepina, 14, 3812 Trento TN");
  }

  @Test
  @DisplayName("Should not validate Via Calepina, 14, 38I22 Trento TN")
  void shouldRejectLetterInPostalCode() {
    shouldReject("Via Calepina, 14, 38I22 Trento TN");
  }

  @Test
  @DisplayName("Should not validate Via Calepina, 14, 38122 Trento TRENTO")
  void shouldRejectNonAbbreviatedProvince() {
    shouldReject("Via Calepina, 14, 38122 Trento TRENTO");
  }

  @Test
  @DisplayName("Should not validate Via Calepina, 14, 38122 Trento tn")
  void shouldRejectLowercaseProvince() {
    shouldReject("Via Calepina, 14, 38122 Trento tn");
  }

  @Test
  @DisplayName("Should not validate Via Bolzano, a1, 38121 Trento TN")
  void shouldRejectNumberAfterLetter() {
    shouldReject("Via Bolzano, a1, 38121 Trento TN");
  }

  @Test
  @DisplayName("Should not validate Via Bolzano, 1a1, 38121 Trento TN")
  void shouldRejectNumberLetterNumber() {
    shouldReject("");
  }

  @Test
  @DisplayName("Should not validate \"\"")
  void shouldRejectEmptyAddress() {
    shouldReject("");
  }

  @Test
  @DisplayName("Should not validate null")
  void shouldRejectNullAddress() {
    shouldReject(null);
  }

  @Test
  @DisplayName("Should not validate \" Via Calepina, 14, 38122 Trento TN\"")
  void shouldRejectPrefixedAddress() {
    shouldReject(" Via Calepina, 14, 38122 Trento TN");
  }

  @Test
  @DisplayName("Should not validate \"Via Calepina, 14, 38122 Trento TN \"")
  void shouldRejectSuffixedAddress() {
    shouldReject("Via Calepina, 14, 38122 Trento TN ");
  }

}
