package starter;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = { "starter.stepdefinitions"},
//        features = "src/test/resources/features",
        features = "classpath:features",
        tags = "@my-test",
        snippets = CAMELCASE
)
public class CucumberTestSuite {}
