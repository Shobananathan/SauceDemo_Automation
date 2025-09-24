package ACME_Demo_Banking.test;


import ACME_Demo_Banking.page.BankLoginPage;
import base.Base;
import org.testng.annotations.Test;

public class demoTest extends Base {

    @Test
    public void signIn(){
        BankLoginPage blogin = new BankLoginPage(driver);
        blogin.loginUser("Shobana","******");
    }
}
