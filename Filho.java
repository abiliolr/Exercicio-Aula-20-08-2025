//Classe Filho que herda da Classe Pessoa
public class Filho extends Pessoa {
    private String brinquedoFavorito; // Atributo específico de Filho

    public String getBrinquedoFavorito() {
        return brinquedoFavorito;
    }

    public void setBrinquedoFavorito(String brinquedoFavorito) {
        this.brinquedoFavorito = brinquedoFavorito;
    }

    @Override
    public String getTipoVoz() {
        return "Voz aguda e animada";
    }
}
