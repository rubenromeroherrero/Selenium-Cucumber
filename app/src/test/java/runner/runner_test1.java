package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(publish = true,
        // Donde están los features ubicados del test1
        // features = "src/test/resources/features/test1_google",
        features = "src/test/resources/features",
        // Manera en la que decimos dónde están las definiciones para los steps/features
        glue = "steps",
        // Selecciona aquellos test que tengan el tag @Test
        tags = "@Test")

// Ejecutamos los tests/features e indicamos la carpeta del test a compilar
public class runner_test1 {

}
