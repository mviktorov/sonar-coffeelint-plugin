package org.sonar.plugins.coffeelint2java;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.StringJoiner;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.sonar.plugins.coffeelint2java.output.OutputSource;
import org.sonar.plugins.coffeelint2java.reader.CoffeeLintRuleFileHandler;
import org.sonar.plugins.coffeelint2java.reader.RuleHandler;
import org.sonar.plugins.coffeelint2java.reader.RuleSource;

import com.google.common.collect.Lists;

public class TemplateCheckHandlerTest {
	@Test
	public void foo() throws IOException {
		RuleSource ruleSource = new RuleSource() {
			@Override
			public List<String> rulesByLine() {
				return Lists.newArrayList("key: '__KEY__'");
			}

			@Override
			public String name() {
				return "flub";
			}
		};
		RuleHandler reader = new CoffeeLintRuleFileHandler(ruleSource, "foo.bar");
		StringWriter stringWriter = new StringWriter();
		OutputSource outputSource = new OutputSource() {
			@Override
			public void write(String line) {
				stringWriter.write(line);
				stringWriter.write("\n");
			}

			@Override
			public void close() throws IOException {
				stringWriter.close();
			}
		};
		TemplateCheckHandler checkHandler = new TemplateCheckHandler(outputSource, reader);
		checkHandler.generate(new StringJoiner(","));
		Assertions.assertThat(stringWriter.toString()).contains("@Rule");
	}
}
