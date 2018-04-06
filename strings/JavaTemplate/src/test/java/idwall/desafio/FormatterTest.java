package idwall.desafio;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import idwall.desafio.string.IdwallFormatter;

class FormatterTest {

	@Test
	void testFormat() throws Exception {
		int limit = 40;
		String text = "In the beginning God created the heavens and the earth. Now the earth was";
		String result = "In the beginning God created the heavens\nand the earth. Now the earth was";
		boolean justify = false;
		
		IdwallFormatter id = new IdwallFormatter(limit);

		assertEquals(result, id.format(text, id.getLimit(), justify));
	}

	@Test
	void testJustifyText() throws Exception {
		int limit = 40;
		String text = "and the earth. Now the earth was";
		String result = "and   the   earth.  Now  the  earth  was";
		
		IdwallFormatter id = new IdwallFormatter(limit);
		
		assertEquals(result, id.justifyText(text, id.getLimit()));
	}
	
	@Test
	void IdwallFormatterTest() throws Exception {
		int limit = 40;
		String text = "In the beginning God created the heavens and the earth. Now the earth was";
		String result = "In the beginning God created the heavens\nand   the   earth.  Now  the  earth  was";
		boolean justify = true;
		
		IdwallFormatter id = new IdwallFormatter(limit);
		assertEquals(result, id.format(text, id.getLimit(), justify));
	}
}
