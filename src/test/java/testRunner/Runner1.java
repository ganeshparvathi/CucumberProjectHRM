package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(features= {"FeatureFiles"},tags= {"@Multipledata"},monochrome=true,glue= {"stepDefination"},plugin= {"pretty","html:target/cucumber-reports"})
public class Runner1 extends AbstractTestNGCucumberTests {

}
