import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

//Testing
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features"
                , glue = "classpath:com.infy.cucumber.fixture",
        format={"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class RunnerTest {

}
