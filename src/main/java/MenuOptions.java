import java.util.InputMismatchException;
import java.util.Scanner;

public enum MenuOptions {
    SAIR("SAIR", "sair do menu"),
    BRL("BRL", "Real brasileiro"),
    VES("VES", "Bolívar venezuelano"),
    BOB("BOB", "Boliviano da Bolivia"),
    CNY("CNY", "Yuan chinês"),
    JPY("JPY", "Iene japonês"),
    CLP("CLP", "Peso chileno"),
    RUB("RUB", "Rublo russo"),
    USD("USD", "Dólar americano");


    private final String description;
    private final String code;

    MenuOptions(String code, String description) {
        this.description = description;
        this.code = code;
    }

    public static boolean isSameCurrency(MenuOptions currentCurrency, MenuOptions newCurrency) {
        return currentCurrency == newCurrency;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return code;
    }

    public static void displayMenu() {
        System.out.println("---------------------------");
        for(MenuOptions option : MenuOptions.values()) {
            if(option != SAIR) {
                System.out.printf("%s - %s (%s)\n",
                    option.ordinal(),
                    option.getDescription(),
                    option.getCode());
            }
        }
        System.out.printf("%d - %s", SAIR.ordinal(), SAIR.getDescription());
        System.out.println();
    }

    public static MenuOptions getByNumber(int number) {
        if(number < 0 || number > values().length) {
            return null;
        }
        return values()[number];
    }

    public static MenuOptions chooseOptionFromMenu(Scanner scanner) {
        int choice = 0;
        boolean validInput = false;

        while(!validInput) {
            Message.chooseCurrency();
            displayMenu();
            try{
                choice = scanner.nextInt();
                if(choice < 0 || choice > MenuOptions.values().length) {
                    System.out.println("Opção inválida!");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Acho que isso não é um número. Por favor, insira uma opção válida.");
                scanner.nextLine();
                System.out.println();
            }
        }
        return MenuOptions.getByNumber(choice);
    }

    public static boolean isCurrencyCode(MenuOptions option) {
        return option != MenuOptions.SAIR;
    }
}
