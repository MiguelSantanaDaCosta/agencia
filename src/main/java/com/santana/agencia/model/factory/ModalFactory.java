package com.santana.agencia.model.factory;

import com.santana.agencia.model.entity.Modal;
import com.santana.agencia.model.enums.TipoModal;

public class ModalFactory {

    public static Modal criarModal(TipoModal tipo) {
        Modal modal = new Modal();
        modal.setTipo(tipo.name());
        
        switch (tipo) {
            case AEREO:
                modal.setPreco(1000.00);
                break;
            case RODOVIARIO:
                modal.setPreco(500.00);
                break;
            case FERROVIARIO:
                modal.setPreco(700.00);
                break;
            case HIDROVIARIO:
                modal.setPreco(900.00);
                break;
            default:
                throw new IllegalArgumentException("Tipo de modal não suportado: " + tipo);
        }
        
        return modal;
    }

    public static Modal criarModalPersonalizado(TipoModal tipo, double preco) {
        Modal modal = new Modal();
        modal.setTipo(tipo.name());
        modal.setPreco(preco);
        return modal;
    }
}
