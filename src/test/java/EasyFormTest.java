import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static testPackage.TestData.*;
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
        $("#userName").setValue(name + " " + lastName);
        $("#userEmail").setValue(mail);
        $("#currentAddress").setValue(address);
        $("#permanentAddress").setValue(address);
        $("#submit").pressEnter();

        $("#output").shouldBe(visible);
        $("#output #name").shouldHave(text(name + " " + lastName));
        $("#output #email").shouldHave(text(mail));
        $("#output #currentAddress").shouldHave(text("Current Address :" + address));
        $("#output #permanentAddress").shouldHave(text(address));
    }

    @DisplayName("Валидация поля мэйла")
    @Test
    public void emailValidationTest() {
        $("#userEmail").setValue(badMail);
        $("#submit").pressEnter();
        $("#output").shouldNotBe(visible);
    }
}
