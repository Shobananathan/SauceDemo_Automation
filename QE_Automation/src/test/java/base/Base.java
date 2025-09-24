package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class Base {
    public WebDriver driver;
    public Properties props;

    @BeforeMethod
    @Parameters({"app"})
    public void initializeDriver(@Optional("bank") String app) throws IOException {
        // 1. Prefer system property (-Dapp=bank / sauce / contact)
        if (System.getProperty("app") != null) {
            app = System.getProperty("app");
        }

        // 2. Load app-specific config
        String configFile = "properties/config-" + app + ".properties";
        props = new Properties();

        try (InputStream input = getClass().getClassLoader().getResourceAsStream(configFile)) {
            if (input == null) {
                throw new RuntimeException("Config file not found: " + configFile);
            }
            props.load(input);
        }

        String browser = props.getProperty("BROWSER", "CHROME");
        String url = props.getProperty("URL");

        // Driver setup with simple if/else
        if (browser.equalsIgnoreCase("CHROME")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("IE")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else {
            throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);

        System.out.println("Running app: " + app);
        System.out.println(" Browser: " + browser);
        System.out.println(" URL: " + url);
    }

    @AfterMethod
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
