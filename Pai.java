//Classe Pai que herda da Classe Pessoa
public class Pai extends Pessoa {
    private String profissao;

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissão = profissao;
    }

    @Override
    public String getTipoVoz() {
        return "Voz firme e orientadora";
    }
}
