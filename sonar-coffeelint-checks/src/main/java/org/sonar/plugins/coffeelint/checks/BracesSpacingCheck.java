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
		key = BracesSpacingCheck.KEY, 
		name = "Curly braces must have the proper spacing", 
		description = "This rule checks to see that there is the proper spacing inside curly braces. The spacing amount is specified by \"spaces\". The spacing amount for empty objects is specified by \"empty_object_spaces\".  <pre><code> <br/># Spaces is 0 <br/>{a: b}     # Good <br/>{a: b }    # Bad <br/>{ a: b}    # Bad <br/>{ a: b }   # Bad  <br/># Spaces is 1 <br/>{a: b}     # Bad <br/>{a: b }    # Bad <br/>{ a: b}    # Bad <br/>{ a: b }   # Good <br/>{ a: b  }  # Bad <br/>{  a: b }  # Bad <br/>{  a: b  } # Bad  <br/># Empty Object Spaces is 0 <br/>{}         # Good <br/>{ }        # Bad  <br/># Empty Object Spaces is 1 <br/>{}         # Bad <br/>{ }        # Good </code></pre>  This rule is disabled by default.", 
		priority = Priority.INFO)
// value currently not generated ! 
@SqaleSubCharacteristic(RulesDefinition.SubCharacteristics.READABILITY)
// value currently not generated !
@SqaleConstantRemediation("5min")
@ActivatedByDefault
// @formatter:on
public class BracesSpacingCheck {
	public static final String KEY = "braces_spacing";
}
