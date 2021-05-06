package ex1;

public class Validator {

  /**
   * Returns true if the string as a whole is a date formatted as 30/12/2020.
   *
   * <p>See src/test/resources/ex1/dates.txt for a set of valid and invalid dates.
   */
  public static boolean validateDate(String date) {
    String regex = "((0[1-9])|([12][0-9])|(3[01]))/((0[1-9])|(1[0-2]))/\\d{4}";
    return date != null && date.matches(regex);
  }

  /**
   * Returns true if the string as a whole is an italian address, that is, it contains a street
   * type, a street name, a number, a postal code, a city, and a province. Possible street types are
   * Via, Viale, Corso, or Piazza. Street names may contain characters with accents (e.g. ä, á, à,
   * é).
   *
   * <p>Here is an example of a valid address: Piazza Università, 1, 39100 Bolzano BZ
   *
   * <p>See src/test/resources/ex1/addresses.txt for a set of valid and invalid addresses.
   */
  public static boolean validateAddress(String address) {
    String regex =
        "(Via|Viale|Corso|Piazza) ([a-zA-Z0-9\\u00C0-\\u017F\\s]+),? (\\d+[a-zA-Z]?),? (\\d{5}) ([\\w-]+) ([A-Z]{2})";
    return address != null && address.matches(regex);
  }

  /**
   * Returns true if the string as a whole is a valid username, which must comply with the following
   * conditions: have between 2 and 12 characters, start with a letter, contain only letters,
   * numbers, underscores (_), dots (.) and ats (@).
   *
   * <p>See src/test/resources/ex1/usernames.txt for a set of valid and invalid usernames.
   */
  public static boolean validateUsername(String username) {
    String regex = "[a-zA-Z][\\w.@]{2,11}";
    return username != null && username.matches(regex);
  }

  /**
   * Returns true if the string as a whole is a valid floating point. Discover the rules for
   * floating points by going through the positive and negative examples in
   * src/test/resources/ex1/floats.txt.
   */
  public static boolean validateFloatingPoint(String number) {
    String regex = "[-+]?(\\d+([.,]\\d*)?|[.,]\\d+)([eE][-+]?\\d+)?";
    return number != null && number.matches(regex);
  }
}
