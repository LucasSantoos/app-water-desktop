package Abstracts;

abstract public class AbstractEntity implements java.io.Serializable {

    private int id;
    private String descricao;

    public AbstractEntity() {
        this.setId(0);
        this.setDescricao("padrão");
    }

    public AbstractEntity(int id, String nome) {
        this.setId(id);
        this.setDescricao(nome);
    }
    
    public AbstractEntity(String nome) {
        this.setDescricao(nome);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.trim().isEmpty() ? "PADRÃO" : descricao.toUpperCase();
    }

    public int getId() {
        return this.id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AbstractEntity other = (AbstractEntity) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
