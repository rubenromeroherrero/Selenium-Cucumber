package steps.test1_google;

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
    }

    @When("^I enter a search criteria$")
    public void enterAsearchCriteria() {

    }

    @And("^click on the search button$")
    public void clickSearchButton() {

    }

    @Then("^the results match the criteria$")
    public void validateResults() {

    }
}
