package pages.test2_sandbox;

import pages.BasePage;

public class SandBoxPage extends BasePage {

    private String categoryDropdown = "topic-select-menu";

    public SandBoxPage() {
        super(driver);
    }

    // Para correr static server necesitamos npm install -g static-server
    // Después accedemos a la ruta en la cual tenemos el index.html con el proyecto
    // escribimos en consola static-server y levantamos el servidor
    public void navigateToSandbox() {
        navigateTo("http://localhost:9080/");
    }

    public void selectCategory(String category) {
        selectFromDropdownByValue(categoryDropdown, category);
    }

}
