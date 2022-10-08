package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
}
