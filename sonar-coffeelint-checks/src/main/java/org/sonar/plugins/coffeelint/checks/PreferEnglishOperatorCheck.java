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
		key = PreferEnglishOperatorCheck.KEY, 
		name = "Don\'t use &&, ||, ==, !=, or !", 
		description = "This rule prohibits &&, ||, ==, != and !. Use and, or, is, isnt, and not instead. !! for converting to a boolean is ignored.", 
		priority = Priority.INFO)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class PreferEnglishOperatorCheck {
	public static final String KEY = "prefer_english_operator";
}
