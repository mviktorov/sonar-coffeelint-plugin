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
		key = NoEmptyFunctionsCheck.KEY, 
		name = "Empty function", 
		description = "Disallows declaring empty functions. The goal of this rule is that unintentional empty callbacks can be detected: <pre> <code>someFunctionWithCallback -> <br/>doSomethingSignificant() </code> </pre> The problem is that the call to <tt>doSomethingSignificant</tt> will be made regardless of <tt>someFunctionWithCallback</tt>'s execution. It can be because you did not indent the call to <tt>doSomethingSignificant</tt> properly.  If you really meant that <tt>someFunctionWithCallback</tt> should call a callback that does nothing, you can write your code this way: <pre> <code>someFunctionWithCallback -> <br/>undefined <br/>doSomethingSignificant() </code> </pre>", 
		priority = Priority.INFO)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class NoEmptyFunctionsCheck {
	public static final String KEY = "no_empty_functions";
}
