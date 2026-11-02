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

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    protected HardFormPage hardFormPage = new HardFormPage();
    protected CelendarComponent celendarComponent = new CelendarComponent();
    protected FakerData faker = new FakerData();
    protected EasyFormPage easyFormPage = new EasyFormPage();

    @BeforeAll
    static void setUpOptions() {
        ChromeOptions options = new ChromeOptions();
        // Явно указываем версию браузера (если она есть в вашем Selenoid)
      //  options.setCapability("browserVersion", "128.0"); // Укажите актуальную версию из вашего Selenoid

        // Специфичные для Selenoid настройки помещаем в selenoid:options
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);      // Включает VNC для просмотра сессии
        selenoidOptions.put("enableVideo", true);    // Включает запись видео (если настроено на сервере)
        selenoidOptions.put("name", "My Test Session"); // Имя сессии для удобства
        options.setCapability("selenoid:options", selenoidOptions);

        // Ваш существующий аргумент
        options.addArguments("--disable-features=AutoDeElevate");

        Configuration.browserCapabilities = options;
        Configuration.remote = "https://user1:1234@selenoid.qa.guru/wd/hub";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
   //     Configuration.browser = "chrome"; // Теперь явно указываем браузер
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();

    }
}


