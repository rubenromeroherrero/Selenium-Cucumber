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

    }
}
