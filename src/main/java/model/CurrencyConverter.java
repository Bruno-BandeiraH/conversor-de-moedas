package model;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    private final Map<String, Double> conversionRates;

    public CurrencyConverter(Map<String, Double> conversionRates) {
        this.conversionRates = conversionRates;
    }

    public String convertCurrency(String currentCurreny, String newCurrency,
                                  double amount) {
        double amountInUSD = amount / conversionRates.get(currentCurreny);
        double amountConverted = amountInUSD * conversionRates.get(newCurrency);
        return String.format("%.2f", amountConverted);
    }

    public static double getValidAmount(Scanner scanner) {
        double amount = 0;
        boolean valid = false;

        while (!valid) {

            try{
                amount = scanner.nextDouble();
                if(amount > 0) {
                    valid = true;
                } else {
                    System.out.println("Por favor insira um valor positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira uma quantia válida usando vírgula para as casas decimais.");
                scanner.nextLine(); // to clean the buffer
            }
        }
        return amount;
    }
}
