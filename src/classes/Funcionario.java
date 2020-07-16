package classes;

import sun.reflect.generics.tree.VoidDescriptor;

public class Funcionario {
    private String nome;

    public int getId() {
        return id;
    }

    private int id;
    private double salarioBruto;
    private double imposto;
    private double salarioLiquido;

    public Funcionario(String nome, double salarioBruto, double imposto) {
        this.nome = nome;
        this.salarioBruto = salarioBruto;
        this.imposto = imposto;
        this.salarioLiquido = salarioBruto - imposto;
    }

    public Funcionario(String nome, int id, double salarioBruto) {
        this.nome = nome;
        this.id = id;
        this.salarioBruto = salarioBruto;
        this.imposto = 0.00;
        this.salarioLiquido = salarioBruto - imposto;
    }

    public void aumentarSalarioComBaseEmUmaPorcentagemDada(int porcentagem) {
        this.salarioBruto += salarioBruto*porcentagem/100;
    }

    public void atualizarSalario() {
        this.salarioLiquido = salarioBruto - imposto;
        System.out.println("Uma atualização de dados foi feita.");
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double getImposto() {
        return imposto;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }
}
