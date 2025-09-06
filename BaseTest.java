package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = "https://dev-dash.janitri.in/";

    @BeforeClass
    public void setUp() {
 
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if(driver != null) driver.quit();
    }
}
