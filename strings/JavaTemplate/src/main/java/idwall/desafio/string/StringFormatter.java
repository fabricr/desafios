package idwall.desafio.string;

/**
 * Created by Rodrigo Catão Araujo on 06/02/2018.
 */
public abstract class StringFormatter {

	private Integer limit;

	public StringFormatter(int limit) {
		this.setLimit(limit);
	}


	/**
	 * It receives a text and should format this text
	 *
	 * @param text
	 * @param limit
	 * @param justify
	 * @return textLine
	 * @throws Exception
	 */
	public abstract String format(String text, int limit, boolean justify) throws Exception;

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}
