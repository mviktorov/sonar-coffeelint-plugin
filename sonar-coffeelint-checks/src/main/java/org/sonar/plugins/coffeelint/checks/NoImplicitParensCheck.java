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
		key = NoImplicitParensCheck.KEY, 
		name = "Implicit parens are forbidden", 
		description = "This rule prohibits implicit parens on function calls. <pre> <code># Some folks don't like this style of coding. <br/>myFunction a, b, c  <br/># And would rather it always be written like this: <br/>myFunction(a, b, c) </code> </pre> Implicit parens are permitted by default, since their use is idiomatic CoffeeScript.", 
		priority = Priority.INFO)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class NoImplicitParensCheck {
	public static final String KEY = "no_implicit_parens";
}
