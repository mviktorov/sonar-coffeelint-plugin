package org.sonar.plugins.coffeelint2java;

import java.io.IOException;
import java.io.StringWriter;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.sonar.plugins.coffeelint2java.output.OutputSource;

public class TemplateCheckListHandlerTest {
	@Test
	public void foo() throws IOException {
		StringWriter writer = new StringWriter();
		OutputSource outputSource = new OutputSource() {

			@Override
			public void write(String line) {
				writer.write(line);
			}

			@Override
			public void close() throws IOException {
				writer.close();
			}

		};
		TemplateChecklistHandler.generateChecklistFile(outputSource, "foo.bar", "foo, bar, flob, top");
		Assertions.assertThat(writer.toString()).contains("foo, bar, flob, top");
	}
}
