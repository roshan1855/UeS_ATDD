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



            tags = { "@AddNewQuote_Dental_Vision_With_Salary_with_DEP,@AddNewQuote_Dental_Vision_Without_Salary"
//            		+ ",@Regression"
  //          		+ ",@July_Regression"
            		
            		},
            
            
                      monochrome = true,
                snippets = SnippetType.CAMELCASE
)
public class CucumberRunnerTest{

}
