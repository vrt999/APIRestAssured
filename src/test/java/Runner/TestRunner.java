package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "F:\\myproject\\APIRestAssured\\src\\test\\java\\Features",
glue= {"StepDefinitions"},
//dry run - true checks if all the steps are defined in the step definition file
//dry run - false is default value taken and runs total code
dryRun = false,
//monochorme - false is default value and should be true enabled to true to see proper format in the console output
monochrome = true,
plugin= {"pretty","html:test-output"},
//strict - by default true value is taken, if false is given test excutes
//all the steps without fail even if some steps arenot defined
strict = true)

/*Cucumber options
dryRun
features
glue
tags
monochrome
format - updated to plugin
strict*/
public class TestRunner {
	

}
