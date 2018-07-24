import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
                //plugin = { "pretty", "html:target/test- report" },
                //plugin = { "json:target/test-report/CucumberRunnerTest.json" },
                plugin={"pretty", "html:target/test-report", "json:target/cucumber.json"},
                //plugin={"pretty", "html:target/test-report", "json:target/cucumber.json","rerun:target/rerun2.txt"},
               // features = {"src/main/resources/features" },
                		format = {"json:target/cucumber.json"},



            tags = { "@July_UeS7,@July_UeS8"
//            		+ ",@Regression"
  //          		+ ",@July_Regression"
            		
            		},
            
            
                      monochrome = true,
                snippets = SnippetType.CAMELCASE
)
public class CucumberRunnerTest{

}
