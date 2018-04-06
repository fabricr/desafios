package idwall.desafio.string;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public class IdwallFormatter extends StringFormatter {

	public IdwallFormatter(int limit) {
		super(limit);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Should format as described in the challenge
	 *
	 * @param text
	 * @param limit
	 * @param justify
	 * @return textLine
	 * @throws Exception
	 */
	@Override
	public String format(String text, int limit, boolean justify) throws Exception {

		String line = "";
		String textLine = "";

		if (text.length() == 0) {
			return textLine = "Text empty";
		}

		try {
			String[] splitText = text.split(" ");

			if ((splitText.length == 1) && (splitText[0].length() < limit)) {
				return textLine = text;
			}

			for (int i = 0; i < splitText.length; i++) {

				String word = splitText[i];

				if (word.length() > limit) {
					return textLine = "Word greater than the maximum line length.";
				}

				if (line.length() + word.length() + 1 > limit) {

					if ((justify) && (line.length() < limit)) {
						line = justifyText(line, limit);
					}

					if (textLine == "") {
						textLine = line;
					} else {
						textLine = textLine + "\n" + line;
					}

					line = word;
				} else if (line.length() == 0) {
					line = word;
				} else if (i + 1 == splitText.length) {
					line = line + " " + word;

					if ((justify) && (line.length() < limit)) {
						line = justifyText(line, limit);
					}

					textLine = textLine + "\n" + line;
				} else {
					line = line + " " + word;
				}
			}
		} catch (Exception e) {
			throw new Exception("Error limiting text lines");
		}

		return textLine;
	}

	/**
	 * Justify text as described in the challenge
	 *
	 * @param line
	 * @param limit
	 * @return justifyLine
	 * @throws Exception
	 */
	public String justifyText(String line, int limit) throws Exception {

		String justifyLine = "";

		try {
			String[] word = line.split(" ");
			int spaces = limit - line.length() + (word.length - 1);

			for (int i = 0; i < word.length - 1 && spaces > 0; i++) {
				word[i] = word[i].concat(" ");

				if (i + 1 == word.length - 1) {
					i = -1;
				}

				spaces--;
			}

			for (int j = 0; j < word.length; j++) {
				justifyLine = justifyLine + word[j];
			}
		} catch (Exception e) {
			throw new Exception("Error justifying text");
		}

		return justifyLine;
	}
}
