import java.util.Scanner;

public class Teste {
    public static void main(String[] args) throws Exception {

        RedeEstacionamentos estacionamento = new RedeEstacionamentos();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while(continuar == true){

            if (estacionamento.getSize() == 0) {
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
                
                estacionamento.adicionarEstacionamento(new Estacionamento(nome, valorHora, vagas, new Endereco(rua, numero, bairro, cidade, uf)));
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
                
                estacionamento.adicionarEstacionamento(new Estacionamento(nome, valorHora, vagas, new Endereco(rua, numero, bairro, cidade, uf)));
                System.out.println(estacionamento.getList());
            }
            else if (opcao == 1) {
                System.out.println("Selecione qual estacionamento será removido:");
                int number = 0;
                for(Estacionamento estacionament : estacionamento.getList()) {
                    System.out.println(number + " - " + estacionament.getNome());
                    number = number +1;
                }
                int op = scanner.nextInt();
                System.out.println(estacionamento.getList());
                estacionamento.removerEstacionamento(op);
            }
            else if (opcao == 2) {
                for(Estacionamento estacionament : estacionamento.getList()) {
                    System.out.println(estacionament.getNome());
                }
            }
            else if (opcao == 3) {
                System.out.println("Selecione em qual estacionamento será adicionado o veículo:");
                int number = 0;
                for(Estacionamento estacionament : estacionamento.getList()) {
                    System.out.println(number + " - " + estacionament.getNome());
                    number = number + 1;
                }
                int op = scanner.nextInt();
                scanner.nextLine();
                if (estacionamento.getList().get(op).getVeiculos().size() < estacionamento.getList().get(op).getVagas()) {
                    System.out.println("Qual a placa do veículo:");
                    String placa = scanner.nextLine();
                    estacionamento.getList().get(op).addVeiculos(new EntradaVeiculo(placa));
                    System.out.println(estacionamento.getList().get(op).getVeiculos());
                }
                else {
                    System.out.println("Todas as vagas estão preenchidas");
                }
            }
            else if (opcao == 4) {
                System.out.println("Selecione de qual estacionamento será removido o veículo:");
                int number = 0;
                for(Estacionamento estacionament : estacionamento.getList()) {
                    System.out.println(number + " - " + estacionament.getNome());
                    number = number + 1;
                }
                int op = scanner.nextInt();
                if (estacionamento.getList().get(op).getVeiculos().size() != 0) {
                    scanner.nextLine();
                    System.out.println("Qual a placa do veículo:");
                    String placa = scanner.nextLine();
                    estacionamento.getList().get(op).removeVeiculos(placa);
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