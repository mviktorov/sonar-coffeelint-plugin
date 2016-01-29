package org.sonar.plugins.coffeelint2java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.StringJoiner;

import org.sonar.plugins.coffeelint2java.output.OutputSource;
import org.sonar.plugins.coffeelint2java.reader.RuleHandler;

/**
 * Coordinates the creation of checks based on a template file and rulefile.
 * Actual work is performed by a {@link CheckWriter} and {@link RuleHandler}.
 * 
 * @author andreas
 *
 */
class TemplateCheckHandler {
	private static final String DEFAULT_CHECK_TEMPLATE = "/java_check_template";

	private Path templateFile;
	private RuleHandler ruleReader;
	private OutputSource outputSource;

	TemplateCheckHandler(OutputSource outputSource, RuleHandler reader) {
		this.outputSource = outputSource;
		this.ruleReader = reader;
	}

	void generate(StringJoiner stringJoiner) throws IOException {
		ruleReader.initRules();
		processRules();
		stringJoiner.add(ruleReader.getRuleClassName() + ".class");
	}

	private void processRules() throws IOException, FileNotFoundException {
		try (BufferedReader templateBuffer = getTemplateReader();
				OutputSource checkWriter = outputSource.get(ruleReader.getRuleClassName() + ".java")) {
			templateBuffer.lines().forEach(line -> ruleReader.processLine(line, checkWriter::write));
		}
	}

	private BufferedReader getTemplateReader() throws FileNotFoundException {
		if (templateFile == null) {
			InputStream checkTemplate = TemplateCheckHandler.class.getResourceAsStream(DEFAULT_CHECK_TEMPLATE);
			return new BufferedReader(new InputStreamReader(checkTemplate));
		}
		return new BufferedReader(new FileReader(templateFile.toFile()));
	}
}
