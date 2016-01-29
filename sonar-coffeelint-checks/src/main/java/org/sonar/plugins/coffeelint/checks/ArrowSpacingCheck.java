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
		key = ArrowSpacingCheck.KEY, 
		name = "Function arrows (-> and =>) must be spaced properly", 
		description = "<p>This rule checks to see that there is spacing before and after the arrow operator that declares a function. This rule is disabled by default.</p> <p>Note that if arrow_spacing is enabled, and you pass an empty function as a parameter, arrow_spacing will accept either a space or no space in-between the arrow operator and the parenthesis</p> <pre><code># Both of this will not trigger an error, <br/># even with arrow_spacing enabled. <br/>x(-> 3) <br/>x( -> 3)  <br/># However, this will trigger an error <br/>x((a,b)-> 3) </code> </pre>", 
		priority = Priority.INFO)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class ArrowSpacingCheck {
	public static final String KEY = "arrow_spacing";
}
