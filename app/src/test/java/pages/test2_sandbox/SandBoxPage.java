package pages.test2_sandbox;

import pages.BasePage;

public class SandBoxPage extends BasePage {

    private String categoryDropdown = "topic-select-menu";

    public SandBoxPage() {
        super(driver);
    }

    public void navigateToSandbox() {
        navigateTo("http://localhost:9080/");
    }

    public void selectCategory(String category) {
        selectFromDropdownByValue(categoryDropdown, category);
    }

}
