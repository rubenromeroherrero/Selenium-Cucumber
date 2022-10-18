package pages.test1_google;

import pages.BasePage;

public class GooglePage extends BasePage {

    // private String denyCookies =
    // "/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[1]/div";
    private String acceptCookies = "/html/body/div[2]/div[2]/div[3]/span/div/div/div/div[3]/div[1]/button[2]/div";
    private String searchButton = "input[@value='Buscar con google']";
    private String searchTextFieldGoogle = "//input[@title='Buscar']";

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
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String argument) {
        writeElement(searchTextFieldGoogle, argument);
    }

}
