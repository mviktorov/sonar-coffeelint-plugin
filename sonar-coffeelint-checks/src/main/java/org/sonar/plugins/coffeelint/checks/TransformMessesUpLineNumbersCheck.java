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
		key = TransformMessesUpLineNumbersCheck.KEY, 
		name = "Transforming source messes up line numbers", 
		description = "This rule detects when changes are made by transform function, and warns that line numbers are probably incorrect.", 
		priority = Priority.MINOR)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class TransformMessesUpLineNumbersCheck {
	public static final String KEY = "transform_messes_up_line_numbers";
}
