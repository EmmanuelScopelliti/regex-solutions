package ex4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static ex4.Parser.extractTitle;

class TitleParserTest {

  @Test
  @DisplayName("Should extract 'Understanding, building and using ontologies'")
  void shouldExtractUnderstanding() {
    final String citation1 =
        "Guarino, N. (1997). Understanding, building and using ontologies. "
            + "International journal of human-computer studies, 46(2-3), 293-310.";

    assertThat(extractTitle(citation1)).isEqualTo("Understanding, building and using ontologies");
  }

  @Test
  @DisplayName("Should extract 'Towards ontological...'")
  void shouldExtractTowardsOntological() {
    final String citation2 =
        "Guizzardi, G., Wagner, G., Almeida, J. P. A., & Guizzardi, R. S. (2015). "
            + "Towards ontological foundations for conceptual modeling: "
            + "The Unified Foundational Ontology (UFO) story. "
            + "Applied ontology, 10(3-4), 259-271.";

    assertThat(extractTitle(citation2))
        .isEqualTo(
            "Towards ontological foundations for conceptual modeling: "
                + "The Unified Foundational Ontology (UFO) story");
  }

  @Test
  @DisplayName(
      "Should extract 'Declarative specification and verification of service choreographiess'")
  void shouldExtractDeclarative() {
    final String citation3 =
        "Montali, M., Pesic, M., Aalst, W. M. V. D., Chesani, F., Mello, P., & Storari, S. (2010). "
            + "Declarative specification and verification of service choreographiess. "
            + "ACM Transactions on the Web, 4(1), 1-62.";

    assertThat(extractTitle(citation3))
        .isEqualTo("Declarative specification and verification of service choreographiess");
  }

  @Test
  @DisplayName("Should extract 'Ontological anti-patterns...'")
  void shouldExtractOntological() {
    final String citation4 =
        "Sales, T. P., & Guizzardi, G. (2015). Ontological anti-patterns: Empirically uncovered "
            + "error-prone structures in ontology-driven conceptual models. "
            + "Data & Knowledge Engineering, 99, 72-104.";

    assertThat(extractTitle(citation4))
        .isEqualTo(
            "Ontological anti-patterns: "
                + "Empirically uncovered error-prone structures in ontology-driven conceptual models");
  }

  @Test
  @DisplayName("Should extract 'A design framework and exemplar metrics for FAIRness'")
  void shouldExtractADesign() {
    final String citation5 =
        "Wilkinson, M. D., Sansone, S. A., Schultes, E., Doorn, P., da Silva Santos, "
            + "L. O. B., & Dumontier, M. (2018). A design framework and exemplar metrics for FAIRness."
            + "Scientific data, 5(1), 1-4.";

    assertThat(extractTitle(citation5))
        .isEqualTo("A design framework and exemplar metrics for FAIRness");
  }

  @Test
  @DisplayName("Should extract 'Telos: Representing knowledge about information systems'")
  void shouldExtract4() {
    final String citation6 =
        "Mylopoulos, J., Borgida, A., Jarke, M., & Koubarakis, M. (1990). "
            + "Telos: Representing knowledge about information systems. "
            + "ACM Transactions on Information Systems (TOIS), 8(4), 325-362.";

    assertThat(extractTitle(citation6))
        .isEqualTo("Telos: Representing knowledge about information systems");
  }

  @Test
  @DisplayName("Should extract 'Alloy: a lightweight object modelling notation'")
  void shouldExtract2() {
    final String citation7 =
        "Jackson, D. (2002). Alloy: a lightweight object modelling notation. "
            + "ACM Transactions on Software Engineering and Methodology (TOSEM), 11(2), 256-290.";

    assertThat(extractTitle(citation7)).isEqualTo("Alloy: a lightweight object modelling notation");
  }
}
