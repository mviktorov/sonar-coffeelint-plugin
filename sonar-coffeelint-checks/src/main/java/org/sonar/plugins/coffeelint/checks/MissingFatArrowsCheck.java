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
		key = MissingFatArrowsCheck.KEY, 
		name = "Used `this` in a function without a fat arrow", 
		description = "Warns when you use `this` inside a function that wasn't defined with a fat arrow. This rule does not apply to methods defined in a class, since they have `this` bound to the class instance (or the class itself, for class methods). The option `is_strict` is available for checking bindings of class methods.  It is impossible to statically determine whether a function using `this` will be bound with the correct `this` value due to language features like `Function.prototype.call` and `Function.prototype.bind`, so this rule may produce false positives.", 
		priority = Priority.INFO)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class MissingFatArrowsCheck {
	public static final String KEY = "missing_fat_arrows";
}
