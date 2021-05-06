package ex4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;
import static ex4.Parser.extractAuthors;

class AuthorParserTest {

  @Test
  @DisplayName("Should extract 'Guarino, N.'")
  void shouldExtractGuarino() {
    final String citation1 =
        "Guarino, N. (1997). Understanding, building and using ontologies. "
            + "International journal of human-computer studies, 46(2-3), 293-310.";

    assertThat(extractAuthors(citation1)).isEqualTo("Guarino, N.");
  }

  @Test
  @DisplayName("Should extract 'Guizzardi, G., Wagner, G., Almeida, J. P. A., & Guizzardi, R. S.'")
  void shouldExtractGuizzardiEtAl() {
    final String citation2 =
        "Guizzardi, G., Wagner, G., Almeida, J. P. A., & Guizzardi, R. S. (2015). "
            + "Towards ontological foundations for conceptual modeling: The Unified Foundational Ontology (UFO) story. s"
            + "Applied ontology, 10(3-4), 259-271.";

    assertThat(extractAuthors(citation2))
        .isEqualTo("Guizzardi, G., Wagner, G., Almeida, J. P. A., & Guizzardi, R. S.");
  }

  @Test
  @DisplayName("Should extract 'Montali...'")
  void shouldExtractMontaliEtAl() {
    final String citation3 =
        "Montali, M., Pesic, M., Aalst, W. M. V. D., Chesani, F., Mello, P., & Storari, S. (2010). "
            + "Declarative specification and verification of service choreographiess. "
            + "ACM Transactions on the Web, 4(1), 1-62.";

    assertThat(extractAuthors(citation3))
        .isEqualTo(
            "Montali, M., Pesic, M., Aalst, W. M. V. D., Chesani, F., Mello, P., & Storari, S.");
  }

  @Test
  @DisplayName("Should extract 'Sales, T. P., & Guizzardi, G.'")
  void shouldExtractSalesAndGuizzardi() {
    final String citation4 =
        "Sales, T. P., & Guizzardi, G. (2015). Ontological anti-patterns: Empirically uncovered "
            + "error-prone structures in ontology-driven conceptual models. "
            + "Data & Knowledge Engineering, 99, 72-104.";

    assertThat(extractAuthors(citation4)).isEqualTo("Sales, T. P., & Guizzardi, G.");
  }

  @Test
  @DisplayName("Should extract 'Wilkinson...'")
  void shouldExtractWilkinsonEtAl() {
    final String citation5 =
        "Wilkinson, M. D., Sansone, S. A., Schultes, E., Doorn, P., da Silva Santos, "
            + "L. O. B., & Dumontier, M. (2018). A design framework and exemplar metrics for FAIRness."
            + "Scientific data, 5(1), 1-4.";

    assertThat(extractAuthors(citation5))
        .isEqualTo(
            "Wilkinson, M. D., Sansone, S. A., Schultes, E., Doorn, P., da Silva Santos, L. O. B., & Dumontier, M.");
  }

  @Test
  @DisplayName("Should extract 'Mylopoulos, J., Borgida, A., Jarke, M., & Koubarakis, M.'")
  void shouldExtractMylopoulosEtAl() {
    final String citation6 =
        "Mylopoulos, J., Borgida, A., Jarke, M., & Koubarakis, M. (1990). "
            + "Telos: Representing knowledge about information systems. "
            + "ACM Transactions on Information Systems (TOIS), 8(4), 325-362.";

    assertThat(extractAuthors(citation6))
        .isEqualTo("Mylopoulos, J., Borgida, A., Jarke, M., & Koubarakis, M.");
  }

  @Test
  @DisplayName("Should extract 'Jackson, D.'")
  void shouldExtractJackson() {
    final String citation7 =
        "Jackson, D. (2002). Alloy: a lightweight object modelling notation. "
            + "ACM Transactions on Software Engineering and Methodology (TOSEM), 11(2), 256-290.";

    assertThat(extractAuthors(citation7)).isEqualTo("Jackson, D.");
  }
}
