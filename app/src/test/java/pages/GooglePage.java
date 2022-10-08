package pages;

public class GooglePage extends BasePage {

    public GooglePage() {
        // Una interfaz extiende a otra interfaz
        // Super permite ese acceso
        super(driver);
    }

    public void navigateToGoogle() {
        navigateTo("https://www.google.com");
    }

}
