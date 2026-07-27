import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EasyFormTest extends BaseTest {

    @BeforeEach
    void beforeEach() {
        open("/text-box");
    }

    @DisplayName("Заполнение всех полей")
    @Test
    public void allFieldsTest() {
        $("#userName").setValue("Pavel Maltsev");
        $("#userEmail").setValue("mail@mail.com");
        $("#currentAddress").setValue("Moscow");
        $("#permanentAddress").setValue("North Korea");
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output #name").shouldHave(text("Pavel Maltsev"));
        $("#output #email").shouldHave(text("mail@mail.com"));
        $("#output #currentAddress").shouldHave(text("Current Address :Moscow"));
        $("#output #permanentAddress").shouldHave(text("North Korea"));
    }

    @DisplayName("Валидация поля мэйла")
    @Test
    public void emailValidationTest() {
        $("#userEmail").setValue("1");
        $("#submit").click();
        $("#output").shouldNotBe(visible);
    }
}
