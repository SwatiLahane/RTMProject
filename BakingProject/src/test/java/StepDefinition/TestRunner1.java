package StepDefinition;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)				
	@CucumberOptions(features={"src/test/java/FeatureFiles1/"},
	glue={"StepDefinition"},
	//tags = "@High",
	plugin = { "pretty", "html:target/site/cucumber-pretty.html",
			"json:target/site/cucumber-report.json",
			 "junit:target/site/cucumber-results.xml",
	"json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })

	public class TestRunner1 {

	}
	
