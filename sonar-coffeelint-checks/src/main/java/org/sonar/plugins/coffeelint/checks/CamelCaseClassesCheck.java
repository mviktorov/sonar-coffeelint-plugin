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
		key = CamelCaseClassesCheck.KEY, 
		name = "Class name should be UpperCamelCased", 
		description = "This rule mandates that all class names are UpperCamelCased. Camel casing class names is a generally accepted way of distinguishing constructor functions - which require the 'new' prefix to behave properly - from plain old functions. <pre> <code># Good! <br/>class BoaConstrictor  <br/># Bad! <br/>class boaConstrictor </code> </pre> This rule is enabled by default.", 
		priority = Priority.MAJOR)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class CamelCaseClassesCheck {
	public static final String KEY = "camel_case_classes";
}
