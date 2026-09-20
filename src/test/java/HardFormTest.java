import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static TestPackage.TestData.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HardFormTest extends BaseTest {

    @BeforeEach
    public void setUp() {
        open("/automation-practice-form");
    }

    @DisplayName("Заполнение всех полей")
    @Test
    public void allFieldsTest() {
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(mail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__day--026").click();
        $("#subjectsInput").setValue(maths).pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies.getFirst())).click();
        $("#hobbiesWrapper").$(byText(hobbies.get(1))).click();
        $("#uploadPicture").uploadFromClasspath(photo);
        $("#currentAddress").setValue(city);
        $("#react-select-3-input").setValue(region).pressEnter();
        $("#react-select-4-input").setValue(cityIndia).pressEnter();
        $("#submit").click();

        $(".modal-dialog.modal-lg").shouldBe(visible);
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(name + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(mail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(maths));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobbies.getFirst() + "," + " " + hobbies.get(1)));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(photo));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(city));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(region + " " + cityIndia));
    }

    @DisplayName("Заполнение только обязательных полей")
    @Test
    public void onlyRequiredFieldsTest() {
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#gender-radio-1").click();
        $("#userNumber").setValue(userNumber);
        $("#submit").scrollTo().pressEnter();

        $(".modal-dialog.modal-lg").shouldBe(visible);
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(name + " " + lastName));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
    }

    @DisplayName("Невозможность появления формы без заполнения пола")
    @Test
    public void withoutGenderTest() {
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userNumber").setValue(userNumber);
        $("#submit").scrollTo().shouldBe(visible).pressEnter();
        $(".modal-dialog.modal-lg").shouldNotBe(visible);
    }

    @DisplayName("Невозможность появления формы, если в номере меньше десяти цифр")
    @Test
    public void numberValidationTest() {
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#gender-radio-1").click();
        $("#userNumber").setValue(badUserNumber);
        $("#submit").pressEnter();
        $(".modal-dialog.modal-lg").shouldNotBe(visible);
    }

    @DisplayName("Невозможность появления формы, если указан неправильный мэйл")
    @Test
    public void mailValidationTest() {
        $("#firstName").setValue(name);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(badMail);
        $("#gender-radio-1").click();
        $("#userNumber").setValue(userNumber);
        $("#submit").scrollTo().shouldBe(visible).pressEnter();
        $(".modal-dialog.modal-lg").shouldNotBe(visible);
    }
}




