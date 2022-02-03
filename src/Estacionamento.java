import java.util.List;
import java.util.ArrayList;

public class Estacionamento {
    private String nome;
    private Endereco endereco;
    private float valorHora;
    private int vagas;
    private List<EntradaVeiculo> entradaVeiculos = new ArrayList<>(0);

    public Estacionamento(String nome, float valorHora, int vagas, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.valorHora = valorHora;
        this.vagas = vagas;
        this.endereco = endereco;
    }

    public void addVeiculos(EntradaVeiculo entrada) {
            this.entradaVeiculos.add(entrada);
            return;
        
    }
    
    public void removeVeiculos(String placa) {
        int value = 0;
        int value2 = -1;
        for(EntradaVeiculo veiculo : entradaVeiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                // System.out.println("21151613");
                // entradaVeiculos.remove(veiculo);
                value2 = value;
            }
            value = value +1;
        }
        if (value2 == -1) {
            return;
        }
        entradaVeiculos.remove(value2);
    }

    public List<EntradaVeiculo> getVeiculos() {
        return entradaVeiculos;
    }

    public int getVagas () {
        return vagas;
    }

    public String getNome() {
        return nome;
    }

}