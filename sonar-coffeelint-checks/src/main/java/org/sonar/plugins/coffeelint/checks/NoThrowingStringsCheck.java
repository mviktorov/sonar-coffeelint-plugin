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
		key = NoThrowingStringsCheck.KEY, 
		name = "Throwing strings is forbidden", 
		description = "This rule forbids throwing string literals or interpolations. While JavaScript (and CoffeeScript by extension) allow any expression to be thrown, it is best to only throw <a href=\"https://developer.mozilla.org /en/JavaScript/Reference/Global_Objects/Error\"> Error</a> objects, because they contain valuable debugging information like the stack trace. Because of JavaScript's dynamic nature, CoffeeLint cannot ensure you are always throwing instances of <tt>Error</tt>. It will only catch the simple but real case of throwing literal strings. <pre> <code># CoffeeLint will catch this: <br/>throw \"i made a boo boo\"  <br/># ... but not this: <br/>throw getSomeString() </code> </pre> This rule is enabled by default.", 
		priority = Priority.MAJOR)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class NoThrowingStringsCheck {
	public static final String KEY = "no_throwing_strings";
}
