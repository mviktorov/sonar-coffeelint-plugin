package org.sonar.plugins.coffeelint2java;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.plugins.coffeelint2java.output.OutputPathSource;
import org.sonar.plugins.coffeelint2java.output.OutputSource;
import org.sonar.plugins.coffeelint2java.reader.CoffeeLintRuleFileHandler;
import org.sonar.plugins.coffeelint2java.reader.PathRuleSource;
import org.sonar.plugins.coffeelint2java.reader.RuleHandler;
import org.sonar.plugins.coffeelint2java.reader.RuleSource;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Strings;
import com.beust.jcommander.converters.PathConverter;

public class Coffeelint2Java {
	private final Logger LOGGER = LoggerFactory.getLogger(Coffeelint2Java.class);
	@Parameter(description = "coffee scripts or directories used for generation", converter = PathConverter.class)
	private List<Path> rules = new ArrayList<>();

	@Parameter(names = { "-o",
			"--outputdir" }, converter = PathConverter.class, description = "the output directory, where the the java files are generated")
	private Path outputDirectory;

	@Parameter(names = { "-c",
			"--checkTemplate" }, converter = PathConverter.class, description = "the template file for the java checks. Used to generate the sonarqube checks (default: 'java_check_template')")
	private Path templateFile;

	@Parameter(names = { "-p",
			"--package" }, description = "the package name for the generated java files (default: 'org.sonar.plugins.coffeelint.checks')")
	private String packageName = "org.sonar.plugins.coffeelint.checks";

	public static void main(String[] args) throws IOException {
		Coffeelint2Java main = new Coffeelint2Java();
		checkCommandLine(main, new JCommander(main, args));

		if (main.rules.size() > 1) {
			main.LOGGER.warn("Only one coffee script/directory is supported");
		}

		StringJoiner stringJoiner = new StringJoiner(", ");
		main.generateChecks(main.rules.get(0), stringJoiner);
		generateCheckListFile(main, stringJoiner);
	}

	private static void checkCommandLine(Coffeelint2Java main, JCommander jCommander) {
		if (main.outputDirectory == null || main.rules.isEmpty() || Strings.isStringEmpty(main.packageName)) {
			jCommander.setProgramName(Coffeelint2Java.class.getSimpleName());
			jCommander.usage();
			System.exit(-1);
		}
	}

	private static void generateCheckListFile(Coffeelint2Java main, StringJoiner stringJoiner) throws IOException {
		OutputSource outputSource = new OutputPathSource(main.outputDirectory);
		TemplateChecklistHandler.generateChecklistFile(outputSource, main.packageName, stringJoiner.toString());
	}

	private void generateChecks(Path ruleFile, StringJoiner stringJoiner) {
		if (Files.isDirectory(ruleFile)) {
			handleDirectory(ruleFile, stringJoiner);
		}
		else if (Files.isRegularFile(ruleFile)) {
			handleFile(ruleFile, stringJoiner);
		}
		else {
			LOGGER.error(ruleFile + " does not exist or is a regular file");
			System.exit(-1);
		}
	}

	private void handleFile(Path ruleFile, StringJoiner stringJoiner) {
		try {
			doGenerateChecks(ruleFile, stringJoiner);
		}
		catch (IOException e) {
			LOGGER.error("Failed to generate from " + ruleFile, e);
		}
	}

	private void handleDirectory(Path ruleFile, StringJoiner stringJoiner) {
		try {
			PathMatcher pathMatcher = ruleFile.getFileSystem().getPathMatcher("glob:**/*.coffee");
			Files.list(ruleFile).filter(pathMatcher::matches).forEach(path -> generateChecks(path, stringJoiner));
		}
		catch (IOException e) {
			LOGGER.error("Failed during iterating through input directory", e);
		}
	}

	private void doGenerateChecks(Path ruleFile, StringJoiner stringJoiner) throws IOException {
		RuleSource ruleSource = new PathRuleSource(ruleFile);
		RuleHandler reader = new CoffeeLintRuleFileHandler(ruleSource, packageName);
		OutputSource outputSource = new OutputPathSource(outputDirectory);
		new TemplateCheckHandler(outputSource, reader).generate(stringJoiner);
	}
}
