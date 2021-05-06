## Exercise 4: Parser

Implement, using regular expressions, the seven methods of the [`Parser`](Parser.java) class, all of which extract specific information from a citation of a journal paper formatted in the [APA style](https://en.wikipedia.org/wiki/APA_style).

- `String extractAuthors(String citation)`
- `String extractYear(String citation)`
- `String extractTitle(String citation)`
- `String extractJournalTitle(String citation)`
- `Integer extractVolume(String citation)`
- `String extractNumber(String citation)`
- `List<Integer> extractPages(String citation)`

Given the citation:

`Mylopoulos, J., Borgida, A., Jarke, M., & Koubarakis, M. (1990). Telos: Representing knowledge about information systems. ACM Transactions on Information Systems (TOIS), 8(4), 325-362.`

The methods should return:

- Authors: `"Mylopoulos, J., Borgida, A., Jarke, M., & Koubarakis, M."`
- Year: `"1990"`
- Title: `"Telos: Representing knowledge about information systems"`
- Journal Title: `"ACM Transactions on Information Systems (TOIS)"`
- Volume: `8`
- Number: `"4"`
- Pages: `[324, 362]`

Your code should pass all tests defined in [`AuthorParserTest`](../../../test/java/ex4/AuthorParserTest.java), [`YearParserTest`](../../../test/java/ex4/YearParserTest.java), [`TitleParserTest`](../../../test/java/ex4/TitleParserTest.java), [`JournalTitleParserTest`](../../../test/java/ex4/JournalTitleParserTest.java), [`VolumeParserTest`](../../../test/java/ex4/VolumeParserTest.java), [`NumberParserTest`](../../../test/java/ex4/NumberParserTest.java), and [`PagesParserTest`](../../../test/java/ex4/PagesParserTest.java).
 