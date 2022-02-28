package co.com.practice.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/feature/Post.feature",
        glue = {
            "co.com.practice.stepdefinitions.hook",
            "co.com.practice.stepdefinitions"
        }
)


public class PostRunner {
}
