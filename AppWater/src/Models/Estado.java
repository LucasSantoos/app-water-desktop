package Models;

import Abstracts.AbstractEntity;

public class Estado extends AbstractEntity {

    private Pais pais = new Pais(12, "Brasil");

    public Estado() {
        super();
    }

    public Estado(String descricao, Pais pais) {
        super(descricao);
        setPais(pais);
    }
    public Estado(int id, String descricao, Pais pais) {
        super(id, descricao);
        setPais(pais);
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Pais getPais() {
        return this.pais;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }
   
}
