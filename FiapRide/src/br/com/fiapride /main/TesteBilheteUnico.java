package br.com.fiapride.main;

import br.com.fiapride.model.BilheteUnico;
import br.com.fiapride.model.Titular;
import java.time.LocalDate;

public class TesteBilheteUnico {

    public static void main(String[] args) {
        System.out.println("=== TESTE BILHETE ÚNICO - VALORES SP ===\n");

        // Criando titular
        Titular ana = new Titular("Ana Silva", "222.222.222-22");

        // Criando bilhete estudante com saldo inicial
        BilheteUnico bilheteEstudante = new BilheteUnico(ana, "Estudante", 20.0, LocalDate.of(2026, 12, 31));

        System.out.println("Titular: " + bilheteEstudante.getTitular().getNome());
        System.out.println("Saldo inicial: R$ " + bilheteEstudante.getSaldo() + "\n");

        // Testes
        System.out.println(">>> Pagando emissão/revalidação do Bilhete Estudante (R$ 37,10)");
        bilheteEstudante.pagarEmissaoEstudante();

        System.out.println(">>> Pagando passagem de ônibus");
        bilheteEstudante.pagarPassagem();

        System.out.println(">>> Recarregando R$ 30,00");
        bilheteEstudante.recarregar(30.0);

        System.out.println(">>> Pagando emissão/revalidação do Bilhete Estudante");
        bilheteEstudante.pagarEmissaoEstudante();

        System.out.println(">>> Pagando passagem de ônibus novamente");
        bilheteEstudante.pagarPassagem();

        System.out.println("Saldo final: R$ " + bilheteEstudante.getSaldo());
    }
}
