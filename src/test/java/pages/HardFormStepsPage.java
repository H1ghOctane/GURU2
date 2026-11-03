package pages;

import components.HardFormPage;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;

public class HardFormStepsPage {

    private final HardFormPage hardFormPage = new HardFormPage();

    @Step("Открываем страницу Automation Practice Form")
    public HardFormStepsPage openHardFormPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Заполняем First Name: {value}")
    public HardFormStepsPage typeUserFirstName(String value) {
        hardFormPage.typeUserFirstName(value);
        return this;
    }

    @Step("Заполняем Last Name: {value}")
    public HardFormStepsPage typeUserLastName(String value) {
        hardFormPage.typeUserLastName(value);
        return this;
    }

    @Step("Заполняем Email: {value}")
    public HardFormStepsPage typeUserMail(String value) {
        hardFormPage.typeUserMail(value);
        return this;
    }

    @Step("Выбираем Gender: {value}")
    public HardFormStepsPage typeUserGender(String value) {
        hardFormPage.typeUserGender(value);
        return this;
    }

    @Step("Заполняем Mobile: {value}")
    public HardFormStepsPage typeUserNumber(String value) {
        hardFormPage.typeUserNumber(value);
        return this;
    }

    @Step("Загружаем Picture: {value}")
    public HardFormStepsPage uploadPicture(String value) {
        hardFormPage.uploadPicture(value);
        return this;
    }

    @Step("Выбираем Hobbies: {hobbies}")
    public HardFormStepsPage typeHobbies(List<String> hobbies) {
        hardFormPage.typeHobbies(hobbies);
        return this;
    }

    @Step("Выбираем Subject: {value}")
    public HardFormStepsPage typeSubject(String value) {
        hardFormPage.typeSubject(value);
        return this;
    }

    @Step("Заполняем Current Address: {value}")
    public HardFormStepsPage typeCurrentAddress(String value) {
        hardFormPage.typeCurrentAddress(value);
        return this;
    }

    @Step("Выбираем State: {value}")
    public HardFormStepsPage typeRegion(String value) {
        hardFormPage.typeRegion(value);
        return this;
    }

    @Step("Выбираем City: {value}")
    public HardFormStepsPage typeCityIndia(String value) {
        hardFormPage.typeCityIndia(value);
        return this;
    }

    @Step("Проверяем поле '{label}' = '{value}'")
    public HardFormStepsPage checkValue(String label, String value) {
        hardFormPage.checkValue(label, value);
        return this;
    }

    @Step("Проверяем Student Name: {value}")
    public HardFormStepsPage checkUserName(String value) {
        hardFormPage.checkUserName(value);
        return this;
    }

    @Step("Проверяем Student Email: {value}")
    public HardFormStepsPage checkMail(String value) {
        hardFormPage.checkMail(value);
        return this;
    }

    @Step("Проверяем Gender: {value}")
    public HardFormStepsPage checkGender(String value) {
        hardFormPage.checkGender(value);
        return this;
    }

    @Step("Проверяем Mobile: {value}")
    public HardFormStepsPage checkNumber(String value) {
        hardFormPage.checkNumber(value);
        return this;
    }

    @Step("Проверяем Date of Birth: {value}")
    public HardFormStepsPage checkDateOfBirth(String value) {
        hardFormPage.checkDateOfBirth(value);
        return this;
    }

    @Step("Проверяем Subjects: {value}")
    public HardFormStepsPage checkSubject(String value) {
        hardFormPage.checkSubject(value);
        return this;
    }

    @Step("Проверяем Hobbies: {value}")
    public HardFormStepsPage checkHobbies(String value) {
        hardFormPage.checkHobbies(value);
        return this;
    }

    @Step("Проверяем Picture: {value}")
    public HardFormStepsPage checkPicture(String value) {
        hardFormPage.checkPicture(value);
        return this;
    }

    @Step("Проверяем Address: {value}")
    public HardFormStepsPage checkAddress(String value) {
        hardFormPage.checkAddress(value);
        return this;
    }

    @Step("Проверяем State and City: {value}")
    public HardFormStepsPage checkStateAndCity(String value) {
        hardFormPage.checkStateAndCity(value);
        return this;
    }

    @Step("Проверяем, что модальное окно НЕ появилось")
    public HardFormStepsPage checkModalNotVisible() {
        hardFormPage.checkModalNotVisible();
        return this;
    }

    @Step("Проверяем, что модальное окно появилось")
    public HardFormStepsPage checkModalVisible() {
        hardFormPage.checkModalVisible();
        return this;
    }

    @Step("Нажимаем Submit")
    public HardFormStepsPage submit() {
        hardFormPage.submit();
        return this;
    }
}