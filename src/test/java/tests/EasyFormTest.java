package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static testPackage.TestData.*;

public class EasyFormTest extends BaseTest {

    @BeforeEach
    void beforeEach() {
        open("/text-box");
    }

    @DisplayName("Заполнение всех полей")
    @Test
    public void allFieldsTest() {

        easyFormPage
                .typeUserName(firstName + " " + lastName)
                .typeUserMail(mail)
                .typeUserAddress(address)
                .typePermanentAddress(address)
                .submit()
                .checkOutputVisible()
                .outputName(firstName, lastName)
                .outputEmail(mail)
                .outputCurrentAddress(address)
                .outputPermanentAddress(address);

    }

    @DisplayName("Валидация поля мэйла")
    @Test
    public void emailValidationTest() {

        easyFormPage.
                typeUserMail(badMail)
                .submit()
                .checkOutputHidden();
    }
}
