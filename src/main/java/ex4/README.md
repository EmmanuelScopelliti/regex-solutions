## Exercise 4: Parser

Implement, using regular expressions, the seven methods of the [`Parser`](Parse.java) class, all of which extract specific information from a citation of a journal paper formatted in the [APA style](https://en.wikipedia.org/wiki/APA_style).

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

Your code should pass all tests defined in [`ZeroToOneHunderedFinderTest`](../../../test/java/ex3/ZeroToOneHunderedFinderTest.java) and [`AlternatingBitsFinderTest`](../../../test/java/ex3/AlternatingBitsFinderTest.java).
 