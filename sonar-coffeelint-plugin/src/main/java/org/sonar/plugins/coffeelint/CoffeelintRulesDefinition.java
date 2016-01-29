package org.sonar.plugins.coffeelint;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonar.plugins.coffeelint.checks.CoffeelintCheckList;
import org.sonar.plugins.coffeelint.language.Coffee;
import org.sonar.squidbridge.annotations.AnnotationBasedRulesDefinition;

public class CoffeelintRulesDefinition implements RulesDefinition {
	@Override
	public void define(Context context) {
		NewRepository repository = context.createRepository(Coffee.KEY, Coffee.KEY)
				.setName(CoffeelintCheckList.REPOSITORY_NAME);
		AnnotationBasedRulesDefinition.load(repository, Coffee.KEY, CoffeelintCheckList.getChecks());
		repository.done();
	}
}
