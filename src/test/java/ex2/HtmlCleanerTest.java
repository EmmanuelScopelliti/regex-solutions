package ex2;

import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static ex2.Cleaner.cleanHtml;

class HtmlCleanerTest {
  @Test
  void cleanOrganizedHtml() {
    String html =
            "<div id=\"toc\" class=\"toc\" role=\"navigation\" aria-labelledby=\"mw-toc-heading\">\n"
                    + "<input type=\"checkbox\" role=\"button\" id=\"toctogglecheckbox\" class=\"toctogglecheckbox\" style=\"display:none\">\n"
                    + "<div class=\"toctitle\" lang=\"en\" dir=\"ltr\">\n"
                    + "    <h2 id=\"mw-toc-heading\">Contents</h2>\n"
                    + "    <span class=\"toctogglespan\">\n"
                    + "        <label class=\"toctogglelabel\" for=\"toctogglecheckbox\"></label>\n"
                    + "    </span>\n"
                    + "</div>\n"
                    + "<ul>\n"
                    + "    <li class=\"toclevel-1 tocsection-1\">\n"
                    + "        <a href=\"#Geography\">\n"
                    + "            <span class=\"tocnumber\">1</span>\n"
                    + "            <span class=\"toctext\">Geography</span>\n"
                    + "        </a>\n"
                    + "        <ul>\n"
                    + "            <li class=\"toclevel-2 tocsection-2\">\n"
                    + "                <a href=\"#Location\">\n"
                    + "                    <span class=\"tocnumber\">1.1</span> \n"
                    + "                    <span class=\"toctext\">Location</span>\n"
                    + "                </a>\n"
                    + "            </li>\n"
                    + "            <li class=\"toclevel-2 tocsection-3\">\n"
                    + "                <a href=\"#City_districts_and_neighbouring_communities\">\n"
                    + "                    <span class=\"tocnumber\">1.2</span>\n"
                    + "                    <span class=\"toctext\">City districts and neighbouring communities</span>\n"
                    + "                </a>\n"
                    + "            </li>\n"
                    + "            <li class=\"toclevel-2 tocsection-4\">\n"
                    + "                <a href=\"#Climate\">\n"
                    + "                    <span class=\"tocnumber\">1.3</span>\n"
                    + "                    <span class=\"toctext\">Climate</span>\n"
                    + "                </a>\n"
                    + "            </li>\n"
                    + "        </ul>\n"
                    + "    </li>\n"
                    + "    <li class=\"toclevel-1 tocsection-5\">\n"
                    + "        <a href=\"#Society\">\n"
                    + "            <span class=\"tocnumber\">2</span>\n"
                    + "            <span class=\"toctext\">Society</span>\n"
                    + "        </a>\n"
                    + "        <ul>\n"
                    + "            <li class=\"toclevel-2 tocsection-6\">\n"
                    + "                <a href=\"#Linguistic_distribution\">\n"
                    + "                    <span class=\"tocnumber\">2.1</span>\n"
                    + "                    <span class=\"toctext\">Linguistic distribution</span>\n"
                    + "                </a>\n"
                    + "            </li>\n"
                    + "        </ul>\n"
                    + "    </li>\n"
                    + "</ul>\n"
                    + "</div>";
    String expectedOutput = "Contents "
            + "1 Geography 1.1 Location 1.2 City districts and neighbouring communities 1.3 Climate "
            + "2 Society 2.1 Linguistic distribution";
    String output = cleanHtml(html);
    assertThat(output).isEqualTo(expectedOutput);
  }

  @Test
  void cleanMessyHtml() {
    String html =
            "<p>The <b>Free University of Bozen-Bolzano</b> (<a href=\"/wiki/Italian_language\" title=\"German language\">Italian</a>:\n"
                    + "<i>Libera Università di Bolzano</i>, <a href=\"/wiki/German_language\" title=\"\">German</a>: <i>Freie Universität\n"
                    + "    Bozen</i>, <a href=\"/wiki/Ladin_language\" title=\"Ladin language\">Ladin</a>: <i>Università Liedia de Bulsan</i>)\n"
                    + "is a university primarily located in <a href=\"/wiki/Bolzano\" title=\"\">Bolzano</a>, <a href=\"/wiki/South_Tyrol\"\n"
                    + "                                                                                      title=\"South Tyrol\">South\n"
                    + "    Tyrol</a>, <a href=\"/wiki/Italy\" title=\"Italy\">Italy</a>. It was founded on 31 October 1997 and is organized\n"
                    + "into five Faculties.\n"
                    + "</p>\n"
                    + "<p>The Free University of Bozen-Bolzano (unibz) aims to offer students a multilingual, practice-oriented education that\n"
                    + "meets the demands of the local and the European labor market. Lectures and seminars are held in <a\n"
                    + "        href=\"/wiki/Italian_language\" title=\"Italian language\">Italian</a>, <a href=\"/wiki/German_language\"\n"
                    + "                                                                               title=\"Bolzano\">German</a> and <a\n"
                    + "        href=\"/wiki/English_language\" title=\"English language\">English</a>.<sup id=\"cite_ref-2\" class=\"reference\"><a\n"
                    + "        href=\"#cite_note-2\">[2]</a></sup> The only exception is the Faculty of Education, which offers Italian,\n"
                    + "German and <a href=\"/wiki/Ladin_language\" title=\"\">Ladin</a> speaking students separate training sections. The\n"
                    + "university offers study programmes ranging from bachelor's degrees to doctorates.\n"
                    + "</p>";
    String expectedOutput =
            "The Free University of Bozen-Bolzano (Italian: Libera Università di Bolzano,"
                    + " German: Freie Universität Bozen, Ladin: Università Liedia de Bulsan)"
                    + " is a university primarily located in Bolzano, South Tyrol, Italy."
                    + " It was founded on 31 October 1997 and is organized into five Faculties."
                    + " The Free University of Bozen-Bolzano (unibz) aims to offer students a multilingual,"
                    + " practice-oriented education that meets the demands of the local and the European labor market."
                    + " Lectures and seminars are held in Italian, German and English.[2] The only exception is the"
                    + " Faculty of Education, which offers Italian, German and Ladin speaking students"
                    + " separate training sections. The university offers study programmes ranging"
                    + " from bachelor's degrees to doctorates.";
    String output = cleanHtml(html);
    assertThat(output).isEqualTo(expectedOutput);
  }

  @Test
  void cleanHead() {
    String html =
            "<head>\n"
                    + "<base href=\"https://www.unibz.it/\"/>\n"
                    + "<title>Free University of Bozen-Bolzano</title>\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n"
                    + "<link rel=\"alternate\" hreflang=\"de-DE\" href=\"https://www.unibz.it/de/\">\n"
                    + "<link rel=\"alternate\" hreflang=\"en-GB\" href=\"https://www.unibz.it/\">\n"
                    + "<link rel=\"alternate\" hreflang=\"it-IT\" href=\"https://www.unibz.it/it/\">\n"
                    + "<meta property=\"og:type\" content=\"website\">\n"
                    + "<meta property=\"og:url\" content=\"https://www.unibz.it/\">\n"
                    + "<meta property=\"og:locale\" content=\"en_GB\">\n"
                    + "<meta property=\"og:title\" content=\"Free University of Bozen-Bolzano\">\n"
                    + "<link rel=\"icon\" type=\"image/png\" href=\"/_resources/themes/unibz/images/fav/favicon-16x16.png\" sizes=\"16x16\">\n"
                    + "<script type=\"text/javascript\" async=\"\" src=\"https://www.google-analytics.com/analytics.js\">\n"
                    + "</script>\n"
                    + "<script async=\"\" src=\"https://www.googletagmanager.com/gtag/js?id=UA-75897677-1\"></script>\n"
                    + "<script>\n"
                    + "    window.dataLayer = window.dataLayer || [];\n"
                    + "    function gtag(){dataLayer.push(arguments);}\n"
                    + "    gtag('js', new Date());\n"
                    + "    gtag('config', 'UA-19861019-1');\n"
                    + "</script>\n"
                    + "<link rel=\"stylesheet\" type=\"text/css\" href=\"/_resources/themes/unibz/css/main.css?m=1619531446\">\n"
                    + "<style type=\"text/css\" id=\"CookieConsentStateDisplayStyles\">\n"
                    + "    .cookieconsent-optin,.cookieconsent-optin-preferences,.cookieconsent-optin-statistics," +
                    ".cookieconsent-optin-marketing{display:block;display:initial;}.cookieconsent-optout-preferences," +
                    ".cookieconsent-optout-statistics,.cookieconsent-optout-marketing,.cookieconsent-optout{display:none;}\n"
                    + "</style>\n"
                    + "</head>";
    String expectedOutput = "Free University of Bozen-Bolzano";
    String output = cleanHtml(html);
    assertThat(output).isEqualTo(expectedOutput);
  }
}
