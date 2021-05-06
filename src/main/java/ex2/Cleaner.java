package ex2;

import java.util.regex.Pattern;

public class Cleaner {

  public static String cleanHtml(String html) {
    String output = removeSpecialTags(html);
    output = removeRegularTags(output);
    output = mergeTrimWhiteSpaces(output);
    return output;
  }

  private static String removeSpecialTags(String source) {
    String regex = "<(script|style).*?>.*?</(script|style)>";
    return Pattern.compile(regex, Pattern.DOTALL)
            .matcher(source)
            .replaceAll("");
  }

  private static String removeRegularTags(String source) {
    String regex = "<.*?>";
    return Pattern.compile(regex, Pattern.DOTALL)
            .matcher(source)
            .replaceAll("");
  }

  private static String mergeTrimWhiteSpaces(String source) {
    return source.replaceAll("\\s+", " ")
            .trim();
  }

  public static String removeDuplicates(String text){
    return text.replaceAll("\\b(\\w+)(\\s\\1\\b)+","$1");
  }
}
