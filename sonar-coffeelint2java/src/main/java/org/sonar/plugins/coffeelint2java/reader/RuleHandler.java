package org.sonar.plugins.coffeelint2java.reader;

import java.util.function.Consumer;

/**
 * Reads and process rules
 * 
 * @author andreas
 *
 */
public interface RuleHandler {

	/**
	 * Init the rules. Must be called before the other two methods
	 */
	void initRules();

	/**
	 * Returns an unique name of the handler
	 * 
	 * @return
	 */
	String getRuleClassName();

	/**
	 * Process the line and pass it to the gievn {@link Consumer}
	 * 
	 * @param line
	 * @param cons
	 */
	void processLine(String line, Consumer<String> cons);
}
