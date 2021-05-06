package ex4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static ex4.Parser.extractJournalTitle;

class JournalTitleParserTest {

  @Test
  @DisplayName("Should extract 'International journal of human-computer studies'")
  void shouldExtractInternational() {
    final String citation1 =
        "Guarino, N. (1997). Understanding, building and using ontologies. "
            + "International journal of human-computer studies, 46(2-3), 293-310.";

    assertThat(extractJournalTitle(citation1))
        .isEqualTo("International journal of human-computer studies");
  }

  @Test
  @DisplayName("Should extract 'Applied ontology'")
  void shouldExtractAppliedOntology() {
    final String citation2 =
        "Guizzardi, G., Wagner, G., Almeida, J. P. A., & Guizzardi, R. S. (2015). "
            + "Towards ontological foundations for conceptual modeling: "
            + "The Unified Foundational Ontology (UFO) story. "
            + "Applied ontology, 10(3-4), 259-271.";

    assertThat(extractJournalTitle(citation2)).isEqualTo("Applied ontology");
  }

  @Test
  @DisplayName("Should extract 'ACM Transactions on the Web'")
  void shouldExtractAcmWeb() {
    final String citation3 =
        "Montali, M., Pesic, M., Aalst, W. M. V. D., Chesani, F., Mello, P., & Storari, S. (2010). "
            + "Declarative specification and verification of service choreographiess. "
            + "ACM Transactions on the Web, 4(1), 1-62.";

    assertThat(extractJournalTitle(citation3)).isEqualTo("ACM Transactions on the Web");
  }

  @Test
  @DisplayName("Should extract 'Data & Knowledge Engineering'")
  void shouldExtractDKE() {
    final String citation4 =
        "Sales, T. P., & Guizzardi, G. (2015). Ontological anti-patterns: Empirically uncovered "
            + "error-prone structures in ontology-driven conceptual models. "
            + "Data & Knowledge Engineering, 99, 72-104.";

    assertThat(extractJournalTitle(citation4)).isEqualTo("Data & Knowledge Engineering");
  }

  @Test
  @DisplayName("Should extract 'Scientific data'")
  void shouldExtractScientificData() {
    final String citation5 =
        "Wilkinson, M. D., Sansone, S. A., Schultes, E., Doorn, P., da Silva Santos, "
            + "L. O. B., & Dumontier, M. (2018). A design framework and exemplar metrics for FAIRness. "
            + "Scientific data, 5(1), 1-4.";

    assertThat(extractJournalTitle(citation5)).isEqualTo("Scientific data");
  }

  @Test
  @DisplayName("Should extract 'ACM Transactions on Information Systems (TOIS)'")
  void shouldExtractTois() {
    final String citation6 =
        "Mylopoulos, J., Borgida, A., Jarke, M., & Koubarakis, M. (1990). "
            + "Telos: Representing knowledge about information systems. "
            + "ACM Transactions on Information Systems (TOIS), 8(4), 325-362.";

    assertThat(extractJournalTitle(citation6)).isEqualTo("ACM Transactions on Information Systems (TOIS)");
  }

  @Test
  @DisplayName("Should extract 'ACM Transactions on Software Engineering and Methodology (TOSEM)'")
  void shouldExtractTosem() {
    final String citation7 =
        "Jackson, D. (2002). Alloy: a lightweight object modelling notation. "
            + "ACM Transactions on Software Engineering and Methodology (TOSEM), 11(2), 256-290.";

    assertThat(extractJournalTitle(citation7))
        .isEqualTo("ACM Transactions on Software Engineering and Methodology (TOSEM)");
  }
}
