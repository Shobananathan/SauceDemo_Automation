package contact_list.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
    WebDriver driver;

    @FindBy(id = "email")
    WebElement input_email;

    @FindBy(id = "password")
    WebElement input_password;

    @FindBy(id = "submit")
    WebElement input_submit;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        input_email.sendKeys(email);
        input_password.sendKeys(password);
        input_submit.click();
    }
}
