package br.com.fatec.frete.service;

public class FreteCalculator {

    public static String calcularValorFrete(String uf) {
        return switch (uf.toUpperCase()) {
            case "SP", "PR" -> "FRETE GRATIS";
            case "RJ", "SC", "RS" -> "FRETE 20 REAIS";
            case "MG", "MT", "MS", "ES" -> "FRETE 50 REAIS";
            default -> "NÃO REALIZAMOS FRETE";
        };
    }
}
