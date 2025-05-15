package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepDef"},
        tags = "@Positive and @Login",
        plugin = {"pretty",
                "html:target/cucumber-reports.html"
        }
)

public class runTest {

}
