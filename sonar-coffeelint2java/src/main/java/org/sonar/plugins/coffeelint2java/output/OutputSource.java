package org.sonar.plugins.coffeelint2java.output;

import java.io.IOException;

/**
 * An {@link OutputPathSource} allows to output {@link String}s to a source.
 * 
 * @author andreas
 *
 */
public interface OutputSource extends AutoCloseable {
	/**
	 * Writes the given {@link String}.
	 * 
	 * @param line
	 */
	void write(String line);

	@Override
	void close() throws IOException;

	default OutputSource get() {
		return this;
	}

	default OutputSource get(String name) {
		return this;
	}
}
