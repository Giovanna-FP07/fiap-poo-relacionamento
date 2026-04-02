package br.com.fiapride.main;

import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Veiculo;
import br.com.fiapride.model.Viagem;

public class SistemaPrincipal {

    public static void main(String[] args) {

        System.out.println("--- FIAPRIDE: Inicializando Sistema ---\n");

        // Criando Passageiro e Veículo
        Passageiro ana = new Passageiro("Ana Silva", "222.222.222-22");
        Veiculo carroDoJoao = new Veiculo("ABC-1234", "Toyota Corolla");

        // Criando viagem
        Viagem viagemDaAna = new Viagem("Avenida Paulista, 1000", ana, carroDoJoao);

        // Exibir resumo antes do saldo
        viagemDaAna.exibirResumo();

        // Adicionar saldo
        System.out.println(">>> Adicionando saldo à Ana: R$ 50,00");
        ana.adicionarSaldo(50.0);

        // Exibir resumo após recarga
        viagemDaAna.exibirResumo();

        // Processar pagamento da viagem (exemplo: R$ 5,30)
        viagemDaAna.realizarPagamento(5.30);

        // Ver saldo final
        System.out.println("Saldo final de " + ana.getNome() + ": R$ " + ana.getSaldo());
    }
}
