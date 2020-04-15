package ru.Netology;

import lombok.val;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestingTransferFunctionFromCardToCard {

    @Test
    void TestingTransferFunctionFromCardToCardTest () {
        open("http://localhost:9999");
        val loginPage = new LoginPage();
        val authInfo = DataHelper.getAuthInfo();
        val verificationPage = loginPage.validLogin(authInfo);
        val verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] [data-test-id='action-deposit'] .button__text") .click();
        $("[data-test-id='amount'] input") .setValue("1");
        $("[data-test-id=\"from\"] input") .setValue("5559 0000 0000 0002");
        $("[data-test-id=\"action-transfer\"]") .click();
        $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"] .button") .click();
        $("[data-test-id='amount'] input").clear();
        $("[data-test-id='amount'] input") .setValue("1");
        $("[data-test-id=\"from\"] input") .setValue("5559 0000 0000 0001");
        $("[data-test-id=\"action-transfer\"]") .click();
        $("[data-test-id='92df3f1c-a033-48e6-8390-206f6b1f56c0'] [data-test-id='action-deposit'] .button__text") .click();
        $("[data-test-id='amount'] input").clear();
        $("[data-test-id='amount'] input") .setValue("9999");
        $("[data-test-id=\"from\"] input") .setValue("5559 0000 0000 0002");
        $("[data-test-id=\"action-transfer\"]") .click();


    }


}
