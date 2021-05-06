package ex1;

public class Validator {

  /**
   * Examples of strings the method should accept: "01/04/2020", "20/01/2019", "25/12/1950",
   * "30/07/2021", "31/08/1919", "01/01/1729", "10/05/2000", "15/10/2049"
   *
   * <p>Examples of strings the method should reject: "001/04/1900", "01/004/1900", "90/04/1900",
   * "33/04/1900", "01/13/1900", "01/04/19000", "00/04/1900", "01/00/1900", "1/4/00", "1/04/1900",
   * "10/4/1900", "10/04/00", "///", "/04/1900", "01//1900", 01/04/, " 01/04/1900", "This is the
   * date: "01/04/1900"", "01.04.1900", "01-04-1900"
   */
  public static boolean validateDate(String date) {
    String regex = "((0[1-9])|([12][0-9])|(3[01]))/((0[1-9])|(1[0-2]))/\\d{4}";
    return date != null && date.matches(regex);
  }

  /**
   * Examples of strings the method should accept: "Piazza Università, 1, 39100 Bolzano BZ", "Piazza
   * Domenicani, 3, 39100 Bozen-Bolzano BZ", "Via Alessandro Volta, 13, 39100 Bolzano BZ", "Via
   * Calepina, 14, 38122 Trento TN", "Via Calepina 14, 38122 Trento TN", "Via Calepina, 14 38122
   * Trento TN", "Via Calepina 14 38122 Trento TN", "Viale Verona, 187, 38123 Trento TN", "Corso 3
   * Novembre 1918, 130, 38122 Trento TN", "Piazza del Colosseo, 1, 00184 Roma RM", "Piazza di Santa
   * Maria delle Grazie, 2, 20123 Milano MI", "Via Bolzano, 1a, 38121 Trento TN".
   *
   * <p>Examples of strings the method should reject: "Calepina, 14, 38122 Trento TN", "Via, 14,
   * 38122 Trento TN", "Via Calepina, 38122 Trento TN", "Via Calepina, 14, Trento TN", "Via
   * Calepina, 14, 38122 TN", "Via Calepina, 14, 38122 Trento", "Via Calepina, , 38122 Trento TN",
   * "Via Calepina, 14, Trento TN", "Via Calepina, 14, 38122 TN", "Via Calepina, 14, 38122 Trento ",
   * ", 14, 38122 Trento TN", "Street Calepina, 14, 38122 Trento TN", "V. Calepina, 14, 38122 Trento
   * TN", "via Calepina, 14, 38122 Trento TN", "Via Calepina, 14, 381222 Trento TN", "Via Calepina,
   * 14, 38122 Trento TRENTO", "Via Calepina, 14, 38122 Trento tn", "Via Bolzano, a1, 38121 Trento
   * TN", "Via Bolzano, 1a1, 38121 Trento TN",
   */
  public static boolean validateAddress(String address) {
    String regex =
        "(Via|Viale|Corso|Piazza) ([a-zA-Z0-9\\u00C0-\\u017F\\s]+),? (\\d+[a-zA-Z]?),? (\\d{5}) ([\\w-]+) ([A-Z]{2})";
    return address != null && address.matches(regex);
  }

  public static boolean validateUsername(String username) {
    String regex = "[a-zA-Z][\\w_.@]{2,12}";
    return username != null && username.matches(regex);
  }

  public static boolean validateFloatingPoint(String number){
    String regex = "[-+]?(\\d+([.,]\\d*)?|[.,]\\d+)([eE][-+]?\\d+)?";
    return number != null && number.matches(regex);
  }
}
