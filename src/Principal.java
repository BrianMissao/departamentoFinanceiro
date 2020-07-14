import classes.Funcionario;

import java.util.Scanner;

public class Principal {
    private static Scanner scanner = new Scanner(System.in);
    private static Funcionario funcionario;

    public static void main(String[] args) {
        String nome = obterDados("Digite o nome do Funcionário:");
        double salarioBruto = Double.parseDouble(obterDados("Digite o salário bruto: "));
        double imposto = Double.parseDouble(obterDados("Digite o imposto: "));
        funcionario = new Funcionario(nome, salarioBruto, imposto);
        imprimirInformacoesDoFuncionario();
        int porcentagem = Integer.parseInt(obterDados("Digite a porcentagem de aumento: "));
        funcionario.almentarSalarioComBaseNumaPorcentagemDada(porcentagem);
        funcionario.atualizarSalario();
        imprimirInformacoesDoFuncionario();
    }

    private static String obterDados(String mensagemAoUsuario) {
        System.out.println(mensagemAoUsuario);
        return scanner.nextLine();
    }

    private static void imprimirInformacoesDoFuncionario() {
        System.out.printf("Nome: %s%nSalário bruto: %.2f%nImposto: %.2f%nSalário líquido: %.2f%n", funcionario.getNome(), funcionario.getSalarioBruto(), funcionario.getImposto(), funcionario.getSalarioLiquido());
    }
}
