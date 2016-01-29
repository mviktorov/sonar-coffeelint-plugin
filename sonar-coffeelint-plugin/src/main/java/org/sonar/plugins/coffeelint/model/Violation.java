package org.sonar.plugins.coffeelint.model;

import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.issue.Issuable.IssueBuilder;
import org.sonar.api.rule.RuleKey;
import org.sonar.plugins.coffeelint.language.Coffee;

public class Violation {
	private String message;
	private String context;
	private int lineNumber;
	private String rule;

	public void fillIssue(IssueBuilder issueBuilder, InputFile inputFile) {
		String text = message;
		if (context != null) {
			text += ". " + context;
		}
		issueBuilder.line(lineNumber).message(text).ruleKey(RuleKey.of(Coffee.KEY, rule));
	}
}