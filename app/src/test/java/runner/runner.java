package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true,
        // Donde están los features ubicados
        features = "src/test/resources/features",
        // Manera en la que decimos dónde están las definiciones para los steps/features
        glue = "steps")

// Ejecutamos los tests/features
public class runner {

}
