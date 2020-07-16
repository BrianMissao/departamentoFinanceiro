import classes.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InteracaoComOUsuario {
    private static Scanner scanner = new Scanner(System.in);
    private static Funcionario funcionario;
    private static List<Funcionario> listaDeFuncionarios = new ArrayList<>();

    public static void main(String[] args) {
        int numeroDeFuncionariosAAdicionar = Integer.parseInt(obterDados("Digite o número de funcionários que deseja adicionar:"));
        adicionarFuncionariosALista(numeroDeFuncionariosAAdicionar);
        imprimirListaDeFuncionarios();
        aumentarSalarioDoFuncionario();
        imprimirListaDeFuncionarios();
    }

    private static void aumentarSalarioDoFuncionario() {
        int idDoFuncionarioATerOSalarioAumentado = Integer.parseInt(obterDados("Digite o ID do felizardo:"));
        for (Funcionario funcionario : listaDeFuncionarios) {
            if (funcionario.getId() == idDoFuncionarioATerOSalarioAumentado) {
                int porcentagemDeAumento = Integer.parseInt(obterDados("Digite a porcentagem a aumentar:"));
                funcionario.aumentarSalarioComBaseEmUmaPorcentagemDada(porcentagemDeAumento);
                System.out.println("Operação realizada com sucesso!");
                return;
            }
        }
        System.out.println("Este ID não existe.");
    }

    private static void imprimirListaDeFuncionarios() {
        int numeroDoFuncionarioSendoImpresso = 1;
        for (Funcionario funcionario : listaDeFuncionarios) {
            System.out.printf("*Funcionário de número %d%nID: %d%nNome: %s%nSalário: %.2f%n", numeroDoFuncionarioSendoImpresso, funcionario.getId(), funcionario.getNome(), funcionario.getSalarioBruto());
            numeroDoFuncionarioSendoImpresso++;
        }
    }

    private static void adicionarFuncionariosALista(int numeroDeFuncionariosAAdicionar) {
        if (numeroDeFuncionariosAAdicionar == 0) {
            System.out.println("O número de funcionários a adicionar deve ser maior que 0.");
        }
        int numeroDoFuncionarioSendoAdicionado = 1;
        while (numeroDoFuncionarioSendoAdicionado <= numeroDeFuncionariosAAdicionar) {
            System.out.println("Funcionario de número " + numeroDoFuncionarioSendoAdicionado);
            int idFuncionario = Integer.parseInt(obterDados("Digite o ID do funcionário:"));
            if (idJaExiste(idFuncionario)) {
                System.out.println("Id já existe, por favor escolha outro:");
                continue;
            }
            String nomeFuncionario = obterDados("Digite o nome do Funcionário:");
            double salarioDoFuncionario = Double.parseDouble(obterDados("Digite o salário:"));
            listaDeFuncionarios.add(new Funcionario(nomeFuncionario, idFuncionario, salarioDoFuncionario));
            System.out.println("Funcionário adicionado com sucesso!");
            numeroDoFuncionarioSendoAdicionado++;
        }
    }

    private static boolean idJaExiste(int idFuncionario) {
        for (Funcionario funcionario : listaDeFuncionarios) {
            if (funcionario.getId() == idFuncionario) {
                return true;
            }
        }
        return false;
    }

    private static String obterDados(String mensagemAoUsuario) {
        System.out.println(mensagemAoUsuario);
        return scanner.nextLine();
    }
}
