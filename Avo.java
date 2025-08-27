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
