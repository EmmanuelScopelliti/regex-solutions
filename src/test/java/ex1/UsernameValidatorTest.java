package ex1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static ex1.Validator.validateUsername;

class UsernameValidatorTest {
  private void shouldReject(String username) {
    assertThat(validateUsername(username)).isFalse();
  }

  private void shouldAccept(String username) {
    assertThat(validateUsername(username)).isTrue();
  }

  @Test
  @DisplayName("Should validate myuser")
  void shouldAcceptMyuser() {
    shouldAccept("myuser");
  }

  @Test
  @DisplayName("Should validate myu")
  void shouldAcceptMyu() {
    shouldAccept("myu");
  }

  @Test
  @DisplayName("Should validate mybigusername")
  void shouldAcceptMybigusername() {
    shouldAccept("mybigusername");
  }

  @Test
  @DisplayName("Should validate my_user")
  void shouldAcceptMy_user() {
    shouldAccept("my_user");
  }

  @Test
  @DisplayName("Should validate my.user")
  void shouldAcceptMydotuser() {
    shouldAccept("my.user");
  }

  @Test
  @DisplayName("Should validate my@user")
  void shouldAcceptMyatuser() {
    shouldAccept("my@user");
  }

  @Test
  @DisplayName("Should validate myUser")
  void shouldAcceptmyUser() {
    shouldAccept("myUser");
  }

  @Test
  @DisplayName("Should validate MyUser")
  void shouldAcceptMyUser() {
    shouldAccept("MyUser");
  }

  @Test
  @DisplayName("Should validate M1User")
  void shouldAcceptM1User() {
    shouldAccept("M1User");
  }

  @Test
  @DisplayName("Should validate myuser99")
  void shouldValidate() {
    shouldAccept("myuser99");
  }

  @Test
  @DisplayName("Should not validate \"\"")
  void shouldNotValidateEmptyString() {
    shouldReject("");
  }

  @Test
  @DisplayName("Should not validate null")
  void shouldNotValidateNull() {
    shouldReject(null);
  }

  @Test
  @DisplayName("Should not validate my user")
  void shouldRejectmyspaceuser() {
    shouldReject("my user");
  }

  @Test
  @DisplayName("Should not validate _myuser")
  void shouldReject() {
    shouldReject("_myuser");
  }

  @Test
  @DisplayName("Should not validate 1aaa")
  void shouldReject1aaa() {
    shouldReject("1aaa");
  }

  @Test
  @DisplayName("Should not validate m")
  void shouldRejectM() {
    shouldReject("m");
  }

  @Test
  @DisplayName("Should not validate my")
  void shouldRejectMy() {
    shouldReject("my");
  }

  @Test
  @DisplayName("Should not validate myuser$")
  void shouldRejectMyuser$() {
    shouldReject("myuser$");
  }

  @Test
  @DisplayName("Should not validate my#user")
  void shouldRejectMyhashuser() {
    shouldReject("my#user");
  }
}
