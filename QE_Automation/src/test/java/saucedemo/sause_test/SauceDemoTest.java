package saucedemo.sause_test;

import base.Base;
import org.testng.Assert;
import org.testng.annotations.Test;
import saucedemo.data_provider.SauceDemo_DP;
import saucedemo.page.loginPage;

public class SauceDemoTest extends Base {
    @Test(dataProvider = "DP_SauceDemo", dataProviderClass = SauceDemo_DP.class)
    public void validateLogin(String id, String TC_id, String description, String iteration, String Username, String Password,
                              String expected) {
        loginPage login = new loginPage(driver);
        login.loginUser(Username,Password);
        boolean loginSuccess = driver.getCurrentUrl().contains("inventory.html");
        String actual = loginSuccess ? "Pass" : "Fail";
        System.out.println("TC : " + TC_id + "|"+ " Username : " + Username + "|"+ " Password : " + "*******" + "|"+ " Expected : " + expected +"|"+ " Actual : " + actual);
        Assert.assertEquals(actual,expected,"Login validation failed");
    }

}
