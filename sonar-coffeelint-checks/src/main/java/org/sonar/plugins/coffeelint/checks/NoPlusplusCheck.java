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
		key = NoPlusplusCheck.KEY, 
		name = "The increment and decrement operators are forbidden", 
		description = "This rule forbids the increment and decrement arithmetic operators. Some people believe the <tt>++</tt> and <tt>--</tt> to be cryptic and the cause of bugs due to misunderstandings of their precedence rules. This rule is disabled by default.", 
		priority = Priority.INFO)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class NoPlusplusCheck {
	public static final String KEY = "no_plusplus";
}
