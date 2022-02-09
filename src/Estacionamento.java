import java.util.List;
import java.util.ArrayList;

public class Estacionamento {
    private String nome;
    private Endereco endereco;
    private double valorHora;
    private int vagas;
    private List<EntradaVeiculo> entradaVeiculos = new ArrayList<>();
    private List<EntradaVeiculo> registroDeVeicuos = new ArrayList<>();

    public Estacionamento(String nome, double valorHora, int vagas, Endereco endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.valorHora = valorHora;
        this.vagas = vagas;
        this.endereco = endereco;
    }

    public void setEndereco(String rua, int num, String bairro, String cidade, String uf) {
        this.endereco.setRua(rua);
        this.endereco.setNumero(num);
        this.endereco.setBairro(bairro);
        this.endereco.setCidade(cidade);
        this.endereco.setUf(uf);
    }

    public void addVeiculos(EntradaVeiculo entrada) {
        this.entradaVeiculos.add(entrada);
        return;
    }
    
    public List<String> removeVeiculos(String placa) {
        int value = 0;
        int value2 = -1;
        for(EntradaVeiculo veiculo : entradaVeiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                value2 = value;
            }
            value = value +1;
        }
        if (value2 != -1) {
            entradaVeiculos.get(value2).setDataHoraSaida();
            double valor = getValorEstacionamento(entradaVeiculos.get(value2));
            addRegistroDeVeicuos(value2);
            List<String> lista = new ArrayList<>();
            lista.add(String.valueOf(valor));
            lista.add(String.valueOf(entradaVeiculos.get(value2).getDataHoraEntrada()));
            lista.add(String.valueOf(entradaVeiculos.get(value2).getDataHoraSaida()));
            entradaVeiculos.remove(value2);
            return lista;
        } else {
            return new ArrayList<>();  
        }
    }

    public double getValorEstacionamento(EntradaVeiculo entradaVeiculo) {
        entradaVeiculo.setMilisegundosSaida();
        double qtd = entradaVeiculo.getMilissegundosSaida() - entradaVeiculo.getMilissegundosEntrada();
        entradaVeiculo.setQtdHoras(qtd);
        double valorEstacionamento = ((qtd)/3600000)*valorHora;
        return valorEstacionamento;
    }

    public void addRegistroDeVeicuos (int index) {
        registroDeVeicuos.add(entradaVeiculos.get(index));
    }

    public List<EntradaVeiculo> getVeiculos() {
        return entradaVeiculos;
    }

    public int getVagas () {
        return vagas;
    }

    public void setVagas (int vagas) {
        this.vagas = vagas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora (double valorHora) {
        this.valorHora = valorHora;
    }

}