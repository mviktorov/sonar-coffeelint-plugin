package org.sonar.plugins.coffeelint;

import java.util.List;

import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.SonarPlugin;
import org.sonar.plugins.coffeelint.language.Coffee;
import org.sonar.plugins.coffeelint.sensor.CoffeelintSensor;

import com.google.common.collect.ImmutableList;

// @formatter:off
@Properties({
		@Property(
				key = CoffeelintPlugin.FILE_SUFFIXES_KEY, 
				defaultValue = CoffeelintPlugin.FILE_SUFFIXES_DEFAULT_VALUE, 
				name = "File Suffixes", 
				description = "Comma-separated list of suffixes for files to analyze. To not filter, leave the list empty.", 
				global = true, 
				project = true)
})
// @formatter:on
public class CoffeelintPlugin extends SonarPlugin {
	public static final String FILE_SUFFIXES_KEY = "sonar.coffee.file.suffixes";
	public static final String FILE_SUFFIXES_DEFAULT_VALUE = ".coffee";

	@SuppressWarnings("rawtypes")
	@Override
	public List getExtensions() {
		return ImmutableList.of(Coffee.class, CoffeelintProfile.class, CoffeelintRulesDefinition.class,
				CoffeelintSensor.class);
	}
}
