package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class EasyFormTest extends BaseTest {

    @BeforeEach
    void beforeEach() {
        open("/text-box");
    }

    @DisplayName("Заполнение всех полей")
    @Test
    public void allFieldsTest() {


        easyFormPage
                .typeUserName(faker.firstName + " " + faker.lastName)
                .typeUserMail(faker.mail)
                .typeUserAddress(faker.address)
                .typePermanentAddress(faker.address)
                .submit()
                .checkOutputVisible()
                .outputName(faker.firstName, faker.lastName)
                .outputEmail(faker.mail)
                .outputCurrentAddress(faker.address)
                .outputPermanentAddress(faker.address);

    }

    @DisplayName("Валидация поля мэйла")
    @Test
    public void emailValidationTest() {

        easyFormPage.
                typeUserMail(faker.badMail)
                .submit()
                .checkOutputHidden();
    }
}
