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

      Integer opcao = Integer.valueOf(sOpcao);

      if (opcao == 0) {
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

      else if (opcao == 1) {

        int number = 0;
        for (Estacionamento estacionament : estacionamento.getList()) {
          JOptionPane.showMessageDialog(null,
              "Observe os estacionamentos que podem ser removidos: \n" + (number + " - " + estacionament.getNome()));

          number = number + 1;
          
        }
        String sOp = JOptionPane.showInputDialog(null, "Qual estacionamento irá ser removido?");
        Integer op = Integer.valueOf(sOp);
        estacionamento.removerEstacionamento(op);

      }

      else if (opcao == 2) {
        for (Estacionamento estacionament : estacionamento.getList()) {
          JOptionPane.showMessageDialog(null, "Estacionamentos cadastrados: \n" + estacionament.getNome());
        
        }
      } else if (opcao == 3) {
        int number = 0;
        for (Estacionamento estacionament : estacionamento.getList()) {
          JOptionPane.showMessageDialog(null,
              "Qual estacionamento será alterado? \n" + (number + " - " + estacionament.getNome()));
  
          number = number + 1;
        }
        String sOp = JOptionPane.showInputDialog(null, "Qual estacionamento será alterado?");
        Integer op = Integer.valueOf(sOp);

        String option = JOptionPane.showInputDialog(null, """
            Selecione a opção desejada a ser alterada:
            0 - Nome.
            1 - Valor por hora.
            2 - Número de vagas.
            3 - Endereço.
            """);
        Integer sOpc = Integer.valueOf(option);

        if (sOpc == 0) {
          String nome = JOptionPane.showInputDialog(null, "Para qual nome você quer mudar?");
          estacionamento.getList().get(op).setNome(nome);
        } else if (sOpc == 1) {
          double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Para qual valor você quer mudar?"));
          estacionamento.getList().get(op).setValorHora(valor);
        } else if (sOpc == 2) {
          int vagas = Integer.parseInt(JOptionPane.showInputDialog(null, "Para quantas vagas você quer mudar?"));
          estacionamento.getList().get(op).setVagas(vagas);
        } else if (sOpc == 3) {


          String rua = JOptionPane.showInputDialog(null,
              "Digite as novas informações de endereço: \n Rua do estacionamento: ");

          String sNumero = JOptionPane.showInputDialog(null, "Número da rua: ");
          Integer numero = Integer.valueOf(sNumero);

          String bairro = JOptionPane.showInputDialog(null, "Bairro do estacionamento: ");

          String cidade = JOptionPane.showInputDialog(null, "Cidade do estacionamento: ");

          String uf = JOptionPane.showInputDialog(null, "Estado do estacionamento: ");

          estacionamento.getList().get(op).setEndereco(rua, numero, bairro, cidade, uf);
        }
      } else if (opcao == 4) {
        
        int number = 0;
        for (Estacionamento estacionament : estacionamento.getList()) {
          JOptionPane.showMessageDialog(null, "Observe os estacionamentos em que o veículo pode ser adicionado: \n"
              + (number + " - " + estacionament.getNome()));
          
          number = number + 1;
        }
        String sOp = JOptionPane.showInputDialog(null, "Em qual estacionamento o veículo irá ser adicionado?");
        Integer op = Integer.valueOf(sOp);
        
        if (estacionamento.getList().get(op).getVeiculos().size() < estacionamento.getList().get(op).getVagas()) {
          String placa = JOptionPane.showInputDialog(null, "Qual é a placa do veículo a ser adicionado?");
         
          estacionamento.getList().get(op).addVeiculos(new EntradaVeiculo(placa));
        } else {
          JOptionPane.showMessageDialog(null, "Todas as vagas estão preenchidas!");
          
        }
      } else if (opcao == 5) {
        
        int number = 0;
        for (Estacionamento estacionament : estacionamento.getList()) {
          JOptionPane.showMessageDialog(null, "Observe em qual estacionamento o veículo poderá ser removido: \n"
              + (number + " - " + estacionament.getNome()));
          
          number = number + 1;
        }
        String sOp = JOptionPane.showInputDialog(null, "De qual estacionamento o veículo será removido?");
        Integer op = Integer.valueOf(sOp);
        
        if (estacionamento.getList().get(op).getVeiculos().size() != 0) {
          
          String placa = JOptionPane.showInputDialog(null,
              "Qual é a placado veículo que será removido do estacionamento?");
          
          List<String> dados = estacionamento.getList().get(op).removeVeiculos(placa);
          
          JOptionPane.showMessageDialog(null, "O valor que o motorista deve pagar é de R$" + dados.get(0)
              + ". A data e hora de entrada foi: " + dados.get(1) + ", e a data e hora de saida foi: " + dados.get(2));
         
        } else {
          JOptionPane.showMessageDialog(null, "Não há veiculos cadastrados nesse estacionamento!");
          
        }
      } else if (opcao == 6) {
        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?");
        if (confirmacao == JOptionPane.YES_OPTION) {
          JOptionPane.showMessageDialog(null, "OK. Volte sempre");
          continuar = false;
        }
      }
    }
  }
}