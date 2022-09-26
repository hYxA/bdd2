package ru.netology.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MoneyTransferPage {
    private final SelenideElement amountTransfer = $$(".input__control").get(0);
    private final SelenideElement from = $$(".input__control").get(1);
    private final SelenideElement actionTransfer = $("[data-test-id=action-transfer]");


    public MoneyTransferPage() {
        SelenideElement amount = $("[data-test-id=amount]");
        amount.shouldBe(Condition.visible);
    }

    public void topUpCardBalance(int amount, int index) {
        amountTransfer.sendKeys(String.valueOf(amount)); // Ввод суммы перевода
        from.sendKeys(String.valueOf(DataHelper.getCardNumber(index))); // Ввод номера карты, с которой произвести транзакцию
        actionTransfer.click(); // Кнопка пополнить
    }

}
