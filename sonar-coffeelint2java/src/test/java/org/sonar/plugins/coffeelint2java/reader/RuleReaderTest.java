package org.sonar.plugins.coffeelint2java.reader;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.Consumer;

import org.junit.Test;

import com.google.common.collect.Lists;

public class RuleReaderTest {
	@Test
	public void should_read_always_read_default_properties() {
		RuleHandler reader = readRules(Lists.newArrayList(""));
		reader.processLine("foobar", assertLine("foobar"));
		reader.processLine("name: __KEY__", assertLine("name: test"));
		reader.processLine("package: __PACKAGE__", assertLine("package: foo.bar"));
	}

	@Test
	public void should_parse_priority2() {
		RuleHandler reader = readRules(Lists.newArrayList(" level: 'error'"));
		reader.processLine("__PRIORITY__", assertLine("MAJOR"));
	}

	@Test
	public void should_parse_priority() {
		RuleHandler reader = readRules(Lists.newArrayList(" level: 'error'"));
		reader.processLine("__PRIORITY__", assertLine("MAJOR"));
	}

	@Test
	public void should_parse_multiline_description() {
		RuleHandler reader = readRules(Lists.newArrayList(" description: '''", "first", "second", "'''", "out"));
		reader.processLine("__DESCRIPTION__", assertLine("first second"));
	}

	@Test
	public void should_parse_code_tags_in_description() {
		RuleHandler reader = readRules(
				Lists.newArrayList(" description: '''", "first", "<code>", "foo", "bar", "</code>", "'''", "out"));
		reader.processLine("__DESCRIPTION__", new Consumer<String>() {
			@Override
			public void accept(String t) {
				t.contains("<br/>");
			}
		});
	}

	private Consumer<String> assertLine(String expected) {
		return new Consumer<String>() {
			@Override
			public void accept(String t) {
				assertThat(t).isEqualTo(expected);
			}
		};
	}

	private CoffeeLintRuleFileHandler readRules(List<String> lines) {
		CoffeeLintRuleFileHandler reader = new CoffeeLintRuleFileHandler(rulesWith(lines), "foo.bar");
		reader.initRules();
		return reader;
	}

	private RuleSource rulesWith(List<String> lines) {
		return new RuleSource() {
			@Override
			public List<String> rulesByLine() {
				return lines;
			}

			@Override
			public String name() {
				return "test";
			}
		};
	}
}
