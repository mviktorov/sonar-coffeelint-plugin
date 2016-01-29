package org.sonar.plugins.coffeelint.checks;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.check.Priority;
import org.sonar.check.Rule;
import org.sonar.squidbridge.annotations.ActivatedByDefault;
import org.sonar.squidbridge.annotations.SqaleConstantRemediation;
import org.sonar.squidbridge.annotations.SqaleSubCharacteristic;

/**
 * Auto-generated !
 **/
// @formatter:off
@Rule(
		key = MaxLineLengthCheck.KEY, 
		name = "Line exceeds maximum allowed length", 
		description = "This rule imposes a maximum line length on your code. <a href=\"http://www.python.org/dev/peps/pep-0008/\">Python's style guide</a> does a good job explaining why you might want to limit the length of your lines, though this is a matter of taste.  Lines can be no longer than eighty characters by default.", 
		priority = Priority.MAJOR)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class MaxLineLengthCheck {
	public static final String KEY = "max_line_length";
}
