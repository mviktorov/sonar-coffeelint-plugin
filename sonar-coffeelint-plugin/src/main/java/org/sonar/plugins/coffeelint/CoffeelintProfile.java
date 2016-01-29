package org.sonar.plugins.coffeelint;

import org.sonar.api.profiles.ProfileDefinition;
import org.sonar.api.profiles.RulesProfile;
import org.sonar.api.rules.RuleFinder;
import org.sonar.api.utils.ValidationMessages;
import org.sonar.plugins.coffeelint.checks.CoffeelintCheckList;
import org.sonar.plugins.coffeelint.language.Coffee;
import org.sonar.squidbridge.annotations.AnnotationBasedProfileBuilder;

@SuppressWarnings("deprecation")
public class CoffeelintProfile extends ProfileDefinition {
	public static final String COFFE_WAY_PROFILE_NAME = "SonarQube Way";
	private final RuleFinder ruleFinder;

	public CoffeelintProfile(RuleFinder ruleFinder) {
		this.ruleFinder = ruleFinder;
	}

	@Override
	public RulesProfile createProfile(ValidationMessages validation) {
		AnnotationBasedProfileBuilder profileBuilder = new AnnotationBasedProfileBuilder(ruleFinder);
		return profileBuilder.build(Coffee.KEY, COFFE_WAY_PROFILE_NAME, Coffee.KEY, CoffeelintCheckList.getChecks(),
				validation);
	}
}
