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
		key = NoUnnecessaryDoubleQuotesCheck.KEY, 
		name = "Unnecessary double quotes are forbidden", 
		description = "This rule prohibits double quotes unless string interpolation is used or the string contains single quotes. <pre> <code># Double quotes are discouraged: <br/>foo = \"bar\"  <br/># Unless string interpolation is used: <br/>foo = \"#{bar}baz\"  <br/># Or they prevent cumbersome escaping: <br/>foo = \"I'm just following the 'rules'\" </code> </pre> Double quotes are permitted by default.", 
		priority = Priority.INFO)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class NoUnnecessaryDoubleQuotesCheck {
	public static final String KEY = "no_unnecessary_double_quotes";
}
