package org.sonar.plugins.coffeelint2java.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * A {@link RuleSource} based on {@link Path}.
 * 
 * @author andreas
 *
 */
public class PathRuleSource implements RuleSource {
	private final Path ruleFile;

	public PathRuleSource(Path ruleFile) {
		this.ruleFile = ruleFile;
	}

	@Override
	public List<String> rulesByLine() {
		try {
			return Files.readAllLines(ruleFile);
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String name() {
		String fileName = ruleFile.getFileName().toString();
		if (fileName.indexOf('.') > 0) {
			return fileName.substring(0, fileName.lastIndexOf('.'));
		}
		return fileName;
	}

}
