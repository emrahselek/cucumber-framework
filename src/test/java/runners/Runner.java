package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@smoke and @regression",
        dryRun = false
)
public class Runner {
}
/*
-Runner is used to run feature files
-@RunWith is used to run the class. Without this, Runner class will not be runnable
-@CucumberOptions is used to add  feature path, step definition path, tags, dryRun, report plugins
-features : path of the features folder, thus can point path of specific feature files
-glue       : path of step definitions folder. this can point path of specific step definition class
-tags       : this marks which feature to run. we add this tag in the feature files
-dryRun     : dryRun is used to check if there is any MISSING JAVA CODE (STEP DEFINITIONS )
                dryRun takes 2 values true of false
                dryRun = false : runs test on the browser while checking if there ise any JAVA code missing
                dryRun = true : rus tests without browser while checking if there ise any JAVA code missing
 */