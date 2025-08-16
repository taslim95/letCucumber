package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

//import cucumber.api.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/features/addToCartSteps.feature"},
		dryRun=true,
		snippets=SnippetType.CAMELCASE,
		monochrome=true,
		glue="Steps",
		plugin = {"pretty", "html:Cucumber-reports.html", "json:target/cucumber.json", 
				"json:reports/result.json",
				"junit:reports/result.xml"}
		//tags= {"@test"}
		
		)
public class Runner extends AbstractTestNGCucumberTests {

}
