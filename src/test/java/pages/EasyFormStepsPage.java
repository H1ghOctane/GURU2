package pages;

import components.EasyFormPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class EasyFormStepsPage {

    private final EasyFormPage easyFormPage = new EasyFormPage();

    @Step("Открываем страницу Text Box")
    public EasyFormStepsPage openTextBoxPage() {
        open("/text-box");
        return this;
    }

    @Step("Заполняем поле User Name: {value}")
    public EasyFormStepsPage typeUserName(String value) {
        easyFormPage.typeUserName(value);
        return this;
    }

    @Step("Заполняем поле User Mail: {value}")
    public EasyFormStepsPage typeUserMail(String value) {
        easyFormPage.typeUserMail(value);
        return this;
    }

    @Step("Заполняем поле User Address: {value}")
    public EasyFormStepsPage typeUserAddress(String value) {
        easyFormPage.typeUserAddress(value);
        return this;
    }

    @Step("Заполняем поле Permanent Address: {value}")
    public EasyFormStepsPage typePermanentAddress(String value) {
        easyFormPage.typePermanentAddress(value);
        return this;
    }

    @Step("Нажимаем Submit")
    public EasyFormStepsPage submit() {
        easyFormPage.submit();
        return this;
    }

    @Step("Проверяем, что блок результата отображается")
    public EasyFormStepsPage checkOutputVisible() {
        easyFormPage.checkOutputVisible();
        return this;
    }

    @Step("Проверяем, что блок результата НЕ отображается")
    public EasyFormStepsPage checkOutputHidden() {
        easyFormPage.checkOutputHidden();
        return this;
    }

    @Step("Проверяем имя в результате: {name} {lastName}")
    public EasyFormStepsPage outputName(String name, String lastName) {
        easyFormPage.outputName(name, lastName);
        return this;
    }

    @Step("Проверяем email в результате: {value}")
    public EasyFormStepsPage outputEmail(String value) {
        easyFormPage.outputEmail(value);
        return this;
    }

    @Step("Проверяем текущий адрес в результате: {value}")
    public EasyFormStepsPage outputCurrentAddress(String value) {
        easyFormPage.outputCurrentAddress(value);
        return this;
    }

    @Step("Проверяем постоянный адрес в результате: {value}")
    public EasyFormStepsPage outputPermanentAddress(String value) {
        easyFormPage.outputPermanentAddress(value);
        return this;
    }
}