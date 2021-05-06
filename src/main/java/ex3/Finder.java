package ex3;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.toList;

public class Finder {

  /**
   * Finds all positive integers between 0 and 100 in a string.
   *
   * <p>This exercise is based on quiz 12 from regex101.com. See original at
   * https://regex101.com/quiz/12
   *
   * <p>HINT: You may want to use a negative lookbehind (?<!...) See more at
   * https://www.regular-expressions.info/lookaround.html
   */
  public static List<Integer> findZeroToOneHundred(String text) {
    String regex = "\\b(?:(?<!-)(\\d{1,2})|100)\\b";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);

    return matcher.results().map(MatchResult::group).map(Integer::parseInt).collect(toList());
  }

  /**
   * Finds all bit sequences which are alternating between 1 and 0, i.e., those that do not have
   * more than 1 or 0 in a row.
   *
   * <p>This exercise is inspired on quiz 13 from regex101.com. See original at
   * https://regex101.com/quiz/13
   */
  public static List<String> findAlternatingBits(String text) {
    String regex = "\\b(0|1|((01)+0?)|((10)+1?))\\b";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(text);

    return matcher.results().map(MatchResult::group).collect(toList());
  }
}
