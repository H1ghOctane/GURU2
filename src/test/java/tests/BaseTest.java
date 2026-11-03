package tests;

import com.codeborne.selenide.Configuration;
import components.CelendarComponent;
import components.EasyFormPage;
import components.HardFormPage;
import helpers.Attach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.EasyFormStepsPage;
import pages.HardFormStepsPage;
import testPackage.FakerData;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    protected EasyFormStepsPage easyFormStepsPage = new EasyFormStepsPage();
    protected HardFormStepsPage hardFormStepsPage = new HardFormStepsPage();
    protected CelendarComponent celendarComponent = new CelendarComponent();
    protected FakerData faker = new FakerData();

    @BeforeAll
    static void setUpOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();

      //  options.setCapability("browserVersion", "128.0"); // Укажите актуальную версию из вашего Selenoid

        chromeOptions.addArguments("--disable-features=AutoDeElevate");
        Configuration.browserCapabilities = chromeOptions;
        Configuration.remote = "https://user1:1234@selenoid.qa.guru/wd/hub";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;

        chromeOptions.addArguments("--disable-dev-shm-usage", "--no-sandbox");
        chromeOptions.setCapability("se:cdpEnabled", false);
        chromeOptions.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = chromeOptions;
        Configuration.remote = "https://user1:1234@selenoid.qa.guru/wd/hub";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.addVideo();
        closeWebDriver();
    }
}

