package service;

import model.CurrencyConverter;
import utils.MenuOptions;
import utils.Message;

import java.util.Scanner;

public class CurrencyConversionService {
    private final Scanner scanner;
    private final CurrencyConverter converter;

    public CurrencyConversionService(Scanner scanner, CurrencyConverter converter) {
        this.scanner = scanner;
        this.converter = converter;
    }


    public void run() {
        Message.greetings();
        MenuOptions option;
        do {
            MenuOptions currentCurrency;
            MenuOptions newCurrency = null;

            option = MenuOptions.chooseOptionFromMenu(scanner);
            if(MenuOptions.isCurrencyCode(option)) {
                currentCurrency = option;
            } else {
                break;
            }

            Message.showCurrentCurrency(currentCurrency);
            while(newCurrency == null || newCurrency == currentCurrency) {
                Message.chooseCurrencyToMakeExchange();
                option = MenuOptions.chooseOptionFromMenu(scanner);
                if (option == MenuOptions.SAIR) {
                    newCurrency = option;
                } else {
                    if (MenuOptions.isSameCurrency(currentCurrency, option)) {
                        Message.chooseDifferentOption(option);
                    }
                    newCurrency = option;
                }
            }
            if(newCurrency == MenuOptions.SAIR){
                break;
            }
            Message.showNewCurrency(newCurrency);
            Message.askTheAmountToExchange();

            double amount = CurrencyConverter.getValidAmount(scanner);

            String amountConverted = converter
                .convertCurrency(currentCurrency.getCode(), newCurrency.getCode(), amount);

            Message.convertedAmount(amountConverted, newCurrency);
        } while (option != MenuOptions.SAIR);
        Message.endingApplication();
    }
}
