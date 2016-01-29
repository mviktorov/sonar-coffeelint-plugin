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
		key = NoImplicitBracesCheck.KEY, 
		name = "Implicit braces are forbidden", 
		description = "This rule prohibits implicit braces when declaring object literals. Implicit braces can make code more difficult to understand, especially when used in combination with optional parenthesis. <pre> <code># Do you find this code ambiguous? Is it a <br/># function call with three arguments or four? <br/>myFunction a, b, 1:2, 3:4  <br/># While the same code written in a more <br/># explicit manner has no ambiguity. <br/>myFunction(a, b, {1:2, 3:4}) </code> </pre> Implicit braces are permitted by default, since their use is idiomatic CoffeeScript.", 
		priority = Priority.INFO)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class NoImplicitBracesCheck {
	public static final String KEY = "no_implicit_braces";
}
