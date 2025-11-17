package config;

public enum ConfiguracaoSistema {
    INSTANCIA;

    private String nomeLoja = "Loja Exemplo";
    private double taxaDescontoGlobal = 0.10;

    public String getNomeLoja() {
        return nomeLoja;
    }

    public double getTaxaDescontoGlobal() {
        return taxaDescontoGlobal;
    }
}

