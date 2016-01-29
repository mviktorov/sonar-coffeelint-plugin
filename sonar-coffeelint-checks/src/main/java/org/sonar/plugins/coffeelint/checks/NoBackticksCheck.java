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
		key = NoBackticksCheck.KEY, 
		name = "Backticks are forbidden", 
		description = "Backticks allow snippets of JavaScript to be embedded in CoffeeScript. While some folks consider backticks useful in a few niche circumstances, they should be avoided because so none of JavaScript's \"bad parts\", like <tt>with</tt> and <tt>eval</tt>, sneak into CoffeeScript. This rule is enabled by default.", 
		priority = Priority.MAJOR)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class NoBackticksCheck {
	public static final String KEY = "no_backticks";
}
