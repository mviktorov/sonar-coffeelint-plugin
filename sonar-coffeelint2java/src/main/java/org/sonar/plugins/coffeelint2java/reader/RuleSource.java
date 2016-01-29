package org.sonar.plugins.coffeelint2java.reader;

import java.util.List;

/**
 * Abstraction to retrieve rules
 * 
 * @author andreas
 *
 */
public interface RuleSource {
	/**
	 * Returns all rules
	 * 
	 * @return
	 */
	List<String> rulesByLine();

	/**
	 * Common name of the rules
	 * 
	 * @return
	 */
	String name();
}
