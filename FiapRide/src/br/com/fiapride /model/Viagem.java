package br.com.fiapride.model;

public class Viagem {

    // Atributos simples
    private String destino;
    private double valor;

    // Atributos de associação
    private Passageiro solicitante;
    private Veiculo veiculoUtilizado;

    // Construtor
    public Viagem(String destino, Passageiro solicitante, Veiculo veiculoUtilizado) {
        this.destino = destino;
        this.solicitante = solicitante;
        this.veiculoUtilizado = veiculoUtilizado;
        this.valor = 0.0;
        System.out.println("Nova viagem solicitada para: " + this.destino);
    }

    // Exibir resumo
    public void exibirResumo() {
        System.out.println("\n--- RESUMO DA VIAGEM ---");
        System.out.println("Destino: " + this.destino);
        System.out.println("Passageiro: " + this.solicitante.getNome());
        System.out.println("Saldo atual do passageiro: R$ " + this.solicitante.getSaldo());
        System.out.println("Veículo: " + this.veiculoUtilizado.getModelo() + " (Placa: " + this.veiculoUtilizado.getPlaca() + ")");
        System.out.println("------------------------\n");
    }

    // Realizar pagamento
    public void realizarPagamento(double custo) {
        System.out.println(">>> Processando pagamento da viagem para " + solicitante.getNome());
        solicitante.pagarViagem(custo);
        System.out.println();
    }

    // Getters
    public String getDestino() { return destino; }
    public Passageiro getSolicitante() { return solicitante; }
    public Veiculo getVeiculoUtilizado() { return veiculoUtilizado; }
}
