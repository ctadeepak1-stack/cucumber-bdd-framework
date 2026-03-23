
//Runner
package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
@CucumberOptions(features ="src/test/resources/features",
        glue = {"opencartstepdefnitions"},
        plugin = {"pretty","html:target/cucumber-reports","json:target/cucumber.json"},
        monochrome = true,
        publish = true)
@SuppressWarnings("ALL")
public class Testrunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
