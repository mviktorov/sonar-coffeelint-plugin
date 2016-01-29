package org.sonar.plugins.coffeelint2java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.sonar.plugins.coffeelint2java.output.OutputSource;

/**
 * Creates the checklist file with all generated checks.
 * 
 * @author andreas
 *
 */
class TemplateChecklistHandler {
	private static final String CHECKS = "__CHECKS__";
	private static final String PACKAGE = "__PACKAGE__";
	private static final String JAVA_CHECK_LIST_TEMPLATE = "/java_check_list_template";

	private TemplateChecklistHandler() {
	}

	private static String handleLine(String allClasses, String line, String packageName) {
		if (line.contains(CHECKS)) {
			return line.replace(CHECKS, allClasses);
		}
		else if (line.contains(PACKAGE)) {
			return line.replace(PACKAGE, packageName);
		}
		return line;
	}

	static void generateChecklistFile(OutputSource outputSource, String packageName, String checkNames)
			throws IOException {
		try (BufferedReader templateListBuffer = templateCheckListStream();
				OutputSource output = outputSource.get("CoffeelintCheckList.java")) {
			templateListBuffer.lines().map(line -> handleLine(checkNames, line, packageName)).forEach(output::write);
		}
	}

	private static BufferedReader templateCheckListStream() {
		InputStream resource = TemplateChecklistHandler.class.getResourceAsStream(JAVA_CHECK_LIST_TEMPLATE);
		return new BufferedReader(new InputStreamReader(resource));
	}
}
