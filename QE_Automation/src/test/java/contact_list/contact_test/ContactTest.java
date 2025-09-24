package contact_list.contact_test;

import base.Base;
import contact_list.page.ContactPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTest extends Base {
    @Test
    public void contact() {
        ContactPage contactPage = new ContactPage(driver);  // driver comes from Base
        contactPage.login("List@contact.com", "122334");

        boolean isEmailVisible = driver.findElement(By.id("email")).isDisplayed();
        boolean isPasswordVisible = driver.findElement(By.id("password")).isDisplayed();
        Assert.assertTrue(isEmailVisible && isPasswordVisible, "Login page not displayed as expected");
        System.out.println("Assertion Passed: Both email and password fields are visible.");



    }
}
