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
		key = IndentationCheck.KEY, 
		name = "Line contains inconsistent indentation", 
		description = "This rule imposes a standard number of spaces to be used for indentation. Since whitespace is significant in CoffeeScript, it's critical that a project chooses a standard indentation format and stays consistent. Other roads lead to darkness. <pre> <code># <br/>Enabling this option will prevent this ugly <br/># but otherwise valid CoffeeScript. <br/>twoSpaces = () -> <br/>fourSpaces = () -> <br/>eightSpaces = () -> <br/>'this is valid CoffeeScript'  </code> </pre> Two space indentation is enabled by default.", 
		priority = Priority.MAJOR)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class IndentationCheck {
	public static final String KEY = "indentation";
}
