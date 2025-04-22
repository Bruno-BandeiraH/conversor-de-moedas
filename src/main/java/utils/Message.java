package utils;

import utils.MenuOptions;

public class Message {

    public static void greetings(){
        System.out.println("-----------------------------------------------");
        System.out.println("Seja bem-vindo(a) ao super conversor de moedas 3.0");
        System.out.println();
    }

    public static void chooseCurrency() {
        System.out.println("Por favor, selecione uma moeda:");
    }

    public static void showCurrentCurrency(MenuOptions currency) {
        System.out.printf("Sua moeda atual é: %s", currency.getDescription());
        System.out.println();
    }

    public static void showNewCurrency(MenuOptions currency) {
        System.out.printf("Sua nova moeda será: %s", currency.getDescription());
        System.out.println();
    }

    public static void chooseCurrencyToMakeExchange() {
        System.out.println();
        System.out.println("Agora escolha a moeda que você deseja fazer o câmbio:");
        System.out.println();
    }

    public static void askTheAmountToExchange() {
        System.out.println();
        System.out.println("Por favor, escreva a quantidade que deseja converter:");
    }

    public static void convertedAmount(String amount, MenuOptions currency) {
        System.out.println();
        System.out.printf("Sucesso! O valor convertido para %s foi: %s",
            currency.getDescription(),
            amount);
        System.out.println();
        System.out.println();
    }

    public static void endingApplication() {
        System.out.println();
        System.out.println("Até a próxima. Estamos encerrando o programa.");
        System.out.println();
    }

    public static void chooseDifferentOption(MenuOptions option) {
        System.out.println();
        System.out.printf("Você escolheu %s de novo. Por favor, escolha outra opção", option.getDescription());
        System.out.println();
    }
}
