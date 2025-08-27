//Classe Pessoa
public abstract class Pessoa{
    private String nome;
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public abstract String getTipoVoz();
}

//Classe Avo que herda da Classe Pessoa
public class Avo extends Pessoa {
    private int idade;

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String getTipoVoz() {
        return "Voz grave e sábia";
    }
}

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
