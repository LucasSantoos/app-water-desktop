package Models;

import Abstracts.AbstractEntity;

public class PessoaTelefone extends AbstractEntity {

    private String nroTelefone;
    private Pessoa pessoa;

    public PessoaTelefone() {
        super();
    }

    public PessoaTelefone(String descricao, String nroTelefone, Pessoa pessoa) {
        super(descricao);
        this.setNroTelefone(nroTelefone);
        this.setPessoa(pessoa);
    }
    
    public PessoaTelefone(int id, String descricao, String nroTelefone, Pessoa pessoa) {
        super(id, descricao);
        this.setNroTelefone(nroTelefone);
        this.setPessoa(pessoa);
    }

    public String getNroTelefone() {
        return this.nroTelefone;
    }

    public void setNroTelefone(String nroTelefone) {
        this.nroTelefone = nroTelefone;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return this.getPessoa().getNome() + " - " + this.getNroTelefone() + " - " + this.getDescricao();
    }
}
