package pages.test1_google;

import java.util.NoSuchElementException;

import pages.BasePage;

public class GooglePage extends BasePage {

    // private String denyCookies =
    // "/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[1]/div";
    private String acceptCookies = "/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div";
    private String searchButton = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[5]/center/input[1]";
    private String searchTextFieldGoogle = "//input[@title='Buscar']";
    public String firstResultEqualAssertion = "LC20lb";

    public GooglePage() {
        // Una interfaz extiende a otra interfaz
        // Super permite ese acceso
        super(driver);
    }

    public void navigateToGoogle() {
        navigateTo("https://www.google.com");
    }

    public void clickAcceptCookies() {
        clickElement(acceptCookies);
    }

    public void clickGoogleSearch() {
        // Manejo de errores, para mostrar por consola si falla el buscar un elemento
        try {
            clickElement(searchButton);
        } catch (NoSuchElementException e) {
            System.out.println("The click element for doing a search could not be found.");
            e.printStackTrace();
        }
    }

    public void enterSearchCriteria(String argument) {
        writeElement(searchTextFieldGoogle, argument);
    }

    public String compareValues() {
        // Pasamos la ubicación/id/xpath de lo que queremos convertir a texto
        // para poder hacer el assertion === validación (then)
        return textFromElement(firstResultEqualAssertion);
    }

    public Boolean tellMeStatus() {
        return elementIsDisplayedOrNot(firstResultEqualAssertion);
    }

}
