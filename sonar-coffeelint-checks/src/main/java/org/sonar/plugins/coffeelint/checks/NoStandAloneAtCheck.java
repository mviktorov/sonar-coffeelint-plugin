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
		key = NoStandAloneAtCheck.KEY, 
		name = "@ must not be used stand alone", 
		description = "This rule checks that no stand alone @ are in use, they are discouraged. Further information in CoffeeScript issue <a href=\"https://github.com/jashkenas/coffee-script/issues/1601\"> #1601</a>", 
		priority = Priority.INFO)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class NoStandAloneAtCheck {
	public static final String KEY = "no_stand_alone_at";
}
