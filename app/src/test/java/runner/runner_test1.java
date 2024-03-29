package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

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
// Si falla después de cierto tiempo ACTUALIZAR EL DRIVER DE CHROME
// Si falla import org => ir a command palete (ctrol+shift+p => Clean java
// language)
public class runner_test1 {
        @AfterClass
        public static void cleanDriver() {
                BasePage.closeBrowser();
        }
}
