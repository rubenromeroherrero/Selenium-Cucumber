package steps.test1_google;

import org.junit.Assert;

// Importamos lo que vamos necesitamos de la librería de cucumber 
import io.cucumber.java.en.*;
import pages.test1_google.GooglePage;

// Steps Definitions
public class GoogleSteps {

    // Creamos instancia de GooglePage
    GooglePage google = new GooglePage();

    // Definimos los pasos/steps definidos en el lenguaje Gherkin (cucumber)
    @Given("^I am on the Google search page$")
    public void navigateToGoogle() {
        google.navigateToGoogle();
        google.clickAcceptCookies();

    }

    @When("^I enter a search criteria$")
    public void enterAsearchCriteria() {
        google.enterSearchCriteria("Selenium");
    }

    @And("^click on the search button$")
    public void clickSearchButton() {
        google.clickGoogleSearch();
    }

    @Then("^the results match the criteria$")
    public void validateResults() {
        // Validamos que contenga un elemento en concreto llamado "Selenium"
        Assert.assertEquals("Selenium", google.compareValues());
    }

    @Then("^I can validate that the value is correct$")
    public void validateValueOfSearchResult() {
        // 1- Validamos que contenga ese elemento la búsqueda y mostramos en nuestro
        // test el mensaje que ha ido todo correcto"
        Assert.assertTrue("Ha ido todo correcto", google.tellMeStatus());

        // 2- Validamos que un elemento esté apareciendo pero contemplamos que no
        // debería de mostrarse, de manera que lanza un error y el test falla con el
        // mensaje que pusimos
        // Assert.assertFalse("El elemento se muestra y no debería",
        // google.tellMeStatus());
    }
}
