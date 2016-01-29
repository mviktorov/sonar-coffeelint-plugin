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
		key = NewlinesAfterClassesCheck.KEY, 
		name = "Wrong count of newlines between a class and other code", 
		description = "<p>Checks the number of newlines between classes and other code.</p>  Options: - <pre><code>value</code></pre> - The number of required newlines <br/>after class definitions. Defaults to 3.", 
		priority = Priority.INFO)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class NewlinesAfterClassesCheck {
	public static final String KEY = "newlines_after_classes";
}
