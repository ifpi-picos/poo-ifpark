import java.text.SimpleDateFormat;
import java.util.Date;

public class EntradaVeiculo {
    private String placa;
    private String dataHoraEntrada = setDataHoraEntrada();
    private String dataHoraSaida;
    private double qtdHoras;
    private long milissegundosEntrada = System.currentTimeMillis();
    private long milissegundosSaida;

    public EntradaVeiculo(String placa) {
        this.placa = placa;
    } 

    public String getPlaca () {
        return this.placa;
    }

    public String setDataHoraEntrada () {
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String dataFormatada = formatar.format(data);
        return dataFormatada;
    }

    public void setDataHoraSaida () {
        Date data = new Date();
        SimpleDateFormat formatar = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String dataFormatada = formatar.format(data);
        this.dataHoraSaida = dataFormatada;
    }

    public String getDataHoraEntrada () {
        return this.dataHoraEntrada;
    }
    
    public String getDataHoraSaida () {
        return this.dataHoraSaida;
    }

    public void setMilisegundosSaida () {
        long milissegundos = System.currentTimeMillis();
        this.milissegundosSaida = milissegundos;
    }

    public long getMilissegundosEntrada () {
        return milissegundosEntrada;
    }

    public long getMilissegundosSaida () {
        return milissegundosSaida;
    }

    public void setQtdHoras (double qtd) {
        this.qtdHoras = qtd;
    }

    public double getQtdHoras (double qtd) {
        return this.qtdHoras;
    }
}