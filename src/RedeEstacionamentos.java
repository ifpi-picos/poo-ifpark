import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RedeEstacionamentos {
    public static void main(String[] args) throws Exception {

        List<Estacionamento> estacionamentos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while(continuar == true){

            if (estacionamentos.size() == 0) {
                System.out.println("Não há nenhum estacionamento cadastrado, adicione um:");

                System.out.println("Nome:");
                String nome = scanner.nextLine();
    
                System.out.println("Valor por hora:");
                float valorHora = scanner.nextFloat();
                scanner.nextLine();
    
                System.out.println("Vagas:");
                int vagas = scanner.nextInt();
                scanner.nextLine();
                
                System.out.println("Rua:");            
                String rua = scanner.nextLine();
    
                System.out.println("Número:");
                int numero = scanner.nextInt();
                scanner.nextLine();
    
                System.out.println("Bairro:");
                String bairro = scanner.nextLine();
    
                System.out.println("Cidade:");
                String cidade = scanner.nextLine();
    
                System.out.println("Estado:");
                String uf = scanner.nextLine();
                
                estacionamentos.add(new Estacionamento(nome, valorHora, vagas, new Endereco(rua, numero, bairro, cidade, uf)));
            } 

            System.out.println("Selecione o que você quer fazer:");
            System.out.println("0 - Adicionar estacionamento.");
            System.out.println("1 - Remover estacionamento.");
            System.out.println("2 - Listar estacioamentos.");
            System.out.println("3 - Adicionar veículo em um estacionamento.");
            System.out.println("4 - Remover veículo de um estacionamento.");
            System.out.println("5 - Fechar sistema.");

            int opcao = scanner.nextInt();

            if (opcao == 0) {
                System.out.println("Nome:");
                String nome = scanner.nextLine();
    
                System.out.println("Valor por hora:");
                float valorHora = scanner.nextFloat();
                scanner.nextLine();
    
                System.out.println("Vagas:");
                int vagas = scanner.nextInt();
                scanner.nextLine();
                
                System.out.println("Rua:");            
                String rua = scanner.nextLine();
    
                System.out.println("Número:");
                int numero = scanner.nextInt();
                scanner.nextLine();
    
                System.out.println("Bairro:");
                String bairro = scanner.nextLine();
    
                System.out.println("Cidade:");
                String cidade = scanner.nextLine();
    
                System.out.println("Estado:");
                String uf = scanner.nextLine();
                
                estacionamentos.add(new Estacionamento(nome, valorHora, vagas, new Endereco(rua, numero, bairro, cidade, uf)));
                System.out.println(estacionamentos);
            }
            else if (opcao == 1) {

            }
            else if (opcao == 2) {
                for(Estacionamento estacionamento : estacionamentos) {
                    System.out.println(estacionamento.getNome());
                }
            }
            else if (opcao == 3) {
                System.out.println("Selecione em qual estacionamento será adicionado o veículo:");
                int number = 0;
                for(Estacionamento estacionamento : estacionamentos) {
                    System.out.println(number + " - " + estacionamento.getNome());
                    number = number + 1;
                }
                int op = scanner.nextInt();
                scanner.nextLine();
                if (estacionamentos.get(op).getVeiculos().size() < estacionamentos.get(op).getVagas()) {
                    System.out.println("Qual a placa do veículo:");
                    String placa = scanner.nextLine();
                    estacionamentos.get(op).addVeiculos(new EntradaVeiculo(placa));
                    System.out.println(estacionamentos.get(op).getVeiculos());
                }
                else {
                    System.out.println("Todas as vagas estão preenchidas");
                }
            }
            else if (opcao == 4) {
                System.out.println("Selecione de qual estacionamento será removido o veículo:");
                int number = 0;
                for(Estacionamento estacionamento : estacionamentos) {
                    System.out.println(number + " - " + estacionamento.getNome());
                    number = number + 1;
                }
                int op = scanner.nextInt();
                if (estacionamentos.get(op).getVeiculos().size() != 0) {
                    scanner.nextLine();
                    System.out.println("Qual a placa do veículo:");
                    String placa = scanner.nextLine();
                    estacionamentos.get(op).removeVeiculos(placa);
                    System.out.println(estacionamentos.get(op).getVeiculos());
                }
                else {
                    System.out.println("Não há nenhum veículos nesse estacionamento.");
                }
            }
            else if (opcao == 5) {
                continuar = false;
            }
        }
    }
}