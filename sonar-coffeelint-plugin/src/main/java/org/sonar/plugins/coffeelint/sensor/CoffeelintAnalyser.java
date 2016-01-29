package org.sonar.plugins.coffeelint.sensor;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteWatchdog;
import org.apache.commons.exec.LogOutputStream;
import org.apache.commons.exec.PumpStreamHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.plugins.coffeelint.model.CoffeelintViolation;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * To analyse a coffeescript http://www.coffeelint.org must be installed on the
 * machine.
 * 
 * @author andreas
 *
 */
public class CoffeelintAnalyser {
	private final Logger LOGGER = LoggerFactory.getLogger(CoffeelintAnalyser.class);

	public void analyse(CoffeeOutputHandler outputHandler, File file) {
		CommandLine commandLine = buildCoffeelintCommand(file);
		try {
			buildCoffeelintExecutor(outputHandler).execute(commandLine);
		}
		catch (IOException e) {
			LOGGER.error("failed to check coffee file", e);
		}
	}

	private DefaultExecutor buildCoffeelintExecutor(CoffeeOutputHandler outAndErr) {
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValues(new int[] { 0, 1 });
		executor.setStreamHandler(new PumpStreamHandler(outAndErr));
		executor.setWatchdog(new ExecuteWatchdog(10000));
		return executor;
	}

	private CommandLine buildCoffeelintCommand(File file) {
		Map<String, File> map = Collections.singletonMap("file", file);
		CommandLine commandLine = new CommandLine("coffeelint");
		commandLine.addArguments("--reporter raw");
		commandLine.addArgument("${file}");
		commandLine.setSubstitutionMap(map);
		return commandLine;
	}

	static final class CoffeeOutputHandler extends LogOutputStream {
		private final Logger LOGGER = LoggerFactory.getLogger(CoffeeOutputHandler.class);
		private final StringBuilder builder = new StringBuilder();
		private final InputFile file;

		CoffeeOutputHandler(InputFile inputFile) {
			this.file = inputFile;
		}

		@Override
		protected void processLine(String line, int level) {
			if (line.contains(file.absolutePath())) {
				replaceFilenameLine(line);
			}
			else {
				append(line);
			}
		}

		// https://github.com/clutchski/coffeelint/issues/541
		// coffeelint uses the file name as property name, which is not to
		// model, so replace this with a constant
		private void replaceFilenameLine(String line) {
			append("\"file\" : \"" + file.relativePath() + "\",");
			append(line.replace(file.absolutePath(), "violations"));
		}

		private void append(String line) {
			builder.append(line).append(System.lineSeparator());
		}

		public CoffeelintViolation getViolation() {
			try {
				Gson gson = new Gson();
				return gson.fromJson(builder.toString(), CoffeelintViolation.class);
			}
			catch (JsonSyntaxException e) {
				LOGGER.error(builder.toString(), e);
				return new CoffeelintViolation();
			}
		}
	}
}
