package org.sonar.plugins.coffeelint2java.output;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * An {@link OutputSource} based on {@link Path}.
 * 
 * @author andreas
 *
 */
public class OutputPathSource implements OutputSource {
	private PrintWriter printWriter;
	private Path outputPath;

	public OutputPathSource(Path outputPath) throws IOException {
		this.outputPath = outputPath;
	}

	@Override
	public OutputSource get(String name) {
		Path sonarCheckFile = outputPath.resolve(name);
		try {
			this.printWriter = new PrintWriter(Files.newOutputStream(sonarCheckFile));
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		return this;
	}

	@Override
	public void close() {
		printWriter.close();
	}

	@Override
	public void write(String line) {
		printWriter.println(line);
	}
}
