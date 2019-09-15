package Models;

import Abstracts.AbstractEntity;

public class PessoaEndereco extends AbstractEntity {

    private String numero;
    private String bairro;
    private Pessoa pessoa;
    private Cidade cidade;

    public PessoaEndereco() {
        super();
    }
    
    public PessoaEndereco(String descricao, String numero, String bairro, Pessoa pessoa, Cidade cidade) {
        super(descricao);
        this.setNumero(numero);
        this.setBairro(bairro);
        this.setPessoa(pessoa);
        this.setCidade(cidade);
    }
    
    public PessoaEndereco(int id, String descricao, String numero, String bairro, Pessoa pessoa, Cidade cidade) {
        super(id, descricao);
        this.setNumero(numero);
        this.setBairro(bairro);
        this.setPessoa(pessoa);
        this.setCidade(cidade);
    }

    public String getNumero() {
        return this.numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Pessoa getPessoa() {
        return this.pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return this.pessoa.getNome() + " - " + this.getDescricao() + ", " + this.numero + ", " + this.getBairro();
    }
}
