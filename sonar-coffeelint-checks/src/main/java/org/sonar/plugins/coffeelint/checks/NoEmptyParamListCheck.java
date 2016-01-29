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
		key = NoEmptyParamListCheck.KEY, 
		name = "Empty parameter list is forbidden", 
		description = "This rule prohibits empty parameter lists in function definitions. <pre> <code># The empty parameter list in here is unnecessary: <br/>myFunction = () -&gt;  <br/># We might favor this instead: <br/>myFunction = -&gt; </code> </pre> Empty parameter lists are permitted by default.", 
		priority = Priority.INFO)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class NoEmptyParamListCheck {
	public static final String KEY = "no_empty_param_list";
}
