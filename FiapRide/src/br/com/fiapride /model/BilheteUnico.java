package br.com.fiapride.model;

import java.time.LocalDate;

public class BilheteUnico {

    private Titular titular; // Nova associação
    private String tipo;     // "Estudante" ou "Comum"
    private double saldo;
    private LocalDate dataValidade;

    private static final double TAXA_EMISSAO_ESTUDANTE = 37.10;

    // Construtor agora exige o titular
    public BilheteUnico(Titular titular, String tipo, double saldo, LocalDate dataValidade) {
        this.titular = titular;

        if (!tipo.equalsIgnoreCase("Estudante") && !tipo.equalsIgnoreCase("Comum")) {
            throw new IllegalArgumentException("Tipo de bilhete inválido!");
        }
        this.tipo = tipo;
        this.saldo = saldo >= 0 ? saldo : 0;
        this.dataValidade = dataValidade;
    }

    // Getters
    public Titular getTitular() { return titular; }
    public String getTipo() { return tipo; }
    public double getSaldo() { return saldo; }
    public LocalDate getDataValidade() { return dataValidade; }

    public boolean estaVencido() {
        return dataValidade.isBefore(LocalDate.now());
    }

    private double tarifaAtual() {
        if (tipo.equalsIgnoreCase("Estudante")) return 2.65;
        return 5.30;
    }

    public boolean pagarPassagem() {
        System.out.println("Bilhete do titular: " + titular.getNome() + " (" + tipo + ")");

        if (estaVencido()) {
            System.out.println("Bilhete vencido! Pagamento não autorizado.\n");
            return false;
        }

        double valorTarifa = tarifaAtual();
        double valorDebitado = valorTarifa;

        if (saldo < valorDebitado) {
            System.out.println("Saldo insuficiente! Saldo atual: R$ " + saldo + ", valor da passagem: R$ " + valorDebitado + "\n");
            return false;
        }

        saldo -= valorDebitado;

        System.out.println("Valor da passagem: R$ " + valorTarifa);
        if (tipo.equalsIgnoreCase("Estudante")) {
            System.out.println("Desconto aplicado: 50%");
        }
        System.out.println("Valor debitado: R$ " + valorDebitado);
        System.out.println("Saldo restante: R$ " + saldo + "\n");
        return true;
    }

    public void recarregar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de recarga inválido!\n");
            return;
        }
        saldo += valor;
        System.out.println("Recarga de R$ " + valor + " realizada. Saldo atual: R$ " + saldo + "\n");
    }

    public boolean pagarEmissaoEstudante() {
        if (!tipo.equalsIgnoreCase("Estudante")) {
            System.out.println("Esta tarifa é apenas para bilhete estudantil.\n");
            return false;
        }

        if (saldo < TAXA_EMISSAO_ESTUDANTE) {
            System.out.println("Saldo insuficiente para emissão/revalidação do bilhete estudantil. Saldo atual: R$ " + saldo + "\n");
            return false;
        }

        saldo -= TAXA_EMISSAO_ESTUDANTE;
        System.out.println("Pagamento da emissão/revalidação do bilhete estudantil realizado: R$ " + TAXA_EMISSAO_ESTUDANTE);
        System.out.println("Saldo restante: R$ " + saldo + "\n");
        return true;
    }
}
