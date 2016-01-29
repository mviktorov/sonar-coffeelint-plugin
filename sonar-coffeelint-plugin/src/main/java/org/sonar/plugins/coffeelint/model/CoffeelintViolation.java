package org.sonar.plugins.coffeelint.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.issue.Issuable;
import org.sonar.api.issue.Issuable.IssueBuilder;
import org.sonar.api.issue.Issue;

public class CoffeelintViolation {
	private final List<Violation> violations = new ArrayList<>();

	public List<Issue> createIssues(InputFile file, Issuable issueable) {
		return violations.stream().map(v -> doCreateIssue(v, file, issueable)).filter(Objects::nonNull)
				.collect(Collectors.toList());
	}

	private Issue doCreateIssue(Violation violation, InputFile file, Issuable issueable) {
		IssueBuilder issueBuilder = issueable.newIssueBuilder();
		violation.fillIssue(issueBuilder, file);
		return issueBuilder.build();
	}
}