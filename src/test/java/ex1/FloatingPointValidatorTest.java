package ex1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static ex1.Validator.validateFloatingPoint;

public class FloatingPointValidatorTest {

  private void shouldAccept(String s) {
    assertThat(validateFloatingPoint(s)).isTrue();
  }

  private void shouldReject(String s) {
    assertThat(validateFloatingPoint(s)).isFalse();
  }

  @Test
  @DisplayName("Should validate '1'")
  void shouldAccept1() {
    shouldAccept("1");
  }

  @Test
  @DisplayName("Should validate '+1'")
  void shouldAcceptPlus1() {
    shouldAccept("+1");
  }

  @Test
  @DisplayName("Should validate '-1'")
  void shouldAcceptMinus1() {
    shouldAccept("-1");
  }

  @Test
  @DisplayName("Should validate 65")
  void shouldAccept65() {
    shouldAccept("65");
  }

  @Test
  @DisplayName("Should validate +65")
  void shouldAcceptPlus65() {
    shouldAccept("+65");
  }

  @Test
  @DisplayName("Should validate -65")
  void shouldAcceptMinus65() {
    shouldAccept("-65");
  }

  @Test
  @DisplayName("Should validate '5.2'")
  void shouldAccept5Point2() {
    shouldAccept("5.2");
  }

  @Test
  @DisplayName("Should validate 5,2")
  void shouldAccept5Comma2() {
    shouldAccept("5,2");
  }

  @Test
  @DisplayName("Should validate '5.225'")
  void shouldAccept5Point225() {
    shouldAccept("5.225");
  }

  @Test
  @DisplayName("Should validate 5,225")
  void shouldAccept5Comma225() {
    shouldAccept("5,225");
  }

  @Test
  @DisplayName("Should validate '985.225'")
  void shouldAccept985Point225() {
    shouldAccept("985.225");
  }

  @Test
  @DisplayName("Should validate 985,225")
  void shouldAccept9855Comma225() {
    shouldAccept("985,225");
  }

  @Test
  @DisplayName("Should validate 985.'")
  void shouldAccept985Point() {
    shouldAccept("985.");
  }

  @Test
  @DisplayName("Should validate ,225")
  void shouldAcceptComma225() {
    shouldAccept(",225");
  }

  @Test
  @DisplayName("Should validate +5.2")
  void shouldAcceptPlus5Point2() {
    shouldAccept("+5.2");
  }

  @Test
  @DisplayName("Should validate +5,2")
  void shouldAcceptPlus5Comma2() {
    shouldAccept("+5,2");
  }

  @Test
  @DisplayName("Should validate +5.225")
  void shouldAcceptPlus5Point225() {
    shouldAccept("+5.225");
  }

  @Test
  @DisplayName("Should validate +5,225")
  void shouldAcceptPlus5Comma225() {
    shouldAccept("+5,225");
  }

  @Test
  @DisplayName("Should validate +985.225")
  void shouldAcceptPlus985Point225() {
    shouldAccept("+985.225");
  }

  @Test
  @DisplayName("Should validate +985,225")
  void shouldAcceptPlus9855Comma225() {
    shouldAccept("+985,225");
  }

  @Test
  @DisplayName("Should validate +985.")
  void shouldAcceptPlus985Point() {
    shouldAccept("+985.");
  }

  @Test
  @DisplayName("Should validate +,225")
  void shouldAcceptPlusComma225() {
    shouldAccept("+,225");
  }

  @Test
  @DisplayName("Should validate -5.2")
  void shouldAcceptMinus5Point2() {
    shouldAccept("-5.2");
  }

  @Test
  @DisplayName("Should validate -5,2")
  void shouldAcceptMinus5Comma2() {
    shouldAccept("-5,2");
  }

  @Test
  @DisplayName("Should validate -5.225")
  void shouldAcceptMinus5Point225() {
    shouldAccept("-5.225");
  }

  @Test
  @DisplayName("Should validate -5,225")
  void shouldAcceptMinus5Comma225() {
    shouldAccept("-5,225");
  }

  @Test
  @DisplayName("Should validate -985.225")
  void shouldAcceptMinus985Point225() {
    shouldAccept("-985.225");
  }

  @Test
  @DisplayName("Should validate -985,225")
  void shouldAcceptMinus9855Comma225() {
    shouldAccept("-985,225");
  }

  @Test
  @DisplayName("Should validate -985.")
  void shouldAcceptMinus985Point() {
    shouldAccept("-985.");
  }

  @Test
  @DisplayName("Should validate -,225")
  void shouldAcceptMinusComma225() {
    shouldAccept("-,225");
  }

  @Test
  @DisplayName("Should validate 5.2E3")
  void shouldAccept5Point2E3() {
    shouldAccept("5.2E3");
  }

  @Test
  @DisplayName("Should validate 5.2e3")
  void shouldAccept5Point2e3() {
    shouldAccept("5.2e3");
  }

  @Test
  @DisplayName("Should validate +5.2e3")
  void shouldAcceptPlus5Point2e3() {
    shouldAccept("+5.2e3");
  }

  @Test
  @DisplayName("Should validate -5.2e3")
  void shouldAcceptMinus5Point2e3() {
    shouldAccept("-5.2e3");
  }

  @Test
  @DisplayName("Should validate 5,2E3")
  void shouldAccept5Comma2E3() {
    shouldAccept("5,2E3");
  }

  @Test
  @DisplayName("Should validate 5,2e3")
  void shouldAccept5Comma2e3() {
    shouldAccept("5,2e3");
  }

  @Test
  @DisplayName("Should validate -5,2e3")
  void shouldAcceptMinus5Comma2e3() {
    shouldAccept("-5,2e3");
  }

  @Test
  @DisplayName("Should validate +5,2e3")
  void shouldAcceptPlus5Comma2e3() {
    shouldAccept("+5,2e3");
  }

  @Test
  @DisplayName("Should validate 5.2e112")
  void shouldAccept5Point2e112() {
    shouldAccept("5.2e112");
  }

  @Test
  @DisplayName("Should validate +5.2e112245")
  void shouldAcceptPlus5Point2e112245() {
    shouldAccept("+5.2e112245");
  }

  @Test
  @DisplayName("Should validate -5.2e99999")
  void shouldAcceptMinus5Point2e99999() {
    shouldAccept("-5.2e99999");
  }

  @Test
  @DisplayName("Should validate 5,2e112")
  void shouldAccept5Comma2e2e112() {
    shouldAccept("5,2e112");
  }

  @Test
  @DisplayName("Should validate -5,2e112245")
  void shouldAcceptMinus5Comma2e112245() {
    shouldAccept("-5,2e112245");
  }

  @Test
  @DisplayName("Should validate +5,2e99999")
  void shouldAcceptPlus5Comma2e99999() {
    shouldAccept("+5,2e99999");
  }

  @Test
  @DisplayName("Should validate 5.2e+3")
  void shouldAccept5Point2ePlus3() {
    shouldAccept("5.2e+3");
  }

  @Test
  @DisplayName("Should validate +5.2e+3")
  void shouldAcceptPlus5Point2ePlus3() {
    shouldAccept("+5.2e+3");
  }

  @Test
  @DisplayName("Should validate -5.2e+3")
  void shouldAcceptMinus5Point2ePlus3() {
    shouldAccept("-5.2e+3");
  }

  @Test
  @DisplayName("Should validate 5,2e-3")
  void shouldAccept5Comma2eMinus3() {
    shouldAccept("5,2e-3");
  }

  @Test
  @DisplayName("Should validate -5,2e-3")
  void shouldAcceptMinus5Comma2eMinus3() {
    shouldAccept("-5,2e-3");
  }

  @Test
  @DisplayName("Should validate +5,2e-3")
  void shouldAcceptPlus5Comma2eMinus3() {
    shouldAccept("+5,2e-3");
  }

  @Test
  @DisplayName("Should validate 5.e3")
  void shouldAccept5PointE3() {
    shouldAccept("5.e3");
  }

  @Test
  @DisplayName("Should validate 5.e+3")
  void shouldAccept5PointEPlus3() {
    shouldAccept("5.e+3");
  }

  @Test
  @DisplayName("Should validate +5.e+3")
  void shouldAcceptPlus5PointEPlus3() {
    shouldAccept("+5.e+3");
  }

  @Test
  @DisplayName("Should validate -5.e+3")
  void shouldAcceptMinus5PointEPlus3() {
    shouldAccept("-5.e+3");
  }

  @Test
  @DisplayName("Should validate 5,e-3")
  void shouldAccept5CommaEMinus3() {
    shouldAccept("5,e-3");
  }

  @Test
  @DisplayName("Should validate -5,e-3")
  void shouldAcceptMinus5CommaEMinus3() {
    shouldAccept("-5,e-3");
  }

  @Test
  @DisplayName("Should validate +5,2e-3")
  void shouldAcceptPlus5CommaEMinus3() {
    shouldAccept("+5,e-3");
  }

  @Test
  @DisplayName("Should validate ,225e123")
  void shouldAcceptComma225e123() {
    shouldAccept(",225e123");
  }

  @Test
  @DisplayName("Should validate +,225e123")
  void shouldAcceptPlusComma225e123() {
    shouldAccept("+,225e123");
  }

  @Test
  @DisplayName("Should validate -,225e123")
  void shouldAcceptMinusComma225e123() {
    shouldAccept("-,225e123");
  }

  @Test
  @DisplayName("Should validate .225e123")
  void shouldAcceptPoint225e123() {
    shouldAccept(".225e123");
  }

  @Test
  @DisplayName("Should validate +.225e123")
  void shouldAcceptPlusPoint225e123() {
    shouldAccept("+.225e123");
  }

  @Test
  @DisplayName("Should validate -.225e123")
  void shouldAcceptMinusPoint225e123() {
    shouldAccept("-.225e123");
  }

  @Test
  @DisplayName("Should not validate ,")
  void shouldRejectComma() {
    shouldReject(",");
  }

  @Test
  @DisplayName("Should not validate +,")
  void shouldRejectPlusComma() {
    shouldReject(",");
  }

  @Test
  @DisplayName("Should not validate -,")
  void shouldRejectMinusComma() {
    shouldReject(",");
  }

  @Test
  @DisplayName("Should not validate .")
  void shouldRejectDot() {
    shouldReject(".");
  }

  @Test
  @DisplayName("Should not validate +.")
  void shouldRejectPlusDot() {
    shouldReject(".");
  }

  @Test
  @DisplayName("Should not validate -.")
  void shouldRejectMinusDot() {
    shouldReject(".");
  }

  @Test
  @DisplayName("Should not validate .e")
  void shouldRejectDotE() {
    shouldReject(".e");
  }

  @Test
  @DisplayName("Should not validate ,e")
  void shouldRejectCommaE() {
    shouldReject(",e");
  }

  @Test
  @DisplayName("Should not validate .e2")
  void shouldRejectDotE2() {
    shouldReject(".e2");
  }

  @Test
  @DisplayName("Should not validate ,e2")
  void shouldRejectCommaE2() {
    shouldReject(",e2");
  }

  @Test
  @DisplayName("Should not validate ,225e")
  void shouldRejectComma225e() {
    shouldReject(",225e");
  }

  @Test
  @DisplayName("Should not validate +,225e")
  void shouldRejectPlusComma225e() {
    shouldReject("+,225e");
  }

  @Test
  @DisplayName("Should not validate -,225e")
  void shouldRejectMinusComma225e() {
    shouldReject("-,225e");
  }

  @Test
  @DisplayName("Should not validate .225e")
  void shouldRejectPoint225e() {
    shouldReject(".225e");
  }

  @Test
  @DisplayName("Should not validate +.225e")
  void shouldRejectPlusPoint225e() {
    shouldReject("+.225e");
  }

  @Test
  @DisplayName("Should not validate -.225e")
  void shouldRejectMinusPoint225e() {
    shouldReject("-.225e");
  }
}
