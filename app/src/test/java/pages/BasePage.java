package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

// POM => Patrón de diseño: manera de estructurar nuestro código para un mejor
// mantenimiento
public class BasePage {
    // Creamos instancia estática del driver => es decir, es una estancia del Chrome
    // static => un sólo valor de driver para todas las clases
    protected static WebDriver driver;
    private static WebDriverWait wait;

    // Acciones del raton
    private static Actions actions;

    // Instanciamos/creamos el webDriver 1 SOLA VEZ para usarlo en todas las páginas
    // Cada vez que usemos este webDriver, esperará 10 segundos
    static {
        // Establecemos la ruta del chromeDriver para poder utilizar la instancia de
        // Chrome en las pruebas
        // Verificar que la versión del chromedriver es la misma que Chrome
        System.setProperty("webdriver.chrome.driver", "C:/Users/ruben/drivers/chromedriver.exe");

        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        // nos permite poder reutilizarlo luego siempre que vayamos a intentar buscar un
        // WebElement => si no lo encuentra, lo busca durante 10 segundos y sino lanza
        // un error
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Constructor que hace que utilice el WebDriver de encima
    public BasePage(WebDriver driver) {
        // Cuando creemos una instancia de esta clase lo que va a hacer es lo siguiente:
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // 1- Función pública para navegar a una url dada
    public static void navigateTo(String url) {
        driver.get(url);
    }

    // 2- Función privada para poder encontrar un elemento por un xpath
    // Devolvemos el webElement haciendo una espera hasta que el webElement esté o
    // sino lanza un error pasados los 10 segundos
    private WebElement findElementByXpath(String locator) {
        // Devuelve 1 webElement => en caso que no lo encuentre a la primerar tiene 10s
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    // 3- Función privada para poder encontrar un elemento por ID
    private WebElement findElementById(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
    }

    // 4- Función pública para seleccionar elementos
    public void clickElement(String locator) {
        // Dado un xpath (locator dado) => si lo localiza hace el click
        findElementByXpath(locator).click();
    }

    // 5- Función pública para escribir elementos
    public void writeElement(String locator, String textToWrite) {
        // Nos aseguramos que primero limpiamos el campo de texto
        findElementByXpath(locator).clear();
        // Escribimos el texto con la función importada de la librería de selenium
        findElementByXpath(locator).sendKeys(textToWrite);
    }

    // 6- Función pública para seleccionar elemento de un dropdown a partir de value
    public void selectFromDropdownByValue(String locator, String valueToSelect) {
        // Generar instancia del select => guardar el objeto con elementos del dropdown
        Select dropdown = new Select(findElementById(locator));

        // Seleccionamos del objeto Select dropdown por valor dado
        dropdown.selectByValue(valueToSelect);
    }

    // 7- Función pública para seleccionar un elemento de un dropdown a partir de id
    public void selectFromDropdownByIndex(String locator, int indexToSelect) {
        // Generar instancia del select => guardar el objeto con elementos del dropdown
        Select inputSelectTopic = new Select(findElementById(locator));

        // Seleccionamos del objeto Select dropdown por valor dado
        inputSelectTopic.selectByIndex(indexToSelect);
    }

    // 8- Función pública para seleccionar un elemento de un dropdown a partir de
    // text
    public void selectFromDropdownByText(String locator, String textToSelect) {
        // Generar instancia del select => guardar el objeto con elementos del dropdown
        Select dropdown = new Select(findElementById(locator));

        // Seleccionamos del objeto Select dropdown por valor dado
        dropdown.selectByVisibleText(textToSelect);
    }

    // ACCIONES DEL RATON
    // 1- Hover
    public void hoverOverElement(String locator) {
        actions.moveToElement(findElementByXpath(locator));
    }

    // 2- Doble click
    public void doubleClick(String locator) {
        actions.doubleClick(findElementByXpath(locator));
    }

    // 3- Right click
    public void rightClick(String locator) {
        actions.contextClick(findElementByXpath(locator));
    }

    // CONTROL DE ALERTAS
    // Control de mensajes que aparecen al entrar en una web (newsletter etc)
    // frame/iframe => pagina como dentro de otra página
    // 1- Cambiar a la subpágina por ejemplo vídeos de youtube embebidos en la web
    public void swithcToiFrame(int iFrameIndex) {
        driver.switchTo().frame(iFrameIndex);
    }

    // 2- Cambiar a la página principal otra vez
    public void swithToParentFrame() {
        driver.switchTo().parentFrame();
    }

    // 3- Podemos aceptar/rechazar o validar contenido de un ALERT en el DOM
    // inhabilita la web
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }
}
