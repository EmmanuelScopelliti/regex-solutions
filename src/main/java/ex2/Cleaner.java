package ex2;

import java.util.regex.Pattern;

public class Cleaner {

  /**
   * Returns a copy of the input string without HTML tags, javascript code, and css styles, but
   * keeping its content.
   *
   * <p>For instance, given "<b>Hello World</b>", the method returns "Hello World"
   */
  public static String cleanHtml(String html) {
    String output = removeSpecialTags(html);
    output = removeRegularTags(output);
    output = mergeTrimWhiteSpaces(output);
    return output;
  }

  private static String removeSpecialTags(String source) {
    String regex = "<(script|style).*?>.*?</(script|style)>";
    return Pattern.compile(regex, Pattern.DOTALL).matcher(source).replaceAll("");
  }

  private static String removeRegularTags(String source) {
    String regex = "<.*?>";
    return Pattern.compile(regex, Pattern.DOTALL).matcher(source).replaceAll("");
  }

  private static String mergeTrimWhiteSpaces(String source) {
    return source.replaceAll("\\s+", " ").trim();
  }

  /**
   * Returns a copy of the input string without repeated words in a sequence.
   *
   * <p>For instance, from "This is is is an an example" this method returns "This is an example".
   */
  public static String cleanDuplicates(String text) {
    return text.replaceAll("\\b(\\w+)(\\s\\1\\b)+", "$1");
  }
}
