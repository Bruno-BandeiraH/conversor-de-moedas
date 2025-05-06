package utils;

public class Message {

    public static void greetings(){
        System.out.println("-----------------------------------------------");
        System.out.println("Seja bem-vindo(a) ao conversor de moedas 1.0");
        System.out.println();
    }

    public static void chooseOption() {
        System.out.println("Por favor, selecione uma opção:");
    }

    public static void showCurrentCurrency(MenuOptions option) {
        System.out.printf("Você escolheu : %s.", option.getDescription());
        System.out.println();
    }

    public static void showNewCurrency(MenuOptions currency) {
        System.out.printf("Sua nova moeda será: %s.", currency.getDescription());
        System.out.println();
    }

    public static void chooseCurrencyToMakeExchange() {
        System.out.println();
        System.out.println("Agora escolha a moeda que você deseja fazer o câmbio:");
        System.out.println();
    }

    public static void askTheAmountToExchange() {
        System.out.println();
        System.out.println("Por favor, escreva a quantidade que deseja converter: ");
    }

    public static void convertedAmount(String amount, MenuOptions currency) {
        System.out.println();
        System.out.printf("Sucesso! O valor convertido para \"%s\" foi: %s.",
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
        System.out.printf("Você escolheu \"%s\" de novo. Por favor, escolha outra opção.", option.getDescription());
        System.out.println();
    }
}
