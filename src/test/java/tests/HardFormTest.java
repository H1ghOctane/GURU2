package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static testPackage.FakerData.*;
public class HardFormTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        open("/automation-practice-form");
    }

    @DisplayName("Заполнение всех полей")
    @Test
    public void allFieldsTest() {

        hardFormPage
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .typeUserMail(mail)
                .typeUserGender(gender)
                .typeUserNumber(number);

        celendarComponent.setDate(day, month, year);

        hardFormPage
                .typeSubject(maths)
                .typeHobbies(hobbies)
                .uploadPicture(photo)
                .typeCurrentAddress(city)
                .typeRegion(region)
                .typeCityIndia(cityIndia)
                .submit();

        hardFormPage
                .checkModalVisible()
                .checkUserName(firstName + " " + lastName)
                .checkMail(mail)
                .checkGender(gender)
                .checkNumber(number)
                .checkDateOfBirth(day + " " + month + "," + year)
                .checkSubject(maths)
                .checkHobbies(hobbies.get(0) + ", " + hobbies.get(1))
                .checkPicture(photo)
                .checkAddress(city)
                .checkStateAndCity(region + " " + cityIndia);

    }

    @DisplayName("Заполнение только обязательных полей")
    @Test
    public void onlyRequiredFieldsTest() {

        hardFormPage
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .typeUserGender(gender)
                .typeUserNumber(number)
                .submit()
                .checkModalVisible()
                .checkUserName(firstName + " " + lastName)
                .checkGender(gender)
                .checkNumber(number);

    }

    @DisplayName("Невозможность появления формы без заполнения пола")
    @Test
    public void withoutGenderTest() {

        hardFormPage
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .typeUserNumber(number)
                .submit()
                .checkModalNotVisible();

    }

    @DisplayName("Невозможность появления формы, если в номере меньше десяти цифр")
    @Test
    public void numberValidationTest() {

        hardFormPage
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .typeUserGender(gender)
                .typeUserNumber(badNumber)
                .submit()
                .checkModalNotVisible();

    }

    @DisplayName("Невозможность появления формы, если указан неправильный мэйл")
    @Test
    public void mailValidationTest() {

        hardFormPage
                .typeUserFirstName(firstName)
                .typeUserLastName(lastName)
                .typeUserMail(badMail)
                .typeUserGender(gender)
                .typeUserNumber(number)
                .submit()
                .checkModalNotVisible();

    }
}




