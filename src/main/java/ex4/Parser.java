package ex4;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

  private static final Pattern authorPattern = Pattern.compile("([\\w ]+, (\\w\\.[ ,])+( &)?)+");

  /**
   * Returns a string containing the authors of the paper.
   *
   * <p>For instance, given "Jackson, D. (2002). Alloy: a lightweight object modelling notation. ACM
   * Transactions on Software Engineering and Methodology (TOSEM), 11(2), 256-290.", the method
   * returns "Jackson, D."
   */
  public static String extractAuthors(String citation) {
    Matcher matcher = authorPattern.matcher(citation);
    return matcher.find() ? matcher.group().trim() : null;
  }

  private static final Pattern yearPattern = Pattern.compile("\\((\\d{4})\\)");

  /**
   * Returns a string containing the year when the paper was published.
   *
   * <p>For instance, given "Jackson, D. (2002). Alloy: a lightweight object modelling notation. ACM
   * Transactions on Software Engineering and Methodology (TOSEM), 11(2), 256-290.", the method
   * returns "2002"
   */
  public static String extractYear(String citation) {
    Matcher matcher = yearPattern.matcher(citation);
    return matcher.find() ? matcher.group(1) : null;
  }

  private static final Pattern titlePattern = Pattern.compile("\\)\\. (.*?)\\.");

  /**
   * Returns a string containing the title of the paper.
   *
   * <p>For instance, given "Jackson, D. (2002). Alloy: a lightweight object modelling notation. ACM
   * Transactions on Software Engineering and Methodology (TOSEM), 11(2), 256-290.", the method
   * returns "Alloy: a lightweight object modelling notation"
   */
  public static String extractTitle(String citation) {
    Matcher matcher = titlePattern.matcher(citation);
    return matcher.find() ? matcher.group(1) : null;
  }

  private static final Pattern journalTitlePattern = Pattern.compile("\\)\\. .*?\\. (.*?),");

  /**
   * Returns a string containing the title of the journal where the paper was published.
   *
   * <p>For instance, given "Jackson, D. (2002). Alloy: a lightweight object modelling notation. ACM
   * Transactions on Software Engineering and Methodology (TOSEM), 11(2), 256-290.", the method
   * returns "ACM Transactions on Software Engineering and Methodology (TOSEM)"
   */
  public static String extractJournalTitle(String citation) {
    Matcher matcher = journalTitlePattern.matcher(citation);
    return matcher.find() ? matcher.group(1) : null;
  }

  private static final Pattern volumePattern = Pattern.compile(", (\\d+)[(,]");

  /**
   * Returns an integer that identifies the volume in which the paper was published.
   *
   * <p>For instance, given "Jackson, D. (2002). Alloy: a lightweight object modelling notation. ACM
   * Transactions on Software Engineering and Methodology (TOSEM), 11(2), 256-290.", the method
   * returns 11
   */
  public static Integer extractVolume(String citation) {
    Matcher matcher = volumePattern.matcher(citation);
    return matcher.find() ? Integer.parseInt(matcher.group(1)) : null;
  }

  private static final Pattern numberPattern = Pattern.compile("\\d+\\(((\\d+-\\d+)|(\\d+))\\)");

  /**
   * Returns a string that identifies the issue of the volume in which the paper was published.
   *
   * <p>For instance, given "Jackson, D. (2002). Alloy: a lightweight object modelling notation. ACM
   * Transactions on Software Engineering and Methodology (TOSEM), 11(2), 256-290.", the method
   * returns "2"
   */
  public static String extractNumber(String citation) {
    Matcher matcher = numberPattern.matcher(citation);
    return matcher.find() ? matcher.group(1) : null;
  }

  private static final Pattern pagesPattern = Pattern.compile("(\\d+)-(\\d+)\\.");


  /**
   * Returns a list with two integers identifying the pages of the issue in which the paper was published.
   *
   * <p>For instance, given "Jackson, D. (2002). Alloy: a lightweight object modelling notation. ACM
   * Transactions on Software Engineering and Methodology (TOSEM), 11(2), 256-290.", the method
   * returns [256, 290]
   */
  public static List<Integer> extractPages(String citation) {
    Matcher matcher = pagesPattern.matcher(citation);
    if (matcher.find()) {
      String minGroup = matcher.group(1);
      int min = Integer.parseInt(minGroup);

      String maxGroup = matcher.group(2);
      int max = Integer.parseInt(maxGroup);

      return List.of(min, max);
    }

    return List.of();
  }
}
