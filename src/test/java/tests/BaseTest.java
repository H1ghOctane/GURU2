package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import components.CelendarComponent;
import components.EasyFormPage;
import components.HardFormPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import testPackage.FakerData;

public class BaseTest {

    protected HardFormPage hardFormPage = new HardFormPage();
    protected CelendarComponent celendarComponent = new CelendarComponent();
    protected FakerData faker = new FakerData();
    protected EasyFormPage easyFormPage = new EasyFormPage();

    @BeforeAll
    static void beforeAll() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-features=AutoDeElevate");
        Configuration.browserCapabilities = options;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";

  }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();

    }
}


