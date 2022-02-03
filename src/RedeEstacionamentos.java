import java.util.ArrayList;
import java.util.List;

public class RedeEstacionamentos {

    private List<Estacionamento> estacionamentos = new ArrayList<>();

    public void adicionarEstacionamento(Estacionamento estacionamento){
        estacionamentos.add(estacionamento);
    }

    public void removerEstacionamento(int index){
        estacionamentos.remove(index);
    }

    public int getSize () {
        return estacionamentos.size();
    }

    public List<Estacionamento> getList () {
        return estacionamentos;
    }
}