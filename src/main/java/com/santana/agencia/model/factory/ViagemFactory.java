package com.santana.agencia.model.factory;
import com.santana.agencia.model.factory.ModalFactory;
import com.santana.agencia.model.entity.*;

import java.time.LocalDate;

public class ViagemFactory {

    public static Viagem criarViagem(String tipo, Pacote pacote, Modal modal, Fornecedor fornecedor) {
        Viagem viagem = new Viagem();
        viagem.setDestino(pacote.getDestino());

        LocalDate hoje = LocalDate.now();

        switch (tipo.toUpperCase()) {
            case "ECONOMICA":
                viagem.setPreco(pacote.getPreco() * 0.9);
                viagem.setDataInicio(hoje.plusDays(7));
                viagem.setDataFim(hoje.plusDays(14));
                break;
            case "CONFORTO":
                viagem.setPreco(pacote.getPreco());
                viagem.setDataInicio(hoje.plusDays(14));
                viagem.setDataFim(hoje.plusDays(21));
                break;
            case "PREMIUM":
                viagem.setPreco(pacote.getPreco() * 1.5);
                viagem.setDataInicio(hoje.plusDays(21));
                viagem.setDataFim(hoje.plusDays(28));
                break;
            default:
                throw new IllegalArgumentException("Tipo de viagem não suportado: " + tipo);
        }

        return viagem;
    }

    public static Viagem criarViagemPersonalizada(Pacote pacote, Modal modal, Fornecedor fornecedor,
                                                  double preco, LocalDate dataInicio, LocalDate dataFim) {
        Viagem viagem = new Viagem();
        viagem.setDestino(pacote.getDestino());
        viagem.setPreco(preco);
        viagem.setDataInicio(dataInicio);
        viagem.setDataFim(dataFim);
        return viagem;
    }
}
