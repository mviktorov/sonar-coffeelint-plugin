package org.sonar.plugins.coffeelint2java.reader;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.sonar.check.Priority;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Maps;
import com.sonar.sslr.api.Rule;

/**
 * {@link Rule} to read coffeelint rule files
 * 
 * @author andreas
 *
 */
public class CoffeeLintRuleFileHandler implements RuleHandler {
	private static final String KEY = "__KEY__";
	private static final String DESCRIPTION = "__DESCRIPTION__";
	private static final String PRIORITY = "__PRIORITY__";
	private static final String NAME = "__NAME__";
	private static final String PACKAGE = "__PACKAGE__";
	private static final String CLASS = "__CLASS__";
	private static final Pattern MESSAGE_PATTERN = Pattern.compile("\\s+message: '(.+)'");
	private static final Pattern LEVEL_PATTERN = Pattern.compile("\\s+level: '(.+)'");

	private Map<String, String> replacements = Maps.newHashMap();
	private String packageName;
	private boolean inDescription = false;
	private boolean inCodeTag = false;
	private RuleSource ruleSource;

	public CoffeeLintRuleFileHandler(RuleSource ruleSource, String packageName) {
		this.ruleSource = ruleSource;
		this.packageName = packageName;
	}

	@Override
	public void initRules() {
		inCodeTag = false;
		inDescription = false;
		List<String> readAllLines = ruleSource.rulesByLine();
		final StringBuilder descriptionBuilder = new StringBuilder();
		readAllLines.forEach(line -> {
			checkMessageLine(replacements, line);
			checkLevelLine(replacements, line);
			checkDescriptionLines(descriptionBuilder, line);
		});
		replacements.put(DESCRIPTION, descriptionBuilder.toString().trim());
		replacements.put(KEY, ruleSource.name());
		replacements.put(PACKAGE, packageName);
		replacements.put(CLASS, getRuleClassName());
	}

	private void checkDescriptionLines(final StringBuilder descriptionBuilder, String line) {
		if (line.contains("'''")) {
			inDescription = !inDescription;
		}
		else if (inDescription) {
			buildDescriptionString(descriptionBuilder, line);
		}
	}

	private void buildDescriptionString(final StringBuilder descriptionBuilder, String line) {
		if (line.contains("</code>")) {
			inCodeTag = false;
		}
		if (inCodeTag && !line.isEmpty()) {
			descriptionBuilder.append("<br/>");
		}
		line = line.trim().replace("\"", "\\\"");
		descriptionBuilder.append(line.trim()).append(" ");
		if (line.contains("<code>")) {
			inCodeTag = true;
		}
	}

	@Override
	public String getRuleClassName() {
		String fileNameNoSuffix = ruleSource.name();
		return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, fileNameNoSuffix) + "Check";
	}

	private static void checkLevelLine(Map<String, String> replacements, String line) {
		Matcher lmatcher = LEVEL_PATTERN.matcher(line);
		if (lmatcher.find()) {
			replacements.put(PRIORITY, getPriority(lmatcher.group(1)));
		}
	}

	private static void checkMessageLine(Map<String, String> replacements, String line) {
		Matcher matcher = MESSAGE_PATTERN.matcher(line);
		if (matcher.find()) {
			replacements.put(NAME, matcher.group(1));
		}
	}

	private static String getPriority(String level) {
		switch (level) {
		case "ignore":
			return Priority.INFO.toString();
		case "error":
			return Priority.MAJOR.toString();
		case "warn":
			return Priority.MINOR.toString();

		default:
			throw new IllegalArgumentException("dont know " + level);
		}
	}

	@Override
	public void processLine(String line, Consumer<String> cons) {
		Optional<Entry<String, String>> first = findLine(line);
		if (first.isPresent()) {
			Entry<String, String> entry = first.get();
			cons.accept(line.replace(entry.getKey(), entry.getValue()));
		}
		else {
			cons.accept(line);
		}
	}

	private Optional<Entry<String, String>> findLine(String line) {
		return replacements.entrySet().stream().filter(entry -> line.contains(entry.getKey())).findFirst();
	}
}
