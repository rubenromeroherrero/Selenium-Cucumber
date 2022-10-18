package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// POM => Patrón de diseño: manera de estructurar nuestro código para un mejor
// mantenimiento
public class BasePage {
    // Creamos instancia estática del driver => es decir, es una estancia del Chrome
    // static => un sólo valor de driver para todas las clases
    protected static WebDriver driver;
    private static WebDriverWait wait;

    // Creamos el webDriver UNA SOLA VEZ para usarlo en todas las páginas
    // Cada vez que usemos este webDriver, esperará 10 segundos
    static {
        // Establecemos la ruta del chromeDriver para poder utilizar la instancia de
        // Chrome en las pruebas
        // Verificar que la versión del chromedriver es la misma que Chrome
        System.setProperty("webdriver.chrome.driver", "C:/Users/ruben/drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Constructor que hace que utilice el WebDriver de encima
    public BasePage(WebDriver driver) {
        // Cuando creemos una instancia de esta clase lo que va a hacer es lo siguiente:
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    // Devolvemos el webElement haciendo una espera hasta que el webElement esté o
    // sino lanza un error pasados los 10 segundos
    private WebElement findElement(String locator) {
        // Devuelve un webElement
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    // Función pública para seleccionar elementos
    public void clickElement(String locator) {
        // Dado un xpath (locator dado) => si lo localiza hace el click
        findElement(locator).click();
    }

    // Función pública para escribir elementos
    public void writeElement(String locator, String textToWrite) {
        // Nos aseguramos que primero limpiamos el campo de texto
        findElement(locator).clear();
        // Escribimos el texto con la función importada de la librería de selenium
        findElement(locator).sendKeys(textToWrite);
    }
}
