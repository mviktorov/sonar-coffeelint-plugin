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
		key = NoInterpolationInSingleQuotesCheck.KEY, 
		name = "Interpolation in single quoted strings is forbidden", 
		description = "This rule prohibits string interpolation in a single quoted string. <pre> <code># String interpolation in single quotes is not allowed: <br/>foo = '#{bar}'  <br/># Double quotes is OK of course <br/>foo = \"#{bar}\" </code> </pre> String interpolation in single quoted strings is permitted by default.", 
		priority = Priority.INFO)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class NoInterpolationInSingleQuotesCheck {
	public static final String KEY = "no_interpolation_in_single_quotes";
}
