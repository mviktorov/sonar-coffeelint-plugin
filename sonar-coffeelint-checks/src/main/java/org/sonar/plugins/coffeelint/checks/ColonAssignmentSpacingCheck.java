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
		key = ColonAssignmentSpacingCheck.KEY, 
		name = "Colon assignment without proper spacing", 
		description = "<p>This rule checks to see that there is spacing before and after the colon in a colon assignment (i.e., classes, objects). The spacing amount is specified by spacing.left and spacing.right, respectively. A zero value means no spacing required. </p> <pre><code> <br/># <br/># If spacing.left and spacing.right is 1 <br/>#  <br/># Doesn't throw an error <br/>object = {spacing : true} <br/>class Dog <br/>canBark : true  <br/># Throws an error <br/>object = {spacing: true} <br/>class Cat <br/>canBark: false </code></pre>", 
		priority = Priority.INFO)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class ColonAssignmentSpacingCheck {
	public static final String KEY = "colon_assignment_spacing";
}
