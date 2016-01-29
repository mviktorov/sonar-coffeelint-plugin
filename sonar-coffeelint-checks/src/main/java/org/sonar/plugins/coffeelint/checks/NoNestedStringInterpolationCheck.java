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
		key = NoNestedStringInterpolationCheck.KEY, 
		name = "Nested string interpolation is forbidden", 
		description = "This rule warns about nested string interpolation, as it tends to make code harder to read and understand. <pre> <code># Good! <br/>str = \"Book by #{firstName.toUpperCase()} #{lastName.toUpperCase()}\"  <br/># Bad! <br/>str = \"Book by #{\"#{firstName} #{lastName}\".toUpperCase()}\" </code> </pre>", 
		priority = Priority.MINOR)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class NoNestedStringInterpolationCheck {
	public static final String KEY = "no_nested_string_interpolation";
}
