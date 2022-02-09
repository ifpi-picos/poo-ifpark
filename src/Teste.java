import javax.swing.JOptionPane;
import java.util.List;

public class Teste {
  public static void main(String[] args) throws Exception {

    RedeEstacionamentos estacionamento = new RedeEstacionamentos();
   
    boolean continuar = true;

    while (continuar == true) {

      if (estacionamento.getSize() == 0) {
        JOptionPane.showMessageDialog(null, "!Seja bem vindo ao ifPark!");
        JOptionPane.showMessageDialog(null, "Não há nenhum estacionamento cadastrado, adicione um!", "Waring",
            JOptionPane.WARNING_MESSAGE);

        String nome = JOptionPane.showInputDialog(null, "Nome do estacionamento: ");

        String sValorHora = JOptionPane.showInputDialog(null, "Valor por hora: ");
        float valorHora = Float.valueOf(sValorHora);

        String sVagas = JOptionPane.showInputDialog(null, "Quantidade de vagas: ");
        Integer vagas = Integer.valueOf(sVagas);

        String rua = JOptionPane.showInputDialog(null, "Rua do estacionamento: ");

        String sNumero = JOptionPane.showInputDialog(null, "Número da rua: ");
        Integer numero = Integer.valueOf(sNumero);

        String bairro = JOptionPane.showInputDialog(null, "Bairro do estacionamento: ");

        String cidade = JOptionPane.showInputDialog(null, "Cidade do estacionamento: ");

        String uf = JOptionPane.showInputDialog(null, "Estado do estacionamento: ");

        estacionamento.adicionarEstacionamento(
            new Estacionamento(nome, valorHora, vagas, new Endereco(rua, numero, bairro, cidade, uf)));
      }

      String sOpcao = JOptionPane.showInputDialog(null, """
          Digite o número da opção desejada:
          0 - Adicionar estacionamento.
          1 - Remover estacionamento.
          2 - Listar estacioamentos.
          3 - Alterar as informações de algum estacionamento.
          4 - Adicionar veículo em um estacionamento.
          5 - Remover veículo de um estacionamento.
          6 - Fechar sistema.
          """);
                                                  
