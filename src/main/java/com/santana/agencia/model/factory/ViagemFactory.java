package com.santana.agencia.model.factory;

import com.santana.agencia.model.entity.*;
import com.santana.agencia.model.enums.TipoViagem;

import java.time.LocalDate;

public class ViagemFactory {

    public static Viagem criarViagem(Viagem tipo, Pacote pacote, Modal modal, Fornecedor fornecedor) {
        Viagem viagem = new Viagem();
        viagem.setPacote(pacote);
        viagem.setModal(modal);
        viagem.setFornecedor(fornecedor);
        viagem.setDestino(pacote.getDestino());
        
        LocalDate hoje = LocalDate.now();
        
        switch (tipo) {
            case ECONOMICA:
                viagem.setPreco(pacote.getPreco() * 0.9);
                viagem.setDataInicio(hoje.plusDays(7));
                viagem.setDataFim(hoje.plusDays(14));
                viagem.setVagas(50);
                break;
            case CONFORTO:
                viagem.setPreco(pacote.getPreco());
                viagem.setDataInicio(hoje.plusDays(14));
                viagem.setDataFim(hoje.plusDays(21));
                viagem.setVagas(30);
                break;
            case PREMIUM:
                viagem.setPreco(pacote.getPreco() * 1.5);
                viagem.setDataInicio(hoje.plusDays(21));
                viagem.setDataFim(hoje.plusDays(28));
                viagem.setVagas(15);
                break;
            default:
                throw new IllegalArgumentException("Tipo de viagem não suportado: " + tipo);
        }
        
        return viagem;
    }

    public static Viagem criarViagemPersonalizada(Pacote pacote, Modal modal, Fornecedor fornecedor,
                                                 double preco, LocalDate dataInicio, LocalDate dataFim, int vagas) {
        Viagem viagem = new Viagem();
        viagem.setPacote(pacote);
        viagem.setModal(modal);
        viagem.setFornecedor(fornecedor);
        viagem.setDestino(pacote.getDestino());
        viagem.setPreco(preco);
        viagem.setDataInicio(dataInicio);
        viagem.setDataFim(dataFim);
        viagem.setVagas(vagas);
        return viagem;
    }
}
