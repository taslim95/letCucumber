package hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class MyHooks {
	@Before
public void beforeScenario(Scenario scenario) {
	System.out.println("Scenario name ------   Before Scenario");
	
	System.out.println(scenario.getName());
}
	@After
public void afterScenario(Scenario scenario) {
		boolean failed=scenario.isFailed();
		System.out.println("is failed  "+failed);
	
}	

	@BeforeStep
	public void beforeStep(Scenario scenario) {
	
}	

	@AfterStep
public void afterSteps(Scenario scenario) {
	
}
}
