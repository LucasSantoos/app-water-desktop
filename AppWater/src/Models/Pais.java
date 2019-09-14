package Models;

import Abstracts.AbstractEntity;

public class Pais extends AbstractEntity {

    public Pais() {
        super();
    }

    public Pais(int id, String descricao) {
        super(id, descricao);
    }
    
    public Pais(String descricao) {
        super(descricao);
    }
}
