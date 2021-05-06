package ex4;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CitationParser {

  private static final Pattern authorPattern = Pattern.compile("([\\w ]+, (\\w\\.[ ,])+( &)?)+");

  public static String extractAuthors(String citation) {
    Matcher matcher = authorPattern.matcher(citation);
    return matcher.find() ? matcher.group().trim() : null;
  }

  private static final Pattern yearPattern = Pattern.compile("\\((\\d{4})\\)");

  public static String extractYear(String citation) {
    Matcher matcher = yearPattern.matcher(citation);
    return matcher.find() ? matcher.group(1) : null;
  }

  private static final Pattern titlePattern = Pattern.compile("\\)\\. (.*?)\\.");

  public static String extractTitle(String citation) {
    Matcher matcher = titlePattern.matcher(citation);
    return matcher.find() ? matcher.group(1) : null;
  }

  private static final Pattern journalTitlePattern = Pattern.compile("\\)\\. .*?\\. (.*?),");

  public static String extractJournalTitle(String citation) {
    Matcher matcher = journalTitlePattern.matcher(citation);
    return matcher.find() ? matcher.group(1) : null;
  }

  private static final Pattern volumePattern = Pattern.compile(", (\\d+)[(,]");

  public static Integer extractVolume(String citation) {
    Matcher matcher = volumePattern.matcher(citation);
    return matcher.find() ? Integer.parseInt(matcher.group(1)) : null;
  }

  private static final Pattern numberPattern = Pattern.compile("\\d+\\(((\\d+-\\d+)|(\\d+))\\)");

  public static String extractNumber(String citation) {
    Matcher matcher = numberPattern.matcher(citation);
    return matcher.find() ? matcher.group(1) : null;
  }

  private static final Pattern pagesPattern = Pattern.compile("(\\d+)-(\\d+)\\.");

  public static List<Integer> extractPages(String citation) {
    Matcher matcher = pagesPattern.matcher(citation);
    if(matcher.find()){
      String minGroup = matcher.group(1);
      int min = Integer.parseInt(minGroup);

      String maxGroup = matcher.group(2);
      int max = Integer.parseInt(maxGroup);

      return List.of(min,max);
    }

    return List.of();
  }
}
