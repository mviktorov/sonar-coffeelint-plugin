package org.sonar.plugins.coffeelint.sensor;

import java.util.List;

import org.sonar.api.batch.Sensor;
import org.sonar.api.batch.SensorContext;
import org.sonar.api.batch.fs.FilePredicate;
import org.sonar.api.batch.fs.FileSystem;
import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.component.ResourcePerspectives;
import org.sonar.api.issue.Issuable;
import org.sonar.api.issue.Issue;
import org.sonar.api.resources.Project;
import org.sonar.plugins.coffeelint.language.Coffee;
import org.sonar.plugins.coffeelint.model.CoffeelintViolation;
import org.sonar.plugins.coffeelint.sensor.CoffeelintAnalyser.CoffeeOutputHandler;

import com.google.common.base.Preconditions;

/**
 * {@link Sensor} to analyse <i>coffee</i> files via http://www.coffeelint.org
 * 
 * @author andreas
 *
 */
public class CoffeelintSensor implements Sensor {
	private final FileSystem fileSystem;
	private final FilePredicate mainFilePredicate;
	private final ResourcePerspectives resourcePerspectives;

	public CoffeelintSensor(FileSystem fileSystem, ResourcePerspectives resourcePerspectives) {
		this.fileSystem = fileSystem;
		this.resourcePerspectives = resourcePerspectives;
		this.mainFilePredicate = fileSystem.predicates().and(fileSystem.predicates().hasType(InputFile.Type.MAIN),
				fileSystem.predicates().hasLanguage(Coffee.KEY));
	}

	@Override
	public boolean shouldExecuteOnProject(Project project) {
		return fileSystem.hasFiles(mainFilePredicate);
	}

	@Override
	public void analyse(Project module, SensorContext context) {
		fileSystem.inputFiles(mainFilePredicate).forEach(inputFile -> checkCoffeeFile(inputFile, context));
	}

	private void checkCoffeeFile(InputFile file, SensorContext context) {
		CoffeeOutputHandler outputHandler = new CoffeeOutputHandler(file);
		new CoffeelintAnalyser().analyse(outputHandler, file.file());
		processIssues(file, context, outputHandler.getViolation());
	}

	private void processIssues(InputFile file, SensorContext context, CoffeelintViolation violation) {
		Issuable issueable = resourcePerspectives.as(Issuable.class, context.getResource(file));
		Preconditions.checkNotNull(issueable);
		List<Issue> issues = violation.createIssues(file, issueable);
		issues.stream().filter(i -> i.ruleKey() != null).forEach(i -> issueable.addIssue(i));
	}
}
