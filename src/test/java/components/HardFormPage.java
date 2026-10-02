package components;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HardFormPage {

    private final SelenideElement firstNameInput  = $("#firstName");
    private final SelenideElement lastNameInput   = $("#lastName");
    private final SelenideElement userEmailInput  = $("#userEmail");
    private final SelenideElement genderWrapper   = $("#genterWrapper");
    private final SelenideElement userNumberInput = $("#userNumber");
    private final SelenideElement subjectsInput   = $("#subjectsInput");
    private final SelenideElement hobbiesWrapper  = $("#hobbiesWrapper");
    private final SelenideElement pictureInput    = $("#uploadPicture");
    private final SelenideElement currentAddress  = $("#currentAddress");
    private final SelenideElement stateInput      = $("#react-select-3-input");
    private final SelenideElement cityInput       = $("#react-select-4-input");
    private final SelenideElement submitButton    = $("#submit");

    private final SelenideElement subjectsMenu = $(".subjects-auto-complete__menu");
    private final SelenideElement resultModal  = $(".modal-dialog.modal-lg");
    private final SelenideElement resultTable  = $(".table-responsive");

    public HardFormPage typeUserFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public HardFormPage typeUserLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public HardFormPage typeUserMail(String value) {
        userEmailInput.setValue(value);
        return this;

    }

    public HardFormPage typeUserGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public HardFormPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;

    }

    public HardFormPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);
        return this;

    }

    public HardFormPage typeHobbies(List<String> hobbies) {
        hobbies.forEach(hobby ->
                hobbiesWrapper.$(byText(hobby)).click()
        );
        return this;
    }

    public HardFormPage typeSubject(String value) {
        subjectsInput.setValue(value).pressEnter();   // ← используем поле
        subjectsInput.pressEscape();
        subjectsMenu.shouldNotBe(visible);
        return this;
    }

    public HardFormPage typeCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;

    }

    public HardFormPage typeRegion(String value) {
        stateInput.setValue(value).pressEnter();
        return this;

    }

    public HardFormPage typeCityIndia(String value) {
        cityInput .setValue(value).pressEnter();
        return this;
    }

    public HardFormPage checkValue(String label, String value) {
        resultTable.$(byText(label)).parent().shouldHave(text(value));
        return this;
    }

    public HardFormPage checkUserName(String value) {
        return checkValue("Student Name", value);
    }

    public HardFormPage checkMail(String value) {
        return checkValue("Student Email", value);
    }

    public HardFormPage checkGender(String value) {
        return checkValue("Gender", value);
    }

    public HardFormPage checkNumber(String value) {
        return checkValue("Mobile", value);
    }

    public HardFormPage checkDateOfBirth(String value) {
        return checkValue("Date of Birth", value);
    }

    public HardFormPage checkSubject(String value) {
        return checkValue("Subjects", value);
    }

    public HardFormPage checkHobbies(String value) {
        return checkValue("Hobbies", value);
    }

    public HardFormPage checkPicture(String value) {
        return checkValue("Picture", value);
    }

    public HardFormPage checkAddress(String value) {
        return checkValue("Address", value);
    }

    public HardFormPage checkStateAndCity(String value) {
        return checkValue("State and City", value);
    }
    public HardFormPage checkModalNotVisible() {
        resultModal.shouldNotBe(visible);
        return this;
    }
    public HardFormPage checkModalVisible() {
        resultModal.shouldBe(visible);
        return this;
    }

    public HardFormPage submit() {
        submitButton.scrollTo().shouldBe(visible).pressEnter();
        return this;
    }

}