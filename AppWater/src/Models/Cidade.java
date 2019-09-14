package Models;

import Abstracts.AbstractEntity;

public class Cidade extends AbstractEntity {

    private Estado estado;

    public Cidade() {
        super();
    }

    public Cidade(int id, String nome, Estado estado) {
        super(id, nome);
        this.setEstado(estado);
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
