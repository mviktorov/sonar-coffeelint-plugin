package org.sonar.plugins.coffeelint.language;

import org.apache.commons.lang.StringUtils;
import org.sonar.api.config.Settings;
import org.sonar.api.resources.AbstractLanguage;
import org.sonar.plugins.coffeelint.CoffeelintPlugin;

public class Coffee extends AbstractLanguage {
	public static final String KEY = "coffee";
	private Settings settings;

	public Coffee(Settings settings) {
		super(KEY, "Coffee script");
		this.settings = settings;
	}

	@Override
	public String[] getFileSuffixes() {
		String[] suffixes = settings.getStringArray(CoffeelintPlugin.FILE_SUFFIXES_KEY);
		if (suffixes == null || suffixes.length == 0) {
			suffixes = StringUtils.split(CoffeelintPlugin.FILE_SUFFIXES_DEFAULT_VALUE, ",");
		}
		return suffixes;
	}
}
