package steps.test2_sandbox;

import io.cucumber.java.en.*;
import pages.test2_sandbox.SandBoxPage;

public class SandboxSteps {

    // Creamos instancia de la clase SandBoxPage
    SandBoxPage sandboxPage = new SandBoxPage();

    // Definimos los pasos/steps definidos en el lenguaje Gherkin (cucumber)
    @Given("^I navigate to the sandbox page$")
    public void navigateToTheSandboxSite() {
        sandboxPage.navigateToSandbox();
    }

    @And("^select a value from the dropdown$")
    public void selectState() {
        sandboxPage.selectCategory("Products");
    }
}
