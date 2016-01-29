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
		key = NoTrailingSemicolonsCheck.KEY, 
		name = "Line contains a trailing semicolon", 
		description = "This rule prohibits trailing semicolons, since they are needless cruft in CoffeeScript. <pre> <code># This semicolon is meaningful. <br/>x = '1234'; console.log(x)  <br/># This semicolon is redundant. <br/>alert('end of line'); </code> </pre> Trailing semicolons are forbidden by default.", 
		priority = Priority.MAJOR)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class NoTrailingSemicolonsCheck {
	public static final String KEY = "no_trailing_semicolons";
}
