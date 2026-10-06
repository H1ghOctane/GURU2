package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
public class HardFormTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        open("/automation-practice-form");
    }

    @DisplayName("Заполнение всех полей")
    @Test
    public void allFieldsTest() {


        hardFormPage
                .typeUserFirstName(faker.firstName)
                .typeUserLastName(faker.lastName)
                .typeUserMail(faker.mail)
                .typeUserGender(faker.gender)
                .typeUserNumber(faker.number);

        celendarComponent.setDate(faker.day, faker.month, faker.year);

        hardFormPage
                .typeSubject(faker.maths)
                .typeHobbies(faker.hobbies)
                .uploadPicture(faker.photo)
                .typeCurrentAddress(faker.city)
                .typeRegion(faker.region)
                .typeCityIndia(faker.cityIndia)
                .submit();

        hardFormPage
                .checkModalVisible()
                .checkUserName(faker.firstName + " " + faker.lastName)
                .checkMail(faker.mail)
                .checkGender(faker.gender)
                .checkNumber(faker.number)
                .checkDateOfBirth(faker.day + " " + faker.month + "," + faker.year)
                .checkSubject(faker.maths)
                .checkHobbies(faker.hobbies.get(0) + ", " + faker.hobbies.get(1))
                .checkPicture(faker.photo)
                .checkAddress(faker.city)
                .checkStateAndCity(faker.region + " " + faker.cityIndia);

    }

    @DisplayName("Заполнение только обязательных полей")
    @Test
    public void onlyRequiredFieldsTest() {

        hardFormPage
                .typeUserFirstName(faker.firstName)
                .typeUserLastName(faker.lastName)
                .typeUserGender(faker.gender)
                .typeUserNumber(faker.number)
                .submit()
                .checkModalVisible()
                .checkUserName(faker.firstName + " " + faker.lastName)
                .checkGender(faker.gender)
                .checkNumber(faker.number);

    }

    @DisplayName("Невозможность появления формы без заполнения пола")
    @Test
    public void withoutGenderTest() {

        hardFormPage
                .typeUserFirstName(faker.firstName)
                .typeUserLastName(faker.lastName)
                .typeUserNumber(faker.number)
                .submit()
                .checkModalNotVisible();

    }

    @DisplayName("Невозможность появления формы, если в номере меньше десяти цифр")
    @Test
    public void numberValidationTest() {

        hardFormPage
                .typeUserFirstName(faker.firstName)
                .typeUserLastName(faker.lastName)
                .typeUserGender(faker.gender)
                .typeUserNumber(faker.badNumber)
                .submit()
                .checkModalNotVisible();

    }

    @DisplayName("Невозможность появления формы, если указан неправильный мэйл")
    @Test
    public void mailValidationTest() {

        hardFormPage
                .typeUserFirstName(faker.firstName)
                .typeUserLastName(faker.lastName)
                .typeUserMail(faker.badMail)
                .typeUserGender(faker.gender)
                .typeUserNumber(faker.number)
                .submit()
                .checkModalNotVisible();

    }
}




