package org.example;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/cucumber/features/", plugin = {"pretty", "html:out.html"}, tags = "@pet")
public class TestRunner {
}
